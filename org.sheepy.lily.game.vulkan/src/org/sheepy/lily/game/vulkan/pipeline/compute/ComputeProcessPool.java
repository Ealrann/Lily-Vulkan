package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.compute.ComputeCommandBuffers;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.PipelineSubmission;

public class ComputeProcessPool implements ISignalEmitter
{
	protected CommandPool commandPool;

	protected ComputeCommandBuffers commandBuffers;
	protected PipelineSubmission submission;

	private List<ComputeProcess> processes = new ArrayList<>();

	public ComputeProcessPool(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this.commandPool = commandPool;

		commandBuffers = new ComputeCommandBuffers(commandPool, this);
		submission = new PipelineSubmission(logicalDevice, Collections.emptyList(),
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

	public void load()
	{

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			for (ComputeProcess computeProcess : processes)
			{
				computeProcess.load(stack);
			}

			commandBuffers.load();
			submission.load(commandBuffers);
		}
	}

	public void exectue(VkQueue queue, int processIndex)
	{
		vkQueueSubmit(queue, submission.getSubmitInfo(processIndex), VK_NULL_HANDLE);
	}

	public void free()
	{
		commandBuffers.free();
		submission.free();

		for (ComputeProcess computeProcess : processes)
		{
			computeProcess.free();
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
}
