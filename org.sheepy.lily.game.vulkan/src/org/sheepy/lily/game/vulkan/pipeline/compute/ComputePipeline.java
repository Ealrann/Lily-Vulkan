package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.compute.ComputeCommandBuffers;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.PipelineSubmission;

public class ComputePipeline implements ISignalEmitter
{
	protected LogicalDevice logicalDevice;
	protected CommandPool commandPool;

	protected Collection<ComputerPool> computerPools = new ArrayList<>();

	protected DescriptorPool descriptorPool;
	protected long pipeline;
	protected long pipelineLayout;
	protected ComputeCommandBuffers commandBuffers;

	protected PipelineSubmission submission;

	public ComputePipeline(LogicalDevice logicalDevice, CommandPool commandPool,
			Collection<ISignalEmitter> waitForEmitters)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;

		submission = new PipelineSubmission(logicalDevice, waitForEmitters,
				VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return submission.newSignalSemaphore();
	}

	public void attachComputerPool(ComputerPool computerPool)
	{
		computerPools.add(computerPool);
	}

	public void load()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			descriptorPool = DescriptorPool.alloc(stack, logicalDevice, computerPools);

			// Create compute pipeline
			long[] aLayout = new long[1];
			VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo
					.calloc();
			pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
			pipelineLayoutCreateInfo.pSetLayouts(descriptorPool.allocLayoutBuffer());
			if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutCreateInfo, null,
					aLayout) != VK_SUCCESS)
			{
				throw new AssertionError("Failed to create compute pipeline layout!");
			}
			pipelineLayout = aLayout[0];

			int computerCount = 0;
			for (ComputerPool pool : computerPools)
			{
				computerCount += pool.getDescriptors().size();
			}

			VkComputePipelineCreateInfo.Buffer pipelineCreateInfos = VkComputePipelineCreateInfo
					.calloc(computerCount);

			for (ComputerPool pool : computerPools)
			{
				for (IComputer computer : pool.getComputers())
				{
					VkComputePipelineCreateInfo pipelineCreateInfo = pipelineCreateInfos.get();
					pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
					pipelineCreateInfo.stage(computer.getShader().allocInfo());
					pipelineCreateInfo.layout(pipelineLayout);
				}
			}
			pipelineCreateInfos.flip();

			long[] aPipeline = new long[1];
			if (vkCreateComputePipelines(logicalDevice.getVkDevice(), VK_NULL_HANDLE,
					pipelineCreateInfos, null, aPipeline) != VK_SUCCESS)
			{
				throw new AssertionError("Failed to create compute pipeline!");
			}
			pipeline = aPipeline[0];

			// Command Buffers
			commandBuffers = new ComputeCommandBuffers(this, commandPool, computerPools);
			commandBuffers.load();

			submission.load(commandBuffers);

			pipelineCreateInfos.free();
			pipelineLayoutCreateInfo.free();
		}
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	public ComputeCommandBuffers getCommandBuffers()
	{
		return commandBuffers;
	}

	public long getPipelineLayout()
	{
		return pipelineLayout;
	}

	public VkSubmitInfo getSubmitInfo()
	{
		return submission.getSubmitInfo(0);
	}

	public PipelineSubmission getSubmission()
	{
		return submission;
	}

	public long getId()
	{
		return pipeline;
	}

	public void free()
	{
		for (ComputerPool computerPool : computerPools)
		{
			for (IComputer computer : computerPool.getComputers())
			{
				computer.free();
			}
		}
		computerPools.clear();
		commandBuffers.free();
		submission.free();

		vkDestroyPipeline(logicalDevice.getVkDevice(), pipeline, null);
		vkDestroyPipelineLayout(logicalDevice.getVkDevice(), pipelineLayout, null);

		if (descriptorPool != null) descriptorPool.destroy();
	}
}
