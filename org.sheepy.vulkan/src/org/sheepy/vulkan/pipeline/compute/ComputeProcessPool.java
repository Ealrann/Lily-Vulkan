package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffers;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.PipelineSubmission;

public class ComputeProcessPool extends AllocationNode implements ISignalEmitter, IAllocable
{
	protected CommandPool commandPool;

	protected ComputeCommandBuffers commandBuffers;
	protected PipelineSubmission submission;

	private List<ComputeProcess> processes = new ArrayList<>();

	public ComputeProcessPool(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this.commandPool = commandPool;

		commandBuffers = new ComputeCommandBuffers(commandPool, this);
		submission = new PipelineSubmission(logicalDevice, commandBuffers, Collections.emptyList(),
				VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT);
	}

	public void addProcess(ComputeProcess process)
	{
		processes.add(process);
	}

	public List<ComputeProcess> getProcesses()
	{
		return processes;
	}

	public void exectue(VkQueue queue, int processIndex)
	{
		vkQueueSubmit(queue, submission.getSubmitInfo(processIndex), VK_NULL_HANDLE);
	}

	public VkSubmitInfo getSubmitInfo()
	{
		return submission.getSubmitInfo(0);
	}

	public PipelineSubmission getSubmission()
	{
		return submission;
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return submission.newSignalSemaphore();
	}

	@Override
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		List<IAllocationObject> res = new ArrayList<>();
		res.addAll(processes);
		res.add(commandBuffers);
		res.add(submission);
		
		return res;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		recordCommands();
	}
	
	public void recordCommands()
	{
		commandBuffers.recordCommands();
	}

	@Override
	public void free()
	{
	}
}
