package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.execution.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.model.ComputePipeline;
import org.sheepy.vulkan.model.Computer;
import org.sheepy.vulkan.pipeline.IProcessUnitAdapter;

public class ComputerAdapter extends AbstractSheepyAdapter
		implements IProcessUnitAdapter<ComputeCommandBuffer>
{
	@Override
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		var computer = (Computer) target;
		var computePipeline = (ComputePipeline) computer.eContainer();
		var index = computePipeline.getComputers().indexOf(computer);
		var pipelineAdapter = ComputePipelineAdapter.adapt(computePipeline);

		var groupCountX = pipelineAdapter.getGroupCountX();
		var groupCountY = pipelineAdapter.getGroupCountY();
		var groupCountZ = pipelineAdapter.getGroupCountZ();

		var id = pipelineAdapter.getPipelineId(index);

		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), bindPoint, id);

		vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY, groupCountZ);
	}

	public static ComputerAdapter adapt(Computer object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ComputerAdapter.class);
	}
}
