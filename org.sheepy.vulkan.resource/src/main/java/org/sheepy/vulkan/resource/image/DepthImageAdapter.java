package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.PhysicalDevice;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.common.util.ModelUtil;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.DepthImage;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.resource.impl.ReferenceImageBarrierImpl;
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;
import org.sheepy.vulkan.resource.nativehelper.VkImage;
import org.sheepy.vulkan.resource.nativehelper.VkImageView;

public class DepthImageAdapter extends AbstractFlatAllocableAdapter
{
	private VkImage depthImageBackend;
	private VkImageView depthImageView;
	private int depthFormat;
	private SVector2i size;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		depthFormat = findDepthFormat(executionManager.getPhysicalDevice());

		createDepthImage(executionManager.getLogicalDevice());
		allocateDepthImage(stack);

		createAndAllocateImageView(executionManager.getLogicalDevice());

		layoutTransitionOfDepthImage(executionManager);
	}

	private void createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		depthImageView = new VkImageView(logicalDevice.getVkDevice());
		depthImageView.allocate(depthImageBackend.getId(), 1, depthFormat,
				VK_IMAGE_ASPECT_DEPTH_BIT);
	}

	private void allocateDepthImage(MemoryStack stack)
	{
		depthImageBackend.allocate(stack);
	}

	private void createDepthImage(LogicalDevice logicalDevice)
	{
		var vulkanApp = ModelUtil.getVulkanApplication(target);
		size = vulkanApp.getSize();
		int width = size.getX();
		int height = size.getY();
		int usage = VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT;
		var depthImageInfo = new ImageInfo(width, height, depthFormat, usage,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		depthImageBackend = new VkImage(logicalDevice, depthImageInfo);
	}

	private void layoutTransitionOfDepthImage(ExecutionManager context)
	{
		final var barrier = new ReferenceImageBarrierImpl();
		barrier.setImageId(depthImageBackend.getId());
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
	public boolean isAllocationDirty()
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.DEPTH_IMAGE == eClass;
	}

	public static DepthImageAdapter adapt(DepthImage resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, DepthImageAdapter.class);
	}
}
