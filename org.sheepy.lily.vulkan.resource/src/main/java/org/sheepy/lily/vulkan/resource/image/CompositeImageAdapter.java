package org.sheepy.lily.vulkan.resource.image;

import org.eclipse.emf.common.notify.Notification;
import org.joml.Vector2i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.LongNotification;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.lily.vulkan.core.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.resource.CompositeImage;
import org.sheepy.lily.vulkan.model.resource.ImageInlay;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.EnumSet;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@Statefull
@Adapter(scope = CompositeImage.class)
public final class CompositeImageAdapter extends Notifier implements IImageAdapter
{
	private final CompositeImage image;

	private VkImage imageBackend;
	private VkImageView imageView;
	private IAllocationConfigurator configurator;

	private CompositeImageAdapter(CompositeImage image)
	{
		super(Features.values().length);

		this.image = image;
	}

	@Override
	public void configureAllocation(final IAllocationConfigurator configurator, final InternalExecutionContext context)
	{
		this.configurator = configurator;

		final var background = image.getBackground();
		if (background != null)
		{
			final var backgroundAdapter = background.adapt(IImageAdapter.class);
			configurator.addDependencies(List.of(backgroundAdapter));
		}
	}

	@NotifyChanged(featureIds = {VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND, VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS})
	private void notifyChanged(Notification notification)
	{
		if (configurator != null)
		{
			configurator.clearDependencies();
			configurator.setDirty();

			final var background = image.getBackground();
			if (background != null)
			{
				final var backgroundAdapter = background.adapt(IImageAdapter.class);
				configurator.addDependencies(List.of(backgroundAdapter));
			}
		}
	}

	@Override
	public void allocate(InternalExecutionContext context)
	{
		final var background = image.getBackground();
		final var backgroundAdapter = background.adapt(IImageAdapter.class);
		final var vkDevice = context.getVkDevice();
		final var vkBackground = backgroundAdapter.getVkImage();
		final var builder = new VkImage.VkImageBuilder(image, vkBackground.width, vkBackground.height).initialLayout(
				null);

		imageBackend = builder.build();
		imageBackend.allocate(context);

		imageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
		imageView.allocate(vkDevice, imageBackend);

		context.execute(this::assembleImage);

		fireNotification(new LongNotification(this, Features.Image, 0, imageBackend.getPtr()));
		fireNotification(new LongNotification(this, Features.View, 0, imageView.getPtr()));
	}

	private void assembleImage(InternalExecutionContext context, ICommandBuffer<?> commandBuffer)
	{
		final var background = image.getBackground();
		final var backgroundAdapter = background.adapt(IImageAdapter.class);
		final var vkBackground = backgroundAdapter.getVkImage();
		final var initialLayout = image.getInitialLayout();

		final var srcPtr = vkBackground.getPtr();
		final var trgPtr = imageBackend.getPtr();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var stack = context.stack();
		final var region = VkImageCopy.callocStack(1, stack);

		fillRegion(region.get(0), vkBackground.width, vkBackground.height);

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
			blitInlay(vkCommandBuffer, stack, imageBackend, blitRegion, inlay);
		}

		imageBackend.transitionImageLayout(stack,
										   vkCommandBuffer,
										   EPipelineStage.TRANSFER_BIT,
										   initialLayout.getStage(),
										   EImageLayout.TRANSFER_DST_OPTIMAL,
										   initialLayout.getLayout(),
										   EnumSet.of(EAccess.TRANSFER_WRITE_BIT),
										   initialLayout.getAccessMask());
	}

	private static void blitInlay(final VkCommandBuffer vkCommandBuffer,
								  final MemoryStack stack,
								  final VkImage imageBackend,
								  final VkImageBlit.Buffer blitRegion,
								  final ImageInlay inlay)
	{
		final var imageInlayAdapter = inlay.getImage().adapt(IImageAdapter.class);
		final var vkImageInlay = imageInlayAdapter.getVkImage();
		final var imageInlayPtr = imageInlayAdapter.getImagePtr();
		final var size = inlay.getSize();
		final var trgSize = new Vector2i(Math.round(vkImageInlay.width * size), Math.round(vkImageInlay.height * size));
		final var inlayPosition = inlay.getPosition();

		final int trgX = UIUtil.computeXRelative(inlay.getHorizontalRelative(),
												 imageBackend.width,
												 inlayPosition.x(),
												 trgSize.x);

		final int trgY = UIUtil.computeYRelative(inlay.getVerticalRelative(),
												 imageBackend.height,
												 inlayPosition.y(),
												 trgSize.y);

		fillRegion(blitRegion.get(0),
				   vkImageInlay.width,
				   vkImageInlay.height,
				   trgX,
				   trgY,
				   trgX + trgSize.x,
				   trgY + trgSize.y);

		vkImageInlay.transitionFromInitialLayout(stack,
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

		vkImageInlay.transitionToInitialLayout(stack,
											   vkCommandBuffer,
											   EPipelineStage.TRANSFER_BIT,
											   EImageLayout.TRANSFER_SRC_OPTIMAL,
											   EnumSet.of(EAccess.TRANSFER_READ_BIT));
	}

	@Override
	public void free(InternalExecutionContext context)
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
	public long getMemoryPtr()
	{
		return imageBackend.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend;
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
