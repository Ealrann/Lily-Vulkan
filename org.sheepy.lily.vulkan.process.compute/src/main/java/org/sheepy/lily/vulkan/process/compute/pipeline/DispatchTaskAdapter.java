package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

@ModelExtender(scope = DispatchTask.class)
@Adapter
public final class DispatchTaskAdapter implements IRecordableAdapter
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
