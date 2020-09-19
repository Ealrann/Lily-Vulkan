package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class RenderPipelinesInstaller<T extends Structure>
{
	private final GenericRenderer<T> maintainer;
	private final AbstractRenderPipelineInstaller<T> pipelineInstaller;

	public RenderPipelinesInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;

		final var pipelineBuilder = new RenderPipelineBuilder(maintainer);
		final var needMultiplePipelines = maintainer.isOnePipelinePerPart() || isContainingIndexData(maintainer);

		pipelineInstaller = needMultiplePipelines
				? new MultiplePipelineInstaller<>(maintainer, pipelineBuilder)
				: new SinglePipelineInstaller<>(maintainer, pipelineBuilder);
	}

	public Stream<RenderPipelineSetup> install(T structure, int drawCallOffset)
	{
		final var drawInstaller = new DrawTaskConfigurator(maintainer.getConstantBuffer());
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final int count = structureAdapter.getPartCount(structure);

		return pipelineInstaller.install(structure, count, drawCallOffset).map(drawInstaller::install);
	}

	private static boolean isContainingIndexData(GenericRenderer<?> maintainer)
	{
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		return dataProviders.stream().anyMatch(IndexedDataDescription.class::isInstance);
	}

	private static abstract class AbstractRenderPipelineInstaller<T extends Structure>
	{
		protected final GenericRenderer<T> maintainer;
		protected final RenderPipelineBuilder pipelineBuilder;
		protected final Subpass subpass;

		protected AbstractRenderPipelineInstaller(final GenericRenderer<T> maintainer,
												  final RenderPipelineBuilder pipelineBuilder)
		{
			this.maintainer = maintainer;
			this.pipelineBuilder = pipelineBuilder;

			this.subpass = ModelUtil.findParent(maintainer, Subpass.class);
		}

		protected GraphicsPipeline createAndInstallPipeline(RenderPipelineBuilder pipelineBuilder)
		{
			final var pipelines = subpass.getPipelinePkg().getPipelines();
			final int maintainerIndex = pipelines.indexOf(maintainer);
			final var pipeline = pipelineBuilder.build(maintainerIndex, maintainer.getSpecialization());
			pipelines.add(maintainerIndex + 1, pipeline);
			return pipeline;
		}

		public final Stream<PipelineBuildContext<T>> install(final T structure,
															 final int count,
															 final int drawCallOffset)
		{
			load(structure, count, drawCallOffset);
			return IntStream.range(0, count).mapToObj(this::prepareIndex);
		}

		protected abstract void load(final T structure, final int count, final int drawCallOffset);
		protected abstract PipelineBuildContext<T> prepareIndex(final int index);
	}

	private static final class SinglePipelineInstaller<T extends Structure> extends AbstractRenderPipelineInstaller<T>
	{

		private ResourceInstaller<T> resourceInstaller;

		SinglePipelineInstaller(final GenericRenderer<T> maintainer, final RenderPipelineBuilder pipelineBuilder)
		{
			super(maintainer, pipelineBuilder);
		}

		@Override
		protected void load(final T structure, final int count, final int drawCallOffset)
		{
			final var pipeline = createAndInstallPipeline(pipelineBuilder);
			resourceInstaller = new ResourceInstaller<>(maintainer, structure, pipeline, drawCallOffset, count);
		}

		@Override
		protected PipelineBuildContext<T> prepareIndex(final int index)
		{
			final var pipelineBuildContext = resourceInstaller.prepare(index);
			return pipelineBuildContext;
		}
	}

	private static final class MultiplePipelineInstaller<T extends Structure> extends AbstractRenderPipelineInstaller<T>
	{
		private T structure;
		private int count;
		private int drawCallOffset;

		MultiplePipelineInstaller(final GenericRenderer<T> maintainer, final RenderPipelineBuilder pipelineBuilder)
		{
			super(maintainer, pipelineBuilder);
		}

		@Override
		protected void load(final T structure, final int count, final int drawCallOffset)
		{
			this.structure = structure;
			this.count = count;
			this.drawCallOffset = drawCallOffset;
		}

		@Override
		protected PipelineBuildContext<T> prepareIndex(final int index)
		{
			final var pipeline = createAndInstallPipeline(pipelineBuilder);
			final var resourceInstaller = new ResourceInstaller<>(maintainer,
																  structure,
																  pipeline,
																  drawCallOffset,
																  count);
			final var resourceContext = resourceInstaller.prepare(index);
			return resourceContext;
		}
	}
}