package org.sheepy.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.concurrent.IFence;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.vulkan.process.process.AbstractProcessAdapter;

public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
{
	private static final String FAILED_SUBMIT_GRAPHIC = "Failed to submit graphic command buffer";
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	protected GraphicContext context;
	private VkSemaphore imageAvailableSemaphore;
	private GraphicProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		this.process = (GraphicProcess) target;
		super.setTarget(target);

		imageAvailableSemaphore = new VkSemaphore();
		context = new GraphicContext(executionManager, descriptorPool, process,
				imageAvailableSemaphore);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	public void recordCommands()
	{
		context.commandBuffers.recordCommands(context);
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		imageAvailableSemaphore.allocate(logicalDevice);
		super.flatAllocate(stack);
	}

	@Override
	public void freePart()
	{
		super.freePart();
		imageAvailableSemaphore.free(logicalDevice);
	}

	@Override
	public void execute(IFence fence)
	{
		checkAllocation();

		final Integer imageIndex = acquireNextImage();

		if (imageIndex != null)
		{
			submitAndPresentImage(imageIndex, fence);
		}
	}

	public Integer acquireNextImage()
	{
		long semaphore = imageAvailableSemaphore.getId();
		long swapChain = context.swapChainManager.getSwapChain();

		final int res = vkAcquireNextImageKHR(context.getVkDevice(), swapChain, UINT64_MAX,
				semaphore, VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	private void submitAndPresentImage(Integer imageIndex, IFence fence)
	{
		var queueManager = executionManager.logicalDevice.queueManager;
		var graphicQueue = queueManager.getGraphicQueue().vkQueue;
		var presentQueue = queueManager.getPresentQueue().vkQueue;
		var fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;
		FrameSubmission submission = context.submission;
		VkSubmitInfo submitInfo = submission.getSubmitInfo(imageIndex);
		VkPresentInfoKHR presentInfo = submission.getPresentInfo(imageIndex);

		Logger.check(vkQueueSubmit(graphicQueue, submitInfo, fenceId), FAILED_SUBMIT_GRAPHIC);

		Logger.check(vkQueuePresentKHR(presentQueue, presentInfo), FAILED_SUBMIT_PRESENT);
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.executionManager.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.removeAll(context.getAllocationList());
		context = null;

		this.process = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_GRAPHICS;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GraphicPackage.Literals.GRAPHIC_PROCESS.isSuperTypeOf(eClass);
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
