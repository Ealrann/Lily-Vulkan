package org.sheepy.lily.vulkan.process.compute.process;

import java.util.List;

import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.lily.vulkan.process.process.ProcessSubmission;
import org.sheepy.lily.vulkan.process.process.WaitData;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

public class ComputeContext extends ProcessContext
{
	public final ComputeProcess computeProcess;

	public ComputeContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							ComputeProcess computeProcess)
	{
		super(queueType, resetAllowed, descriptorPool, new ComputeCommandBuffers(), computeProcess);
		this.computeProcess = computeProcess;

		allocationList.add(commandBuffers);
		allocationList.add(submission);
	}

	@Override
	protected ProcessSubmission createSubmission(AbstractProcess process)
	{
		final List<WaitData> waitSemaphores = gatherWaitDatas();
		final List<VkSemaphore> signals = gatherSinalSemaphores();
		return new ProcessSubmission(waitSemaphores, signals);
	}
}
