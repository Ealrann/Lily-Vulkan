package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

import org.joml.Vector3ic;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.vulkan.pipeline.VkPipeline;

@Statefull
@Adapter(scope = Computer.class)
public class ComputerAdapter implements IPipelineTaskAdapter<Computer>
{
	private VkPipeline<?> vkPipeline;
	private Vector3ic groupCount;

	@Override
	public void record(Computer task, RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;

		vkPipeline.bindPipeline(commandBuffer, context.bindPoint);
		vkCmdDispatch(commandBuffer, groupCount.x(), groupCount.y(), groupCount.z());
	}

	public void setVkPipeline(VkPipeline<?> vkPipeline)
	{
		this.vkPipeline = vkPipeline;
	}

	public static ComputerAdapter adapt(Computer object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputerAdapter.class);
	}

	public void setGroupCount(Vector3ic groupCount)
	{
		this.groupCount = groupCount;
	}

	@Override
	public boolean needRecord(Computer task, int index)
	{
		return false;
	}
}
