package org.sheepy.lily.vulkan.extra.graphic.rendering.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

@ModelExtender(scope = RenderIndexedDrawTask.class)
@Allocation
@AllocationDependency(features = RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE, type = IStructureAdapter.class)
@AllocationDependency(features = RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER, type = IIndexProviderAdapter.class)
public final class RenderIndexedDrawTaskAdapter implements IRecordableExtender
{
	private final int instanceCount;
	private final int indexCount;

	private RenderIndexedDrawTaskAdapter(RenderIndexedDrawTask task,
										 @InjectDependency(index = 0) IStructureAdapter structureAdapter,
										 @InjectDependency(index = 1) IIndexProviderAdapter indexProviderAdapter)
	{
		final var structure = task.getStructure();
		this.instanceCount = structureAdapter.getInstanceCount(structure);
		this.indexCount = indexProviderAdapter.getIndexCount();
	}

	@Override
	public void record(RecordContext context)
	{
		final int firstIndex = 0;
		final int vertexOffset = 0;
		final int firstInstance = 0;
		final var commandBuffer = context.commandBuffer;

		vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance);
	}
}
