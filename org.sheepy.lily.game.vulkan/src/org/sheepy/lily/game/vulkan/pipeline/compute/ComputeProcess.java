package org.sheepy.lily.game.vulkan.pipeline.compute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

/**
 * A set of ComputePipeline.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess
{
	private List<ComputePipeline> computePipelines = new ArrayList<>();

	protected DescriptorPool descriptorPool;

	public ComputeProcess(LogicalDevice logicalDevice, List<ComputePipeline> computePipeline)
	{
		this.computePipelines.addAll(computePipeline);

		descriptorPool = new DescriptorPool(logicalDevice);
	}

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public void addPipeline(ComputePipeline pipeline)
	{
		computePipelines.add(pipeline);
	}

	public void load(MemoryStack stack)
	{
		descriptorPool.load(stack, computePipelines);

		for (ComputePipeline pipeline : computePipelines)
		{
			pipeline.load(descriptorPool.getDescriptorSet(pipeline));
		}
	}

	public void free()
	{
		if (descriptorPool != null) descriptorPool.destroy();

		for (ComputePipeline pipeline : computePipelines)
		{
			pipeline.free();
		}
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
