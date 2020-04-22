package org.sheepy.lily.vulkan.extra.graphic.rendering.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkCmdDraw;

@ModelExtender(scope = RenderDrawTask.class)
@Allocation
@AllocationDependency(features = RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS, type = IVertexProviderAdapter.class)
public final class RenderDrawTaskAdapter implements IPipelineTaskRecorder
{
	private final int vertexCount;

	private RenderDrawTaskAdapter(@InjectDependency(index = 0) List<IVertexProviderAdapter> vertexProviderAdapters)
	{
		vertexCount = vertexProviderAdapters.stream().mapToInt(IVertexProviderAdapter::getVertexCount).sum();
	}

	@Override
	public void record(RecordContext context)
	{
		final int instanceCount = 1;
		final int firstVertex = 0;
		final int firstInstance = 0;
		final var commandBuffer = context.commandBuffer;

		vkCmdDraw(commandBuffer, vertexCount, instanceCount, firstVertex, firstInstance);
	}
}
