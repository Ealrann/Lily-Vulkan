package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexSupplier;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;

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
		setup.indexSuppliers()
			 .ifPresentOrElse(this::setupDeactivatorOnIndexedPipeline, this::setupDeactivatorOnVertexPipeline);
	}

	private void setupDeactivatorOnIndexedPipeline(IIndexSupplier indexProviderAdapter)
	{
		indexProviderAdapter.listen(this::checkActivationIndex, IIndexSupplier.Features.IndexCount);
		checkActivationIndex(indexProviderAdapter.getIndexCount());
	}

	private void checkActivationIndex(int count)
	{
		deactivatePipeline(count == 0);
	}

	private void setupDeactivatorOnVertexPipeline()
	{
		setup.streamVertexSuppliers()
			 .forEach(r -> r.listenNoParam(this::checkActivationVertex, IVertexSupplier.Features.VertexCount));
		checkActivationVertex();
	}

	private void checkActivationVertex()
	{
		final var shouldDeactivate = setup.streamVertexSuppliers()
										  .mapToInt(IVertexSupplier::getVertexCount)
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
