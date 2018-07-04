package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class ComputePipeline implements IDescriptorSetConfiguration
{
	protected LogicalDevice logicalDevice;
	protected IComputer computer;

	protected long pipeline;
	protected long pipelineLayout;

	public ComputePipeline(LogicalDevice logicalDevice, IComputer computer)
	{
		this.logicalDevice = logicalDevice;
		this.computer = computer;
	}

	public void load(DescriptorSet descriptorSet)
	{
		computer.load();

		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
		bDescriptorSet.put(descriptorSet.getLayoutId());
		bDescriptorSet.flip();

		// Create compute pipeline
		long[] aLayout = new long[1];
		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.calloc();
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(bDescriptorSet);
		if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutCreateInfo, null,
				aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		pipelineLayout = aLayout[0];

		VkComputePipelineCreateInfo.Buffer pipelineCreateInfo = VkComputePipelineCreateInfo
				.calloc(1);

		VkPipelineShaderStageCreateInfo shaderInfo = computer.getShader().allocInfo();
		pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
		pipelineCreateInfo.stage(shaderInfo);
		pipelineCreateInfo.layout(pipelineLayout);

		long[] aPipeline = new long[1];
		if (vkCreateComputePipelines(logicalDevice.getVkDevice(), VK_NULL_HANDLE,
				pipelineCreateInfo, null, aPipeline) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline!");
		}
		pipeline = aPipeline[0];

		MemoryUtil.memFree(bDescriptorSet);
		shaderInfo.free();
		pipelineCreateInfo.free();
		pipelineLayoutCreateInfo.free();
	}

	public long getId()
	{
		return pipeline;
	}

	public void free()
	{
		computer.free();

		vkDestroyPipeline(logicalDevice.getVkDevice(), pipeline, null);
		vkDestroyPipelineLayout(logicalDevice.getVkDevice(), pipelineLayout, null);
	}

	public IComputer getComputer()
	{
		return computer;
	}

	public int getDataWidth()
	{
		return computer.getDataWidth();
	}

	public int getDataHeight()
	{
		return computer.getDataHeight();
	}

	public int getDataDepth()
	{
		return computer.getDataDepth();
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return computer.getDescriptors();
	}

	public long getPipelineLayout()
	{
		return pipelineLayout;
	}
}
