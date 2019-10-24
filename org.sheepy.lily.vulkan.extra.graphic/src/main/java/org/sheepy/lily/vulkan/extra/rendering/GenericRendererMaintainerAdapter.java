package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.rendering.builder.BufferInstaller;
import org.sheepy.lily.vulkan.extra.rendering.builder.DrawTaskInstaller;
import org.sheepy.lily.vulkan.extra.rendering.builder.DrawTaskInstaller.IDrawSetup;
import org.sheepy.lily.vulkan.extra.rendering.builder.RenderPipelineBuilder;
import org.sheepy.lily.vulkan.extra.rendering.builder.RenderPipelineContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

@Statefull
@Adapter(scope = GenericRenderer.class, scopeInheritance = true)
public final class GenericRendererMaintainerAdapter<T extends Structure> implements IVulkanAdapter
{
	private static final EClass RENDERER_ECLASS = RenderingPackage.Literals.GENERIC_RENDERER;

	private final GenericRenderer<T> maintainer;
	private final GraphicProcess graphicProcess;
	private final List<RenderPipelineContext> contexts = new ArrayList<>();
	private final List<IDrawSetup> drawSetups = new ArrayList<>();

	public GenericRendererMaintainerAdapter(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
		this.graphicProcess = ModelUtil.findParent(maintainer, GraphicProcess.class);
	}

	@Autorun
	public void load()
	{
		if (maintainer.isEnabled())
		{
			buildPipelines();
		}
	}

	@Tick
	public void update()
	{
		for (int i = 0; i < drawSetups.size(); i++)
		{
			final var drawSetup = drawSetups.get(i);
			drawSetup.update();
		}
	}

	private void buildPipelines()
	{
		final var structures = maintainer.getRenderedStructures().stream();
		final var structInstaller = new BufferInstaller<>(maintainer);
		final var presentedEClass = ModelUtil.resolveGenericType(maintainer, RENDERER_ECLASS);
		final var commonResources = List.copyOf(gatherCommonResources(maintainer));
		final var pipContextBuilder = new RenderPipelineBuilder(commonResources, maintainer);

		structures.forEach(s -> preparePipeline(pipContextBuilder, structInstaller, s));

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printDebugInfo(presentedEClass);
		}
	}

	private void preparePipeline(	RenderPipelineBuilder pipelineBuilder,
									BufferInstaller<T> bufferInstaller,
									T structure)
	{
		final boolean needMultiplePipelines = bufferInstaller.hasDynamicDescriptors
				|| bufferInstaller.hasIndexData;

		if (needMultiplePipelines)
		{
			prepareMultiplePipelines(pipelineBuilder, bufferInstaller, structure);
		}
		else
		{
			prepareSinglePipeline(pipelineBuilder, bufferInstaller, structure);
		}
	}

	private void prepareSinglePipeline(	RenderPipelineBuilder pipelineBuilder,
										BufferInstaller<T> bufferInstaller,
										T structure)
	{
		final int pipelineCount = graphicProcess.getPartPkg().getParts().size();
		final var structureAdapter = IStructureAdapter.adapt(structure);
		final var drawInstaller = new DrawTaskInstaller(structure);
		final var pipelineContext = createAndInstallPipeline(pipelineBuilder, pipelineCount + 1);

		for (int i = 0; i < structureAdapter.getPartCount(structure); i++)
		{
			final var bufferContext = bufferInstaller.install(pipelineContext, structure, i);
			drawSetups.add(drawInstaller.install(bufferContext));
		}
	}

	private void prepareMultiplePipelines(	RenderPipelineBuilder pipelineBuilder,
											BufferInstaller<T> bufferInstaller,
											T structure)
	{
		final int pipelineCount = graphicProcess.getPartPkg().getParts().size();
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final var drawInstaller = new DrawTaskInstaller(structure);

		for (int i = 0; i < structureAdapter.getPartCount(structure); i++)
		{
			final var pipelineContext = createAndInstallPipeline(	pipelineBuilder,
																	pipelineCount + i + 1);
			final var bufferContext = bufferInstaller.install(pipelineContext, structure, i);
			drawSetups.add(drawInstaller.install(bufferContext));
		}
	}

	private RenderPipelineContext createAndInstallPipeline(	RenderPipelineBuilder pipelineBuilder,
															final int pipelineCount)
	{
		final var context = pipelineBuilder.build(pipelineCount + 1);
		final var parts = graphicProcess.getPartPkg().getParts();
		final int maintainerIndex = parts.indexOf(maintainer);
		parts.add(maintainerIndex, context.pipeline);
		contexts.add(context);
		return context;
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

	private void printDebugInfo(final EClassifier presentedEClass)
	{
		final var classifier = presentedEClass.getInstanceClass();
		final var name = maintainer.getName();
		final var className = classifier.getSimpleName();
		final int count = contexts.size();
		System.out.println(String.format(	"Create %d pipelines for %s [%s].",
											count,
											name,
											className));
	}
}