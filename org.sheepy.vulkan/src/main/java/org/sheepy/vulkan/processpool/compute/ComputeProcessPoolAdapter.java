package org.sheepy.vulkan.processpool.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.queue.EQueueType;
import org.sheepy.vulkan.execution.queue.VulkanQueue;
import org.sheepy.vulkan.model.process.ComputeProcessPool;
import org.sheepy.vulkan.processpool.AbstractProcessPoolAdapter;
import org.sheepy.vulkan.util.Logger;

public class ComputeProcessPoolAdapter extends AbstractProcessPoolAdapter implements ISignalEmitter
{
	private static final String FAILED_SUBMIT_COMPUTE = "Failed to submit compute command buffer";

	protected ComputeContext context;

	protected int processIndex = 0;

	private ComputeProcessPool processPool = null;

	@Override
	protected void load()
	{
		super.load();
		processPool = (ComputeProcessPool) target;

		context = new ComputeContext(executionManager, resourceManager, processPool);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	protected void unload()
	{
		childAllocables.removeAll(context.getAllocationList());
		context = null;

		processPool = null;
		super.unload();
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);
		recordCommands();
	}

	public void recordCommands()
	{
		context.commandBuffers.recordCommands();
	}

	@Override
	public void execute()
	{
		var queue = context.executionManager.getQueue().vkQueue;
		var submission = context.submission;
		var submitInfo = submission.getSubmitInfo(processIndex);

		Logger.check(vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE), FAILED_SUBMIT_COMPUTE);

		processIndex++;
		if (processIndex >= processPool.getProcesses().size())
		{
			processIndex = 0;
		}
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.executionManager.getQueue();
	}

	@Override
	public VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice)
	{
		return context.submission.newSignalSemaphore(logicalDevice);
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Compute;
	}

	public static ComputeProcessPoolAdapter adapt(ComputeProcessPool object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ComputeProcessPoolAdapter.class);
	}
}
