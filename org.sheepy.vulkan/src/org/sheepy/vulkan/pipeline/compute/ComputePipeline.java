package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.buffer.BufferBarrier;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.AbstractPipeline;
import org.sheepy.vulkan.pipeline.IPipelineExecutable;
import org.sheepy.vulkan.pipeline.IPipelineUnit;
import org.sheepy.vulkan.pipeline.PipelineBarrier;
import org.sheepy.vulkan.shader.Shader;

public class ComputePipeline extends AbstractPipeline
		implements IDescriptorSetConfiguration, IComputeProcessUnit
{
	private static final float DEFAULT_WORKGROUP_SIZE = 32;

	protected DescriptorPool descriptorPool;

	protected List<IDescriptor> descriptors;
	protected List<Shader> shaders = new ArrayList<>();

	protected float workgroupSize = DEFAULT_WORKGROUP_SIZE;

	private int dataWidth = -1;
	private int dataHeight = -1;
	private int dataDepth = -1;

	public ComputePipeline(LogicalDevice logicalDevice, DescriptorPool descriptorPool, int width,
			int height, int depth, List<IDescriptor> descriptors, String shaderLocation)
	{
		this(logicalDevice, descriptorPool, width, height, depth, descriptors,
				Collections.singletonList(
						new Shader(logicalDevice, shaderLocation, VK_SHADER_STAGE_COMPUTE_BIT)));
	}

	public ComputePipeline(LogicalDevice logicalDevice, DescriptorPool descriptorPool, int width,
			int height, int depth, List<IDescriptor> descriptors, Shader shader)
	{
		this(logicalDevice, descriptorPool, width, height, depth, descriptors,
				Collections.singletonList(shader));
	}

	public ComputePipeline(LogicalDevice logicalDevice, DescriptorPool descriptorPool, int width,
			int height, int depth, List<IDescriptor> descriptors)
	{
		this(logicalDevice, descriptorPool, width, height, depth, descriptors,
				Collections.emptyList());
	}

	public ComputePipeline(LogicalDevice logicalDevice, DescriptorPool descriptorPool, int width,
			int height, int depth, List<IDescriptor> descriptors, List<Shader> shaders)
	{
		super(logicalDevice);

		this.descriptorPool = descriptorPool;

		this.dataWidth = width;
		this.dataHeight = height;
		this.dataDepth = depth;

		addPipelineUnits(shaders);
		this.shaders.addAll(shaders);
		this.descriptors = new ArrayList<>(descriptors);
	}

	public void addShader(Shader shader)
	{
		addPipelineUnit(shader);
		shaders.add(shader);
	}

	public void addShader(String shaderLocation)
	{
		Shader shader = new Shader(logicalDevice, shaderLocation, VK_SHADER_STAGE_COMPUTE_BIT);
		addPipelineUnit(shader);
		shaders.add(shader);
	}

	public void addPipelineBarrier(BufferBarrier barrier)
	{
		addPipelineUnit(barrier);
	}

	@Override
	protected long allocatePipelineLayout(MemoryStack stack)
	{
		DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(this);
		LongBuffer bDescriptorSet = stack.mallocLong(1);
		bDescriptorSet.put(descriptorSet.getLayoutId());
		bDescriptorSet.flip();

		// Create compute pipeline
		long[] aLayout = new long[1];
		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(bDescriptorSet);
		if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutCreateInfo, null,
				aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		return aLayout[0];
	}

	@Override
	public List<IPipelineExecutable> allocatePipeline(MemoryStack stack)
	{
		VkComputePipelineCreateInfo.Buffer pipelineCreateInfos = VkComputePipelineCreateInfo
				.callocStack(shaders.size(), stack);

		for (Shader shader : shaders)
		{
			VkPipelineShaderStageCreateInfo shaderInfo = shader.allocInfo();

			VkComputePipelineCreateInfo pipelineCreateInfo = pipelineCreateInfos.get();
			pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
			pipelineCreateInfo.stage(shaderInfo);
			pipelineCreateInfo.layout(pipelineLayout);
			shaderInfo.free();
		}
		pipelineCreateInfos.flip();

		long[] pipelines = new long[shaders.size()];
		if (vkCreateComputePipelines(logicalDevice.getVkDevice(), VK_NULL_HANDLE,
				pipelineCreateInfos, null, pipelines) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline!");
		}

		int indexPipeline = 0;

		int groupCountX = (int) Math.ceil(dataWidth / workgroupSize);
		int groupCountY = (int) Math.ceil(dataHeight / workgroupSize);
		int groupCountZ = (int) Math.ceil(dataDepth / workgroupSize);

		List<IPipelineExecutable> res = new ArrayList<>();
		for (IPipelineUnit unit : getUnits())
		{
			if (unit instanceof Shader)
			{
				res.add(new Computer(pipelines[indexPipeline++], groupCountX, groupCountY,
						groupCountZ));
			}
			else if (unit instanceof PipelineBarrier)
			{
				res.add((PipelineBarrier) unit);
			}
		}
		return res;
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}

	public void setWorkgroupSize(float workgroupSize)
	{
		this.workgroupSize = workgroupSize;
	}

	public float getWorkgroupSize()
	{
		return workgroupSize;
	}
}
