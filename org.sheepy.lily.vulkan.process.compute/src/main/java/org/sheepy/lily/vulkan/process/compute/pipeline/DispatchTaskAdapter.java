package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

@Statefull
@Adapter(scope = DispatchTask.class)
public class DispatchTaskAdapter implements IPipelineTaskAdapter<DispatchTask>
{
	@Override
	public void record(DispatchTask task, IRecordContext context)
	{
		final var commandBuffer = ((RecordContext) context).commandBuffer;
		final int groupCountX = task.getWorkgroupCountX();
		final int groupCountY = task.getWorkgroupCountY();
		final int groupCountZ = task.getWorkgroupCountZ();

		vkCmdDispatch(commandBuffer, groupCountX, groupCountY, groupCountZ);
	}
}
