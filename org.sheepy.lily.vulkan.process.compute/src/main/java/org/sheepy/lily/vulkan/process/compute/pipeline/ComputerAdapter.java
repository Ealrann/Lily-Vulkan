package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.compute.Computer;

@Statefull
@Adapter(scope = Computer.class)
public class ComputerAdapter implements IPipelineTaskAdapter<Computer>
{
	@Override
	public void record(Computer task, RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;
		final int groupCountX = task.getWorkgroupCountX();
		final int groupCountY = task.getWorkgroupCountY();
		final int groupCountZ = task.getWorkgroupCountZ();

		vkCmdDispatch(commandBuffer, groupCountX, groupCountY, groupCountZ);
	}

	@Override
	public boolean needRecord(Computer task, int index)
	{
		return false;
	}
}
