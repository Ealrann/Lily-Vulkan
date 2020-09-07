package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageCopy;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.image.*;
import org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.EnumSet;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = CompositeImage.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(features = VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND, type = IVkImageAllocation.class)
@AllocationDependency(features = {VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS, VulkanResourcePackage.IMAGE_INLAY__IMAGE}, type = IVkImageAllocation.class)
public final class CompositeImageAllocation implements IVkImageAllocation
{
	private final CompositeImage image;
	private final IAllocationState allocationState;
	private final IVkImageAllocation background;

	private ImageBackend imageBackend;
	private VkImageView imageView;

	private CompositeImageAllocation(CompositeImage image,
									 ExecutionContext context,
									 IAllocationState allocationState,
									 @InjectDependency(index = 0) IVkImageAllocation background)
	{
		this.image = image;
		this.allocationState = allocationState;
		this.background = background;

		final var vkDevice = context.getVkDevice();
		final var vkBackground = this.background.getVkImage();
		final var builder = new VkImageBuilder(image.getName(),
											   image,
											   vkBackground.width(),
											   vkBackground.height()).initialLayout(null);

		imageBackend = context.executeFunction(builder::build);
		imageView = new VkImageView(vkDevice, image.getName(), imageBackend.vkImage(), VK_IMAGE_ASPECT_COLOR_BIT);

		context.executeCommand(this::assembleImage);
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	private void assembleImage(IRecordContext recordContext)
	{
		final var vkBackground = background.getVkImage();
		final var initialLayout = image.getInitialLayout();

		final var srcPtr = vkBackground.getPtr();
		final var trgPtr = imageBackend.getPtr();
		final var vkCommandBuffer = recordContext.vkCommandBuffer();
		final var stack = recordContext.stack();
		final var region = VkImageCopy.callocStack(1, stack);

		fillRegion(region.get(0), vkBackground.width(), vkBackground.height());

		imageBackend.transitionImageLayout(stack,
										   vkCommandBuffer,
										   EPipelineStage.TOP_OF_PIPE_BIT,
										   EPipelineStage.TRANSFER_BIT,
										   EImageLayout.UNDEFINED,
										   EImageLayout.TRANSFER_DST_OPTIMAL,
										   List.of(),
										   List.of(EAccess.TRANSFER_WRITE_BIT));

		vkCmdCopyImage(vkCommandBuffer,
					   srcPtr,
					   EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE,
					   trgPtr,
					   EImageLayout.TRANSFER_DST_OPTIMAL_VALUE,
					   region);

		final var blitRegion = VkImageBlit.callocStack(1, stack);
		for (var inlay : image.getInlays())
		{
			blitInlay(vkCommandBuffer, stack, imageBackend.vkImage(), blitRegion, inlay);
		}

		imageBackend.transitionImageLayout(stack,
										   vkCommandBuffer,
										   EPipelineStage.TRANSFER_BIT,
										   EPipelineStage.TRANSFER_BIT,
										   EImageLayout.TRANSFER_DST_OPTIMAL,
										   initialLayout,
										   EnumSet.of(EAccess.TRANSFER_WRITE_BIT),
										   List.of());
	}

	private static void blitInlay(final VkCommandBuffer vkCommandBuffer,
								  final MemoryStack stack,
								  final VkImage imageBackend,
								  final VkImageBlit.Buffer blitRegion,
								  final ImageInlay inlay)
	{
		final var imageInlayAdapter = inlay.getImage().adapt(IVkImageAllocation.class);
		final var vkImageInlay = imageInlayAdapter.getVkImage();
		final var inlayBackend = imageInlayAdapter.getImageBackend();
		final var imageInlayPtr = imageInlayAdapter.getImagePtr();
		final var size = inlay.getSize();
		final var trgSize = new Vector2i(Math.round(vkImageInlay.width() * size),
										 Math.round(vkImageInlay.height() * size));
		final var inlayPosition = inlay.getPosition();

		final int trgX = UIUtil.computeXRelative(inlay.getHorizontalRelative(),
												 imageBackend.width(),
												 inlayPosition.x(),
												 trgSize.x);

		final int trgY = UIUtil.computeYRelative(inlay.getVerticalRelative(),
												 imageBackend.height(),
												 inlayPosition.y(),
												 trgSize.y);

		fillRegion(blitRegion.get(0),
				   vkImageInlay.width(),
				   vkImageInlay.height(),
				   trgX,
				   trgY,
				   trgX + trgSize.x,
				   trgY + trgSize.y);

		inlayBackend.transitionFromInitialLayout(stack,
												 vkCommandBuffer,
												 EPipelineStage.TRANSFER_BIT,
												 EImageLayout.TRANSFER_SRC_OPTIMAL,
												 EnumSet.of(EAccess.TRANSFER_READ_BIT));

		vkCmdBlitImage(vkCommandBuffer,
					   imageInlayPtr,
					   EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE,
					   imageBackend.getPtr(),
					   EImageLayout.TRANSFER_DST_OPTIMAL_VALUE,
					   blitRegion,
					   EFilter.LINEAR_VALUE);

		inlayBackend.transitionToInitialLayout(stack,
											   vkCommandBuffer,
											   EPipelineStage.TRANSFER_BIT,
											   EImageLayout.TRANSFER_SRC_OPTIMAL,
											   EnumSet.of(EAccess.TRANSFER_READ_BIT));
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
		imageView = null;

		imageBackend.free(context);
		imageBackend = null;
	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend.vkImage();
	}

	@Override
	public ImageBackend getImageBackend()
	{
		return imageBackend;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width(), vkImage.height());
	}

	private static void fillRegion(VkImageCopy region, final int width, final int height)
	{
		region.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.srcSubresource().mipLevel(0);
		region.srcSubresource().baseArrayLayer(0);
		region.srcSubresource().layerCount(1);
		region.srcOffset().x(0);
		region.srcOffset().y(0);
		region.srcOffset().z(0);
		region.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.dstSubresource().mipLevel(0);
		region.dstSubresource().baseArrayLayer(0);
		region.dstSubresource().layerCount(1);
		region.dstOffset().x(0);
		region.dstOffset().y(0);
		region.dstOffset().z(0);
		region.extent().width(width);
		region.extent().height(height);
		region.extent().depth(1);
	}

	private static void fillRegion(VkImageBlit region,
								   final int srcWidth,
								   final int srcHeight,
								   int dstX1,
								   int dstY1,
								   int dstX2,
								   int dstY2)
	{
		region.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.srcSubresource().mipLevel(0);
		region.srcSubresource().baseArrayLayer(0);
		region.srcSubresource().layerCount(1);
		region.srcOffsets(0).x(0);
		region.srcOffsets(0).y(0);
		region.srcOffsets(0).z(0);
		region.srcOffsets(1).x(srcWidth);
		region.srcOffsets(1).y(srcHeight);
		region.srcOffsets(1).z(1);
		region.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.dstSubresource().mipLevel(0);
		region.dstSubresource().baseArrayLayer(0);
		region.dstSubresource().layerCount(1);
		region.dstOffsets(0).x(dstX1);
		region.dstOffsets(0).y(dstY1);
		region.dstOffsets(0).z(0);
		region.dstOffsets(1).x(dstX2);
		region.dstOffsets(1).y(dstY2);
		region.dstOffsets(1).z(1);
	}
}
