package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@Statefull
@Adapter(scope = GraphicProcess.class)
public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
{
	private static final String FAILED_SUBMIT_GRAPHIC = "Failed to submit graphic command buffer";
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);
	}

	@Override
	protected ProcessContext createContext()
	{
		return new GraphicContext(getQueueType(), isResetAllowed(), descriptorPool,
				(GraphicProcess) process);
	}

	@Override
	protected List<Object> gatherResources()
	{
		List<Object> res = super.gatherResources();

		var depthImage = ((GraphicProcess) process).getDepthImage();
		if (depthImage != null)
		{
			res.add(depthImage);
		}

		return res;
	}

	@Override
	public void recordCommands()
	{
		var graphicCopntext = (GraphicContext) context;

		((GraphicCommandBuffers) context.commandBuffers).recordCommands(graphicCopntext);
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void execute(IFence fence)
	{
		final var graphicContext = (GraphicContext) context;
		final Integer imageIndex = acquireNextImage(graphicContext);

		if (imageIndex != null)
		{
			submitAndPresentImage(graphicContext, imageIndex, fence);
		}
	}

	public Integer acquireNextImage(GraphicContext context)
	{
		long semaphore = context.imageAvailableSemaphore.getId();
		long swapChain = context.swapChainManager.getSwapChain();
		var device = context.getVkDevice();

		int res = vkAcquireNextImageKHR(device, swapChain, UINT64_MAX, semaphore, VK_NULL_HANDLE,
				nextImageArray);

		if (res == VK_ERROR_OUT_OF_DATE_KHR)
		{
			context.getLogicalDevice().window.createSurface();
			return null;
		}
		else
		{
			Logger.check(res, FAILED_SUBMIT_PRESENT);
		}

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	private void submitAndPresentImage(GraphicContext context, Integer imageIndex, IFence fence)
	{
		var queueManager = context.getLogicalDevice().queueManager;
		var graphicQueue = queueManager.getGraphicQueue().vkQueue;
		var presentQueue = queueManager.getPresentQueue().vkQueue;
		var fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;
		var submission = context.frameSubmission;
		var submitInfo = submission.getSubmitInfo(imageIndex);
		var presentInfo = submission.getPresentInfo(imageIndex);

		Logger.check(vkQueueSubmit(graphicQueue, submitInfo, fenceId), FAILED_SUBMIT_GRAPHIC);

		int res = vkQueuePresentKHR(presentQueue, presentInfo);

		if (res == VK_ERROR_OUT_OF_DATE_KHR)
		{
			context.getLogicalDevice().window.createSurface();
			System.out.println("OOD");
		}
		else
		{
			Logger.check(res, FAILED_SUBMIT_PRESENT);
		}
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	@Override
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_GRAPHICS;
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
