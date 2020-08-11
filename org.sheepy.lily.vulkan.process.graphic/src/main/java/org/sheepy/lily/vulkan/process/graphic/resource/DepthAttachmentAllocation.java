package org.sheepy.lily.vulkan.process.graphic.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.attachment.IDepthAttachmentAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DepthAttachment.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
public final class DepthAttachmentAllocation implements IDepthAttachmentAllocation
{
	private final DepthAttachment depthAttachment;
	private final int depthFormat;
	private final VkImage depthImageBackend;
	private final VkImageView depthImageView;

	public DepthAttachmentAllocation(DepthAttachment depthAttachment,
									 ProcessContext context,
									 @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation)
	{
		this.depthAttachment = depthAttachment;

		depthFormat = findDepthFormat(context.getPhysicalDevice());
		depthImageBackend = createDepthImage(context, surfaceAllocation);
		depthImageView = createAndAllocateImageView(context.getLogicalDevice());
		layoutTransitionOfDepthImage(context);
	}

	private VkImage createDepthImage(ProcessContext context, final PhysicalSurfaceAllocation surfaceAllocation)
	{
		final var extent = surfaceAllocation.getExtent();
		final int width = extent.x();
		final int height = extent.y();
		final int usages = VulkanModelUtil.getEnumeratedFlag(depthAttachment.getUsages()) | VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT;

		final var depthImageBuilder = VkImage.newBuilder(width, height, depthFormat);
		depthImageBuilder.usage(usages);
		depthImageBuilder.aspect(VK_IMAGE_ASPECT_DEPTH_BIT);

		return context.executeFunction(depthImageBuilder::build);
	}

	private VkImageView createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		final var device = logicalDevice.getVkDevice();
		final var depthImageView = new VkImageView(VK_IMAGE_ASPECT_DEPTH_BIT);
		depthImageView.allocate(device, depthImageBackend);

		return depthImageView;
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
			barrierInfo.dstAccessMask(EAccess.DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE | EAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE);

			context.executeCommand(recordContext -> vkCmdPipelineBarrier(recordContext.vkCommandBuffer(),
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

	@Free
	public void free(ProcessContext context)
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
