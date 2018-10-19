package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.execution.ExecutionManager;
import org.sheepy.vulkan.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.execution.SingleTimeCommand;
import org.sheepy.vulkan.model.DepthImage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.imagebarrier.ImageBarrierExecutor;
import org.sheepy.vulkan.util.ModelUtil;
import org.sheepy.vulkan.view.ImageView;

public class DepthImageAdapter extends ResourceAdapter
{
	private StandaloneImage depthImageBackend;
	private ImageView depthImageView;
	private int depthFormat;
	private SVector2i size;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager();
		depthFormat = findDepthFormat(executionManager.getPhysicalDevice());

		createDepthImage(executionManager.getLogicalDevice());
		allocateDepthImage(stack);

		createAndAllocateImageView(executionManager.getLogicalDevice());

		layoutTransitionOfDepthImage(executionManager);
	}

	private void createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		depthImageView = new ImageView(logicalDevice.getVkDevice());
		depthImageView.load(depthImageBackend.getId(), 1, depthFormat, VK_IMAGE_ASPECT_DEPTH_BIT);
	}

	private void allocateDepthImage(MemoryStack stack)
	{
		depthImageBackend.allocate(stack);
	}

	private void createDepthImage(LogicalDevice logicalDevice)
	{
		final var vulkanApp = ModelUtil.getVulkanApplication(target);
		size = vulkanApp.getSize();
		final int width = size.getX();
		final int height = size.getY();

		final ImageInfo depthImageInfo = new ImageInfo();
		depthImageInfo.setWidth(width);
		depthImageInfo.setHeight(height);
		depthImageInfo.setFormat(depthFormat);
		depthImageInfo.setMipLevels(1);
		depthImageInfo.setTiling(VK_IMAGE_TILING_OPTIMAL);
		depthImageInfo.setUsage(VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT);
		depthImageInfo.setProperties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		depthImageBackend = new StandaloneImage(logicalDevice, depthImageInfo);
	}

	private void layoutTransitionOfDepthImage(ExecutionManager context)
	{
		final var barrier = new ReferenceImageBarrierImpl();
		barrier.setImageId(getDepthImageId());
		barrier.setMipLevels(1);
		barrier.setImageFormat(depthFormat);
		barrier.setSrcStage(EPipelineStage.TOP_OF_PIPE_BIT);
		barrier.setDstStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);

		final var transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.UNDEFINED);
		transition.setDstLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		transition.setSrcAccess(0);
		transition.setDstAccess(VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT
				| VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT);

		barrier.getTransitions().add(transition);

		var barrierExecutor = new ImageBarrierExecutor();
		barrierExecutor.allocate(barrier);
		final SingleTimeCommand stc = new SingleTimeCommand(context)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				barrierExecutor.execute(commandBuffer);
			}
		};
		stc.execute();
		barrierExecutor.free();
	}

	private static int findDepthFormat(PhysicalDevice physicalDevice)
	{
		return physicalDevice.findSupportedFormat(new int[] {
				VK_FORMAT_D32_SFLOAT, VK_FORMAT_D32_SFLOAT_S8_UINT, VK_FORMAT_D24_UNORM_S8_UINT
		}, VK_IMAGE_TILING_OPTIMAL, VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	@Override
	public void free()
	{
		depthImageView.free();
		depthImageBackend.free();
	}

	@Override
	public boolean isDirty()
	{
		var application = ModelUtil.getVulkanApplication(target);

		return size != application.getSize();
	}

	public long getDepthImageId()
	{
		return depthImageBackend.getId();
	}

	public long getDepthImageViewId()
	{
		return depthImageView.getId();
	}

	public int getDepthImageFormat()
	{
		return depthFormat;
	}

	public static DepthImageAdapter adapt(DepthImage resource)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(resource, DepthImageAdapter.class);
	}
}