package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;

@Statefull
@Adapter(scope = Computer.class)
public class ComputerAdapter implements IPipelineUnitAdapter<ComputeCommandBuffer>
{
	private int index;

	@Override
	public void record(IPipelineUnit unit, ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		var computePipeline = (ComputePipeline) unit.eContainer();
		var pipelineAdapter = ComputePipelineAdapter.adapt(computePipeline);

		var groupCountX = pipelineAdapter.getGroupCountX();
		var groupCountY = pipelineAdapter.getGroupCountY();
		var groupCountZ = pipelineAdapter.getGroupCountZ();

		var id = pipelineAdapter.getPipelineId(index);

		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), bindPoint, id);

		vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY, groupCountZ);
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public static ComputerAdapter adapt(Computer object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputerAdapter.class);
	}
}
