package org.sheepy.lily.vulkan.process.compute.process;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public class ComputeProcessAdapter extends AbstractProcessAdapter<ComputeCommandBuffer>
{
	private static final String FAILED_SUBMIT_COMPUTE = "Failed to submit compute command buffer";

	private ComputeProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		process = (ComputeProcess) target;
		super.setTarget(target);
	}

	@Override
	protected ProcessContext createContext()
	{
		return new ComputeContext(getQueueType(), isResetAllowed(), descriptorPool, process);
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		process = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	public void recordCommands()
	{
		((ComputeCommandBuffers) context.commandBuffers).recordCommands();
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void execute(IFence fence)
	{
		var computeContext = (ComputeContext) context;
		var queue = context.getQueue().vkQueue;
		var submission = computeContext.submission;
		var submitInfo = submission.getSubmitInfo(0);
		long fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;

		Logger.check(vkQueueSubmit(queue, submitInfo, fenceId), FAILED_SUBMIT_COMPUTE);
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
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
		return ComputePackage.Literals.COMPUTE_PROCESS.isSuperTypeOf(eClass);
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}
}
