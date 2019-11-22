package org.sheepy.lily.vulkan.extra.rendering.task;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;

@Statefull
@Adapter(scope = RenderIndexedDrawTask.class)
public class RenderIndexedDrawTaskAdapter implements IPipelineTaskAdapter<RenderIndexedDrawTask>
{
	private int instanceCount;
	private int indexCount;
	private boolean hasChanged = true;

	@Override
	public void update(RenderIndexedDrawTask task)
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
	public void record(RenderIndexedDrawTask task, RecordContext context)
	{
		final int firstIndex = 0;
		final int vertexOffset = 0;
		final int firstInstance = 0;

		vkCmdDrawIndexed(	context.commandBuffer,
							indexCount,
							instanceCount,
							firstIndex,
							vertexOffset,
							firstInstance);

		hasChanged = false;
	}

	@Override
	public boolean needRecord(RenderIndexedDrawTask task, int index)
	{
		return hasChanged;
	}
}
