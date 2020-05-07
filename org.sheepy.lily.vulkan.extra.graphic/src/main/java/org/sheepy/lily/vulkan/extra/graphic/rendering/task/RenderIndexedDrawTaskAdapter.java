package org.sheepy.lily.vulkan.extra.graphic.rendering.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

@ModelExtender(scope = RenderIndexedDrawTask.class)
@Adapter
public class RenderIndexedDrawTaskAdapter implements IPipelineTaskAdapter<RenderIndexedDrawTask>
{
	private int instanceCount;
	private int indexCount;
	private boolean hasChanged = true;

	@Override
	public void update(RenderIndexedDrawTask task, int index)
	{
		final var structure = task.getStructure();
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final var indexProvider = task.getIndexProvider().adapt(IIndexProviderAdapter.class);

		if (structureAdapter.getInstanceCount(structure) != instanceCount)
		{
			instanceCount = structureAdapter.getInstanceCount(structure);
			hasChanged = true;
		}
		if (indexCount != indexProvider.getIndexCount())
		{
			indexCount = indexProvider.getIndexCount();
			hasChanged = true;
		}
	}

	@Override
	public void record(RenderIndexedDrawTask task, IRecordContext context)
	{
		final int firstIndex = 0;
		final int vertexOffset = 0;
		final int firstInstance = 0;
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance);

		hasChanged = false;
	}

	@Override
	public boolean needRecord(RenderIndexedDrawTask task, int index)
	{
		return hasChanged;
	}
}
