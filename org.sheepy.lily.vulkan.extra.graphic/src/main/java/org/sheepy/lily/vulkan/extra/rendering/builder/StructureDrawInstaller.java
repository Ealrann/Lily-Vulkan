package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.rendering.data.IStructurePartDrawSetup;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

public final class StructureDrawInstaller<T extends Structure>
{
	private final GenericRenderer<T> maintainer;
	private final GraphicProcess graphicProcess;
	private final RenderPipelineBuilder pipelineBuilder;
	private final BufferInstaller<T> bufferInstaller;

	public StructureDrawInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;

		final var commonResources = List.copyOf(gatherCommonResources(maintainer));
		final var pipelineBuilder = new RenderPipelineBuilder(commonResources, maintainer);

		this.pipelineBuilder = pipelineBuilder;
		this.bufferInstaller = new BufferInstaller<>(maintainer);
		this.graphicProcess = ModelUtil.findParent(maintainer, GraphicProcess.class);
	}

	private static List<DescriptedResource> gatherCommonResources(GenericRenderer<?> maintainer)
	{
		final var resourceProvider = maintainer.getCommonResourceProvider();
		if (resourceProvider != null)
		{
			final var providerAdapter = resourceProvider.adaptNotNull(IResourceProviderAdapter.class);
			return List.copyOf(providerAdapter.getResources(resourceProvider));
		}
		return List.of();
	}

	public List<IStructurePartDrawSetup> install(T structure)
	{
		final boolean needMultiplePipelines = bufferInstaller.hasDynamicDescriptors
				|| bufferInstaller.hasIndexData;

		final var drawInstaller = new DrawTaskInstaller(structure, maintainer.getConstantBuffer());
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final int count = structureAdapter.getPartCount(structure);

		if (needMultiplePipelines)
		{
			return prepareMultiplePipelines(structure, drawInstaller, count);
		}
		else
		{
			return prepareSinglePipeline(structure, drawInstaller, count);
		}
	}

	private List<IStructurePartDrawSetup> prepareSinglePipeline(T structure,
																DrawTaskInstaller drawInstaller,
																int count)
	{
		final List<IStructurePartDrawSetup> res = new ArrayList<>();
		final var pipelineContext = createAndInstallPipeline(pipelineBuilder);

		for (int index = 0; index < count; index++)
		{
			res.add(installDraw(structure, drawInstaller, pipelineContext, index));
		}

		return res;
	}

	private List<IStructurePartDrawSetup> prepareMultiplePipelines(	T structure,
																	DrawTaskInstaller drawInstaller,
																	int count)
	{
		final List<IStructurePartDrawSetup> res = new ArrayList<>();

		for (int index = 0; index < count; index++)
		{
			final var pipelineContext = createAndInstallPipeline(pipelineBuilder);
			res.add(installDraw(structure, drawInstaller, pipelineContext, index));
		}

		return res;
	}

	private IStructurePartDrawSetup installDraw(T structure,
												DrawTaskInstaller drawInstaller,
												GraphicsPipeline pipeline,
												int index)
	{
		final var bufferContext = bufferInstaller.install(pipeline, structure, index);
		return drawInstaller.install(bufferContext);
	}

	private GraphicsPipeline createAndInstallPipeline(RenderPipelineBuilder pipelineBuilder)
	{
		final var parts = graphicProcess.getPartPkg().getParts();
		final int maintainerIndex = parts.indexOf(maintainer);
		final var pipeline = pipelineBuilder.build(maintainerIndex, maintainer.getSpecialization());
		parts.add(maintainerIndex + 1, pipeline);
		return pipeline;
	}
}