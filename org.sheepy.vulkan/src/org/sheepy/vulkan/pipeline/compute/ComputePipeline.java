package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;
import static org.lwjgl.vulkan.VK10.VK_SHADER_STAGE_COMPUTE_BIT;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;
import static org.lwjgl.vulkan.VK10.vkCreateComputePipelines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.buffer.BufferBarrier;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.pipeline.AbstractCompositePipeline;
import org.sheepy.vulkan.pipeline.Context;
import org.sheepy.vulkan.pipeline.IPipelineUnit;
import org.sheepy.vulkan.pipeline.IProcessUnit;
import org.sheepy.vulkan.pipeline.PipelineBarrier;
import org.sheepy.vulkan.resource.Shader;
import org.sheepy.vulkan.util.ModuleResource;

public class ComputePipeline extends AbstractCompositePipeline
{
	private static final float DEFAULT_WORKGROUP_SIZE = 32;

	protected List<Shader> shaders = new ArrayList<>();

	protected float workgroupSizeX = DEFAULT_WORKGROUP_SIZE;
	protected float workgroupSizeY = DEFAULT_WORKGROUP_SIZE;
	protected float workgroupSizeZ = DEFAULT_WORKGROUP_SIZE;

	private int dataWidth;
	private int dataHeight;
	private int dataDepth;

	public ComputePipeline(Context context, int width, int height, int depth,
			List<IDescriptor> descriptors, ModuleResource shaderResource)
	{
		this(context, width, height, depth, descriptors, Collections.singletonList(
				new Shader(context.logicalDevice, shaderResource, VK_SHADER_STAGE_COMPUTE_BIT)));
	}

	public ComputePipeline(Context context, int width, int height, int depth,
			List<IDescriptor> descriptors, Shader shader)
	{
		this(context, width, height, depth, descriptors, Collections.singletonList(shader));
	}

	public ComputePipeline(Context context, List<IDescriptor> descriptors)
	{
		this(context, -1, -1, -1, descriptors, Collections.emptyList());
	}

	public ComputePipeline(Context context)
	{
		this(context, -1, -1, -1, Collections.emptyList(), Collections.emptyList());
	}

	public ComputePipeline(Context context, int width, int height, int depth,
			List<IDescriptor> descriptors)
	{
		this(context, width, height, depth, descriptors, Collections.emptyList());
	}

	public ComputePipeline(Context context, int width, int height, int depth,
			List<IDescriptor> descriptors, List<Shader> shaders)
	{
		super(context, descriptors);

		this.dataWidth = width;
		this.dataHeight = height;
		this.dataDepth = depth;

		addPipelineUnits(shaders);
		this.shaders.addAll(shaders);

		for (Shader shader : shaders)
		{
			context.resourceManager.addResource(shader);
		}
	}

	public void addShader(Shader shader)
	{
		addPipelineUnit(shader);
		shaders.add(shader);
		context.resourceManager.addResource(shader);
	}

	public void addPipelineBarrier(BufferBarrier barrier)
	{
		addPipelineUnit(barrier);
	}

	@Override
	public List<IProcessUnit> allocatePipeline(MemoryStack stack)
	{
		List<IProcessUnit> res = new ArrayList<>();
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
		if (vkCreateComputePipelines(context.getVkDevice(), VK_NULL_HANDLE, pipelineCreateInfos,
				null, pipelines) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline!");
		}

		int indexPipeline = 0;

		int groupCountX = (int) Math.ceil(dataWidth / workgroupSizeX);
		int groupCountY = (int) Math.ceil(dataHeight / workgroupSizeY);
		int groupCountZ = (int) Math.ceil(dataDepth / workgroupSizeZ);

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

	public int getDataWidth()
	{
		return dataWidth;
	}

	public int getDataHeight()
	{
		return dataHeight;
	}

	public int getDataDepth()
	{
		return dataDepth;
	}

	public void setDataSize(int dataWidth, int dataHeight, int dataDepth)
	{
		this.dataWidth = dataWidth;
		this.dataHeight = dataHeight;
		this.dataDepth = dataDepth;
		dirty = true;
	}
}
