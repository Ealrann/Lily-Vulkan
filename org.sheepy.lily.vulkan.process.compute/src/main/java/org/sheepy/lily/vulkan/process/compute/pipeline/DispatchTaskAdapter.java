package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

@ModelExtender(scope = DispatchTask.class)
@Adapter
public final class DispatchTaskAdapter implements IRecordableExtender
{
	private final DispatchTask task;

	private DispatchTaskAdapter(DispatchTask task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;
		final int groupCountX = task.getWorkgroupCountX();
		final int groupCountY = task.getWorkgroupCountY();
		final int groupCountZ = task.getWorkgroupCountZ();

		vkCmdDispatch(commandBuffer, groupCountX, groupCountY, groupCountZ);
	}
}
