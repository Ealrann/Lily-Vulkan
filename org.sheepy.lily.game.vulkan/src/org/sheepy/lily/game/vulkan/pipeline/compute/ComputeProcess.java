package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.compute.ComputeCommandBuffers;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.PipelineSubmission;

/**
 * A set of ComputePipeline.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess implements ISignalEmitter
{
	private List<ComputePipeline> computePipelines = new ArrayList<>();
	protected CommandPool commandPool;

	protected DescriptorPool descriptorPool;

	// TODO submission et commandBuffers devraient être un niveau plus haut
	protected ComputeCommandBuffers commandBuffers;
	protected PipelineSubmission submission;

	public ComputeProcess(LogicalDevice logicalDevice, CommandPool commandPool,
			List<ComputePipeline> computePipeline)
	{
		this.commandPool = commandPool;
		this.computePipelines.addAll(computePipeline);

		descriptorPool = new DescriptorPool(logicalDevice);

		submission = new PipelineSubmission(logicalDevice, Collections.emptyList(),
				VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT);
	}

	public ComputeProcess(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this(logicalDevice, commandPool, Collections.emptyList());
	}

	public void addPipeline(ComputePipeline pipeline)
	{
		computePipelines.add(pipeline);
	}

	public void addEmitterToWaitFor(ISignalEmitter emitter)
	{
		submission.addEmitterToWaitFor(emitter);
	}

	public void load()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			descriptorPool.load(stack, computePipelines);

			for (ComputePipeline pipeline : computePipelines)
			{
				pipeline.load(descriptorPool.getDescriptorSet(pipeline));
			}

			// Command Buffers
			commandBuffers = new ComputeCommandBuffers(commandPool,
					Collections.singletonList(this));
			commandBuffers.load();
			submission.load(commandBuffers);
		}
	}

	public void free()
	{
		if (descriptorPool != null) descriptorPool.destroy();
		commandBuffers.free();
		submission.free();

		for (ComputePipeline pipeline : computePipelines)
		{
			pipeline.free();
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

	public List<ComputePipeline> getPipelines()
	{
		return computePipelines;
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

}
