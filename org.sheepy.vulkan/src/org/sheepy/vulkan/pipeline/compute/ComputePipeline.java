package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.buffer.BufferBarrier;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.AbstractPipeline;
import org.sheepy.vulkan.pipeline.IPipelineExecutable;
import org.sheepy.vulkan.pipeline.IPipelineUnit;
import org.sheepy.vulkan.pipeline.PipelineBarrier;
import org.sheepy.vulkan.shader.Shader;

public class ComputePipeline extends AbstractPipeline
		implements IComputeProcessUnit
{
	private static final float DEFAULT_WORKGROUP_SIZE = 32;

	protected List<Shader> shaders = new ArrayList<>();

	protected float workgroupSizeX = DEFAULT_WORKGROUP_SIZE;
	protected float workgroupSizeY = DEFAULT_WORKGROUP_SIZE;
	protected float workgroupSizeZ = DEFAULT_WORKGROUP_SIZE;

	private int dataWidth = -1;
	private int dataHeight = -1;
	private int dataDepth = -1;

	public ComputePipeline(LogicalDevice logicalDevice, int width, int height, int depth,
			List<IDescriptor> descriptors, String shaderLocation)
	{
		this(width, height, depth, descriptors, Collections.singletonList(
				new Shader(logicalDevice, shaderLocation, VK_SHADER_STAGE_COMPUTE_BIT)));
	}

	public ComputePipeline(int width, int height, int depth, List<IDescriptor> descriptors,
			Shader shader)
	{
		this(width, height, depth, descriptors, Collections.singletonList(shader));
	}

	public ComputePipeline(int width, int height, int depth, List<IDescriptor> descriptors)
	{
		this(width, height, depth, descriptors, Collections.emptyList());
	}

	public ComputePipeline(int width, int height, int depth, List<IDescriptor> descriptors,
			List<Shader> shaders)
	{
		super(descriptors);
		
		this.dataWidth = width;
		this.dataHeight = height;
		this.dataDepth = depth;

		addPipelineUnits(shaders);
		this.shaders.addAll(shaders);
	}

	public void addShader(Shader shader)
	{
		addPipelineUnit(shader);
		shaders.add(shader);
	}

	public void addPipelineBarrier(BufferBarrier barrier)
	{
		addPipelineUnit(barrier);
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

		int groupCountX = (int) Math.ceil(dataWidth / workgroupSizeX);
		int groupCountY = (int) Math.ceil(dataHeight / workgroupSizeY);
		int groupCountZ = (int) Math.ceil(dataDepth / workgroupSizeZ);

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

	public void setWorkgroupSize(int x, int y, int z)
	{
		this.workgroupSizeX = x;
		this.workgroupSizeY = y;
		this.workgroupSizeZ = z;
	}
}
