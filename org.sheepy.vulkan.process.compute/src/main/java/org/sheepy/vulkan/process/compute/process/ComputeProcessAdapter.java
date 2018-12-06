package org.sheepy.vulkan.process.compute.process;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.vulkan.process.process.AbstractProcessAdapter;

/**
 * A set of ComputePipelines.
 *
 */
public class ComputeProcessAdapter extends AbstractProcessAdapter<ComputeCommandBuffer>
		implements ISignalEmitter, IDeepAllocableAdapter
{
	private static final String FAILED_SUBMIT_COMPUTE = "Failed to submit compute command buffer";

	private ComputeProcess process = null;
	protected ComputeContext context;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (ComputeProcess) target;

		context = new ComputeContext(executionManager, resourceManager, process);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.removeAll(context.getAllocationList());
		context = null;

		process = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	public void recordCommands()
	{
		context.commandBuffers.recordCommands();
	}

	@Override
	public void execute()
	{
		checkAllocation();

		var queue = context.executionManager.getQueue().vkQueue;
		var submission = context.submission;
		var submitInfo = submission.getSubmitInfo(0);

		Logger.check(vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE), FAILED_SUBMIT_COMPUTE);
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
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_COMPUTE;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTE_PROCESS == eClass;
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}
}
