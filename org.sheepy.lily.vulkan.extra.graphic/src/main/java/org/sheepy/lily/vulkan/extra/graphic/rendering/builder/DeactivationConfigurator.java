package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;

import java.util.Objects;

public final class DeactivationConfigurator
{
	public static RenderPipelineSetup configure(RenderPipelineSetup setup)
	{
		new DeactivationConfigurator(setup).setupDeactivatorWhenEmptyPipeline();
		return setup;
	}

	private final RenderPipelineSetup setup;

	private DeactivationConfigurator(RenderPipelineSetup setup)
	{
		this.setup = setup;
	}

	private void setupDeactivatorWhenEmptyPipeline()
	{
		setup.dataProviders()
			 .stream()
			 .map(IIndexProviderAdapter::adapt)
			 .filter(Objects::nonNull)
			 .findAny()
			 .ifPresentOrElse(this::setupDeactivatorOnIndexedPipeline, this::setupDeactivatorOnVertexPipeline);
	}

	private void setupDeactivatorOnIndexedPipeline(IIndexProviderAdapter indexProviderAdapter)
	{
		indexProviderAdapter.listen(this::checkActivationIndex, IIndexProviderAdapter.Features.IndexCount);
		checkActivationIndex(indexProviderAdapter.getIndexCount());
	}

	private void checkActivationIndex(int count)
	{
		deactivatePipeline(count == 0);
	}

	private void setupDeactivatorOnVertexPipeline()
	{
		setup.dataProviders()
			 .stream()
			 .map(IVertexProviderAdapter::adapt)
			 .forEach(r -> r.listenNoParam(this::checkActivationVertex, IVertexProviderAdapter.Features.VertexCount));
		checkActivationVertex();
	}

	private void checkActivationVertex()
	{
		final var shouldDeactivate = setup.dataProviders()
										  .stream()
										  .map(IVertexProviderAdapter::adapt)
										  .mapToInt(IVertexProviderAdapter::getVertexCount)
										  .allMatch(vertexCount -> vertexCount == 0);

		deactivatePipeline(shouldDeactivate);
	}

	private void deactivatePipeline(boolean deactivate)
	{
		final boolean activate = !deactivate;
		if (setup.pipeline().isRecord() != activate)
		{
			setup.pipeline().setRecord(activate);
		}
	}
}
