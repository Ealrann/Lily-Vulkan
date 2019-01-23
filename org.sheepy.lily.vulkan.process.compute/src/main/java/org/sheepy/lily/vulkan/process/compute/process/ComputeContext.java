package org.sheepy.lily.vulkan.process.compute.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessSemaphore;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.lily.vulkan.process.process.ProcessSubmission;
import org.sheepy.lily.vulkan.process.process.WaitData;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

public class ComputeContext extends ProcessContext
{
	public final ComputeProcess computeProcess;
	public final ComputeCommandBuffers commandBuffers;
	public final ProcessSubmission submission;

	private List<IBasicAllocable> allocationList;

	public ComputeContext(	ExecutionManager executionManager,
							DescriptorPool descriptorPool,
							ComputeProcess computeProcess)
	{
		super(executionManager, descriptorPool, computeProcess);
		this.computeProcess = computeProcess;

		commandBuffers = new ComputeCommandBuffers(this);

		submission = createSubmission(computeProcess);

		buildAllocationList();
	}

	private ProcessSubmission createSubmission(ComputeProcess computeProcess)
	{
		var processAdapter = AbstractProcessAdapter.adapt(computeProcess);

		List<WaitData> waitSemaphores = new ArrayList<>();
		for (ProcessSemaphore waitFor : computeProcess.getSemaphores())
		{
			var semaphoreData = convertToData(waitFor);
			waitSemaphores.add(semaphoreData);
		}

		List<VkSemaphore> signals = null;
		var executionSemaphore = processAdapter.getExecutionSemaphore();
		if (executionSemaphore != null)
		{
			signals = List.of(executionSemaphore);
		}
		else
		{
			signals = Collections.emptyList();
		}

		return new ProcessSubmission(commandBuffers, waitSemaphores, signals);
	}

	private static WaitData convertToData(ProcessSemaphore processSemaphore)
	{
		var signalEmitter = AbstractProcessAdapter.adapt(processSemaphore.getProcess());
		var waitStage = processSemaphore.getWaitStage();
		return new WaitData(signalEmitter.getExecutionSemaphore(), waitStage);
	}

	private void buildAllocationList()
	{
		var tmpList = new ArrayList<IBasicAllocable>();

		tmpList.add(commandBuffers);
		tmpList.add(submission);

		allocationList = List.copyOf(tmpList);
	}

	public List<IBasicAllocable> getAllocationList()
	{
		return allocationList;
	}
}
