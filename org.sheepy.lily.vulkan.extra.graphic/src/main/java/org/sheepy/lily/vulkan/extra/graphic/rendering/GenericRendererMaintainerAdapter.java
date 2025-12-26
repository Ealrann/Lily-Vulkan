package org.sheepy.lily.vulkan.extra.graphic.rendering;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.logoce.lmf.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IEntityResolverAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IGenericRendererAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.builder.DeactivationConfigurator;
import org.sheepy.lily.vulkan.extra.graphic.rendering.builder.RenderPipelinesInstaller;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.util.List;

@ModelExtender(scope = GenericRenderer.class, inherited = true)
@Adapter
@AutoLoad
public final class GenericRendererMaintainerAdapter<T extends Structure> implements IGenericRendererAdapter
{
	private static final Group<?> RENDERER_GROUP = RenderingModelDefinition.Groups.GENERIC_RENDERER;

	private final GenericRenderer<T> maintainer;

	private List<RenderPipelineSetup> renderPipelineSetups = List.of();

	private GenericRendererMaintainerAdapter(final GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
	}

	@Load
	private void load()
	{
		if (maintainer.maintaining())
		{
			buildPipelines();
		}
	}

	private void buildPipelines()
	{
		final var structures = maintainer.renderedStructures();
		final var structureDrawInstaller = new RenderPipelinesInstaller<>(maintainer);

		int drawCall = 0;
		for (int i = 0; i < structures.size(); i++)
		{
			final var structure = structures.get(i);

			renderPipelineSetups = structureDrawInstaller.install(structure, drawCall)
														 .map(DeactivationConfigurator::configure)
														 .toList();

			drawCall += renderPipelineSetups.size();
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printDebugInfo();
		}
	}

	private void printDebugInfo()
	{
		final var presentedGroup = ModelUtil.resolveGenericType(maintainer, RENDERER_GROUP);
		final var name = maintainer.name();
		final var className = presentedGroup != null ? presentedGroup.name() : "Unknown";
		final int count = renderPipelineSetups.size();
		System.out.printf("Create %d pipelines for %s [%s].%n", count, name, className);
	}

	private void throwResolverNotFoundError() throws AssertionError
	{
		throw new AssertionError("The StructureAdapter or one DataProviderAdapter of " + maintainer.lmGroup()
																								   .name() + " must implements " + IEntityResolverAdapter.class.getSimpleName());
	}
}
