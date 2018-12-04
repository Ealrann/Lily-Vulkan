package org.sheepy.vulkan.process.compute.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.compute.ComputeProcessPool;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.vulkan.process.pool.ProcessContext;
import org.sheepy.vulkan.process.pool.ProcessSubmission;
import org.sheepy.vulkan.resource.ResourceManager;

public class ComputeContext extends ProcessContext
{
	public final ComputeProcessPool computeProcessPool;

	public final ComputeCommandBuffers commandBuffers;
	public final ProcessSubmission submission;

	private List<IBasicAllocable> allocationList;

	public ComputeContext(	ExecutionManager executionManager,
							ResourceManager resourceManager,
							ComputeProcessPool computeProcessPool)
	{
		super(executionManager, resourceManager);
		this.computeProcessPool = computeProcessPool;
		
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
