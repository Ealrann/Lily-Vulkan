package org.sheepy.vulkan.process.compute.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.process.process.ProcessSubmission;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;

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
		super(executionManager, descriptorPool);
		this.computeProcess = computeProcess;

		commandBuffers = new ComputeCommandBuffers(this);
		submission = new ProcessSubmission(logicalDevice, commandBuffers, Collections.emptyList(),
				EPipelineStage.COMPUTE_SHADER_BIT);

		buildAllocationList();
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
