package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffers;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.AbstractProcessPool;
import org.sheepy.vulkan.pipeline.Configuration;
import org.sheepy.vulkan.pipeline.PipelineSubmission;

public class ComputeProcessPool extends AbstractProcessPool<ComputeProcess>
		implements ISignalEmitter, IAllocable
{
	protected ComputeCommandBuffers commandBuffers;
	protected PipelineSubmission submission;

	protected int processIndex = 0;

	public ComputeProcessPool(LogicalDevice logicalDevice, boolean allowReset)
	{
		super(new Configuration(logicalDevice),
				logicalDevice.getQueueManager().getComputeQueueIndex(), allowReset);

		commandBuffers = new ComputeCommandBuffers(commandPool, this);
		submission = new PipelineSubmission(logicalDevice, commandBuffers, Collections.emptyList(),
				VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT);

		allocationObjects.add(commandBuffers);
		allocationObjects.add(submission);
	}

	public ComputeProcess newComputeProcess()
	{
		ComputeProcess res = new ComputeProcess(context);
		addProcess(res);
		return res;
	}

	@Override
	public void execute()
	{
		vkQueueSubmit(logicalDevice.getQueueManager().getComputeQueue(),
				submission.getSubmitInfo(processIndex), VK_NULL_HANDLE);

		processIndex++;
		if (processIndex >= processes.size())
		{
			processIndex = 0;
		}
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
	{}
}
