package org.sheepy.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.vulkan.process.process.AbstractProcessAdapter;

public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
		implements ISignalEmitter
{
	private static final String FAILED_SUBMIT_GRAPHIC = "Failed to submit graphic command buffer";
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	protected GraphicContext context;

	private VkSemaphore imageAvailableSemaphore;

	private GraphicProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		this.process = (GraphicProcess) target;
		super.setTarget(target);

		context = new GraphicContext(executionManager, descriptorPool, process);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	public void recordCommands()
	{
		context.commandBuffers.recordCommands(context);
	}

	private final int[] nextImageArray = new int[1];

	public Integer acquireNextImage()
	{
		final int res = vkAcquireNextImageKHR(context.getVkDevice(),
				context.swapChainManager.getSwapChain(), UINT64_MAX,
				imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	public void execute()
	{
		checkAllocation();

		final Integer imageIndex = acquireNextImage();

		if (imageIndex != null)
		{
			submitAndPresentImage(imageIndex);
		}
	}

	private void submitAndPresentImage(Integer imageIndex)
	{
		var queueManager = executionManager.logicalDevice.queueManager;
		var graphicQueue = queueManager.getGraphicQueue();
		var presentQueue = queueManager.getPresentQueue();
		FrameSubmission submission = context.submission;
		VkSubmitInfo submitInfo = submission.getSubmitInfo(imageIndex);
		VkPresentInfoKHR presentInfo = submission.getPresentInfo(imageIndex);

		Logger.check(vkQueueSubmit(graphicQueue.vkQueue, submitInfo, VK_NULL_HANDLE),
				FAILED_SUBMIT_GRAPHIC);

		// presentQueue.waitIdle();

		Logger.check(vkQueuePresentKHR(presentQueue.vkQueue, presentInfo), FAILED_SUBMIT_PRESENT);
	}

	@Override
	public VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice)
	{
		if (imageAvailableSemaphore == null)
		{
			imageAvailableSemaphore = new VkSemaphore();
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				imageAvailableSemaphore.allocate(logicalDevice);
			}
		}
		return imageAvailableSemaphore;
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
		return GraphicPackage.Literals.GRAPHIC_PROCESS == eClass;
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
