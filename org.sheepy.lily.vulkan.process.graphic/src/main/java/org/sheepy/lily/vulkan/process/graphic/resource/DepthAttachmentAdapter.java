package org.sheepy.lily.vulkan.process.graphic.resource;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.nativehelper.resource.image.ImageInfo;
import org.sheepy.lily.vulkan.api.nativehelper.resource.image.VkImageView;
import org.sheepy.lily.vulkan.api.resource.attachment.IDepthAttachmentAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EAccess;
import org.sheepy.lily.vulkan.model.enumeration.EImageLayout;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl;
import org.sheepy.lily.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImage;

@Statefull
@Adapter(scope = DepthAttachment.class)
public class DepthAttachmentAdapter implements IDepthAttachmentAdapter
{
	private VkImage depthImageBackend;
	private VkImageView depthImageView;
	private int depthFormat;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		depthFormat = findDepthFormat(graphicContext.getPhysicalDevice());

		createDepthImage(graphicContext);
		allocateDepthImage(stack);

		createAndAllocateImageView(graphicContext.getLogicalDevice());

		layoutTransitionOfDepthImage(stack, graphicContext);
	}

	private void createAndAllocateImageView(ILogicalDevice logicalDevice)
	{
		depthImageView = new VkImageView(logicalDevice.getVkDevice());
		depthImageView.allocate(depthImageBackend.getAddress(), 1, depthFormat,
				VK_IMAGE_ASPECT_DEPTH_BIT);
	}

	private void allocateDepthImage(MemoryStack stack)
	{
		depthImageBackend.allocate(stack);
	}

	private void createDepthImage(IGraphicContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		final var surfaceManager = context.getSurfaceManager();
		final var extent = surfaceManager.getExtent();
		final int width = extent.width;
		final int height = extent.height;
		final int usage = VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT;
		final var depthImageInfo = new ImageInfo(width, height, depthFormat, usage,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		depthImageBackend = new VkImage(logicalDevice, depthImageInfo);
	}

	private void layoutTransitionOfDepthImage(MemoryStack stack, IExecutionContext context)
	{
		final var barrier = new ReferenceImageBarrierImpl();
		barrier.setImageId(depthImageBackend.getAddress());
		barrier.setMipLevels(1);
		barrier.setImageFormat(depthFormat);
		barrier.setSrcStage(EPipelineStage.TOP_OF_PIPE_BIT);
		barrier.setDstStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);

		final var transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.UNDEFINED);
		transition.setDstLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		transition.getDstAccessMask().add(EAccess.DEPTH_STENCIL_ATTACHMENT_READ_BIT);
		transition.getDstAccessMask().add(EAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT);

		barrier.getTransitions().add(transition);

		final var barrierExecutor = BarrierExecutorFactory.create(barrier);
		barrierExecutor.allocate();

		context.execute(stack, new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				barrierExecutor.execute(commandBuffer);
			}
		});
		barrierExecutor.free();
	}

	private static int findDepthFormat(IPhysicalDevice physicalDevice)
	{
		return physicalDevice.findSupportedFormat(new int[] {
				VK_FORMAT_D32_SFLOAT, VK_FORMAT_D32_SFLOAT_S8_UINT, VK_FORMAT_D24_UNORM_S8_UINT
		}, VK_IMAGE_TILING_OPTIMAL, VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	@Override
	public void free(IAllocationContext context)
	{
		depthImageView.free();
		depthImageBackend.free();
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		return graphicContext.getSurfaceManager().isAllocationDirty(context);
	}

	@Override
	public long getImageId()
	{
		return depthImageBackend.getAddress();
	}

	@Override
	public long getImageViewId()
	{
		return depthImageView.getAddress();
	}

	@Override
	public int getImageFormat()
	{
		return depthFormat;
	}
}
