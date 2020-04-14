package org.sheepy.lily.vulkan.process.graphic.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.attachment.IDepthAttachmentAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@Statefull
@Adapter(scope = DepthAttachment.class)
public final class DepthAttachmentAdapter extends Notifier<IVkImageAdapter.Features> implements IDepthAttachmentAdapter,
																								IAllocableAdapter<GraphicContext>
{
	private final DepthAttachment depthAttachment;
	private VkImage depthImageBackend;
	private VkImageView depthImageView;
	private int depthFormat;

	public DepthAttachmentAdapter(DepthAttachment depthAttachment)
	{
		super(List.of(Features.Image, Features.View));
		this.depthAttachment = depthAttachment;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		config.addDependencies(List.of(surfaceManager));
	}

	@Override
	public void allocate(GraphicContext context)
	{
		depthFormat = findDepthFormat(context.getPhysicalDevice());
		createDepthImage(context);
		createAndAllocateImageView(context.getLogicalDevice());
		layoutTransitionOfDepthImage(context);

		notify(Features.View, getViewPtr());
	}

	private void createDepthImage(GraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		final var extent = surfaceManager.getExtent();
		final int width = extent.x();
		final int height = extent.y();
		final int usages = VulkanModelUtil.getEnumeratedFlag(depthAttachment.getUsages()) |
						   VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT;

		final var depthImageBuilder = VkImage.newBuilder(width, height, depthFormat);
		depthImageBuilder.usage(usages);
		depthImageBuilder.aspect(VK_IMAGE_ASPECT_DEPTH_BIT);

		depthImageBackend = depthImageBuilder.build(context);
	}

	private void createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		final var device = logicalDevice.getVkDevice();
		depthImageView = new VkImageView(VK_IMAGE_ASPECT_DEPTH_BIT);
		depthImageView.allocate(device, depthImageBackend);
	}

	private void layoutTransitionOfDepthImage(ExecutionContext context)
	{
		final var dstLayout = depthAttachment.getInitialLayout();
		if (dstLayout != EImageLayout.UNDEFINED)
		{
			final var stack = context.stack();
			final var barrierInfo = VkImageMemoryBarrier.callocStack(1, stack);
			final var srcStage = EPipelineStage.TOP_OF_PIPE_BIT_VALUE;
			final var dstStage = EPipelineStage.EARLY_FRAGMENT_TESTS_BIT_VALUE;
			final var srcLayout = EImageLayout.UNDEFINED;

			barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
			barrierInfo.oldLayout(srcLayout.getValue());
			barrierInfo.newLayout(dstLayout.getValue());
			barrierInfo.image(depthImageBackend.getPtr());
			barrierInfo.subresourceRange().baseMipLevel(0);
			barrierInfo.subresourceRange().levelCount(1);
			barrierInfo.subresourceRange().baseArrayLayer(0);
			barrierInfo.subresourceRange().layerCount(1);
			barrierInfo.subresourceRange().aspectMask(VK_IMAGE_ASPECT_DEPTH_BIT);
			barrierInfo.dstAccessMask(EAccess.DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE |
									  EAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE);

			context.execute((context2, commandBuffer) -> vkCmdPipelineBarrier(commandBuffer.getVkCommandBuffer(),
																			  srcStage,
																			  dstStage,
																			  0,
																			  null,
																			  null,
																			  barrierInfo));
		}
	}

	private static int findDepthFormat(PhysicalDevice physicalDevice)
	{
		return physicalDevice.findSupportedFormat(new int[]{VK_FORMAT_D32_SFLOAT},
												  VK_IMAGE_TILING_OPTIMAL,
												  VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	@Override
	public void free(GraphicContext context)
	{
		final var device = context.getVkDevice();
		depthImageView.free(device);
		depthImageBackend.free(context);
	}

	@Override
	public long getImagePtr()
	{
		return depthImageBackend.getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return depthImageView.getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return depthImageBackend.getMemoryPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return depthImageBackend;
	}

	@Override
	public int getImageFormat()
	{
		return depthFormat;
	}

	@Override
	public Vector2ic getSize()
	{
		return new Vector2i(depthImageBackend.width, depthImageBackend.height);
	}
}
