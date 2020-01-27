package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.IStructurePartDrawSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

public final class StructureDrawInstaller<T extends Structure>
{
	private final GenericRenderer<T> maintainer;
	private final Subpass subpass;
	private final RenderPipelineBuilder pipelineBuilder;

	public StructureDrawInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;

		final var pipelineBuilder = new RenderPipelineBuilder(maintainer);

		this.pipelineBuilder = pipelineBuilder;
		this.subpass = ModelUtil.findParent(maintainer, Subpass.class);
	}

	public List<IStructurePartDrawSetup> install(T structure, int drawCallOffset)
	{
		final boolean needMultiplePipelines = maintainer.isOnePipelinePerPart()
				|| isContainingIndexData();
		final var drawInstaller = new DrawTaskInstaller(structure, maintainer.getConstantBuffer());
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final int count = structureAdapter.getPartCount(structure);

		if (needMultiplePipelines)
		{
			return prepareMultiplePipelines(structure, drawInstaller, count, drawCallOffset);
		}
		else
		{
			return prepareSinglePipeline(structure, drawInstaller, count, drawCallOffset);
		}
	}

	private boolean isContainingIndexData()
	{
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		return dataProviders.stream().anyMatch(IndexProvider.class::isInstance);
	}

	private List<IStructurePartDrawSetup> prepareSinglePipeline(T structure,
																DrawTaskInstaller drawInstaller,
																int count,
																int drawCallOffset)
	{
		final List<IStructurePartDrawSetup> res = new ArrayList<>();
		final var pipeline = createAndInstallPipeline(pipelineBuilder);
		final var resourceInstaller = new ResourceInstaller<>(maintainer);
		resourceInstaller.prepare(pipeline, structure, count);

		for (int index = 0; index < count; index++)
		{
			final var bufferContext = resourceInstaller.setupBindTask(	pipeline,
																		index,
																		drawCallOffset + index);
			res.add(drawInstaller.install(bufferContext));
		}

		return res;
	}

	private List<IStructurePartDrawSetup> prepareMultiplePipelines(	T structure,
																	DrawTaskInstaller drawInstaller,
																	int count,
																	int drawCallOffset)
	{
		final List<IStructurePartDrawSetup> res = new ArrayList<>();

		for (int index = 0; index < count; index++)
		{
			final var pipeline = createAndInstallPipeline(pipelineBuilder);
			final var resourceInstaller = new ResourceInstaller<>(maintainer);
			resourceInstaller.prepare(pipeline, structure, count);
			final var bufferContext = resourceInstaller.setupBindTask(	pipeline,
																		index,
																		drawCallOffset + index);
			res.add(drawInstaller.install(bufferContext));
		}

		return res;
	}

	private GraphicsPipeline createAndInstallPipeline(RenderPipelineBuilder pipelineBuilder)
	{
		final var pipelines = subpass.getPipelinePkg().getPipelines();
		final int maintainerIndex = pipelines.indexOf(maintainer);
		final var pipeline = pipelineBuilder.build(maintainerIndex, maintainer.getSpecialization());
		pipelines.add(maintainerIndex + 1, pipeline);
		return pipeline;
	}
}