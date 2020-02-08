package org.sheepy.lily.vulkan.process.graphic.resource;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.attachment.IDepthAttachmentAdapter;
import org.sheepy.lily.vulkan.core.resource.image.ImageUtil;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

@Statefull
@Adapter(scope = DepthAttachment.class)
public class DepthAttachmentAdapter implements IDepthAttachmentAdapter
{
	private VkImage depthImageBackend;
	private VkImageView depthImageView;
	private int depthFormat;

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();

		config.addDependencies(List.of(surfaceManager));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		depthFormat = findDepthFormat(context.getPhysicalDevice());

		createDepthImage(context);
		allocateDepthImage(context);

		createAndAllocateImageView(context.getLogicalDevice());

		layoutTransitionOfDepthImage(context);
	}

	private void createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		final var device = logicalDevice.getVkDevice();
		depthImageView = new VkImageView(VK_IMAGE_ASPECT_DEPTH_BIT);
		depthImageView.allocate(device, depthImageBackend);
	}

	private void allocateDepthImage(IGraphicContext context)
	{
		depthImageBackend.allocate(context);
	}

	private void createDepthImage(IGraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		final var extent = surfaceManager.getExtent();
		final int width = extent.width;
		final int height = extent.height;
		final int usage = VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT;
		final var depthImageBuilder = VkImage.newBuilder(width, height, depthFormat);
		depthImageBuilder.usage(usage);

		depthImageBackend = depthImageBuilder.build();
	}

	private void layoutTransitionOfDepthImage(InternalExecutionContext context)
	{
		final var stack = context.stack();
		final var barrierInfo = VkImageMemoryBarrier.callocStack(1, stack);
		final var srcStage = EPipelineStage.TOP_OF_PIPE_BIT_VALUE;
		final var dstStage = EPipelineStage.EARLY_FRAGMENT_TESTS_BIT_VALUE;
		final var srcLayout = EImageLayout.UNDEFINED;
		final var dstLayout = EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL;
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, depthFormat);

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.image(depthImageBackend.getPtr());
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(1);
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspectMask);
		barrierInfo.dstAccessMask(EAccess.DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE
				| EAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE);

		context.execute((	context2,
							commandBuffer) -> vkCmdPipelineBarrier(	commandBuffer.getVkCommandBuffer(),
																	srcStage,
																	dstStage,
																	0,
																	null,
																	null,
																	barrierInfo));
	}

	private static int findDepthFormat(PhysicalDevice physicalDevice)
	{
		return physicalDevice.findSupportedFormat(new int[] {
				VK_FORMAT_D32_SFLOAT, VK_FORMAT_D32_SFLOAT_S8_UINT, VK_FORMAT_D24_UNORM_S8_UINT
		}, VK_IMAGE_TILING_OPTIMAL, VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	@Override
	public void free(IGraphicContext context)
	{
		final var device = context.getVkDevice();
		depthImageView.free(device);
		depthImageBackend.free(context);
	}

	@Override
	public long getImageId()
	{
		return depthImageBackend.getPtr();
	}

	@Override
	public long getImageViewId()
	{
		return depthImageView.getPtr();
	}

	@Override
	public int getImageFormat()
	{
		return depthFormat;
	}
}
