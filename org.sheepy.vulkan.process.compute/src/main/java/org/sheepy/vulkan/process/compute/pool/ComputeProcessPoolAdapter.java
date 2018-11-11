package org.sheepy.vulkan.process.compute.pool;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcessPool;
import org.sheepy.vulkan.process.pool.AbstractProcessPoolAdapter;

public class ComputeProcessPoolAdapter extends AbstractProcessPoolAdapter implements ISignalEmitter
{
	private static final String FAILED_SUBMIT_COMPUTE = "Failed to submit compute command buffer";

	protected ComputeContext context;

	protected int processIndex = 0;

	private ComputeProcessPool processPool = null;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		processPool = (ComputeProcessPool) target;

		context = new ComputeContext(executionManager, resourceManager, processPool);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.removeAll(context.getAllocationList());
		context = null;

		processPool = null;
		super.unsetTarget(oldTarget);
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
	
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTE_PROCESS_POOL == eClass;
	}

	public static ComputeProcessPoolAdapter adapt(ComputeProcessPool object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, ComputeProcessPoolAdapter.class);
	}
}
