package org.sheepy.lily.vulkan.extra.graphic.rendering;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IEntityResolver;
import org.sheepy.lily.vulkan.extra.api.rendering.IGenericRendererAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.graphic.rendering.builder.DeactivationConfigurator;
import org.sheepy.lily.vulkan.extra.graphic.rendering.builder.RenderPipelinesInstaller;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = GenericRenderer.class, inherited = true)
@Adapter(lazy = false)
public final class GenericRendererMaintainerAdapter<T extends Structure> implements IGenericRendererAdapter
{
	private static final EClass RENDERER_ECLASS = RenderingPackage.Literals.GENERIC_RENDERER;

	private final GenericRenderer<T> maintainer;

	private List<RenderPipelineSetup> renderPipelineSetups = List.of();

	public GenericRendererMaintainerAdapter(final GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
	}

	@Load
	public void load()
	{
		if (maintainer.isMaintaining())
		{
			buildPipelines();
		}
	}

	private void buildPipelines()
	{
		final var structures = maintainer.getRenderedStructures();
		final var structureDrawInstaller = new RenderPipelinesInstaller<>(maintainer);

		int drawCall = 0;
		for (int i = 0; i < structures.size(); i++)
		{
			final var structure = structures.get(i);

			renderPipelineSetups = structureDrawInstaller.install(structure, drawCall)
														 .map(DeactivationConfigurator::configure)
														 .collect(Collectors.toUnmodifiableList());

			drawCall += renderPipelineSetups.size();
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printDebugInfo();
		}
	}

	@Override
	public PresentableEntity resolvePresentedEntity(final RenderPointer renderPointer)
	{
		final int drawCall = renderPointer.drawcall;
		final var renderSetup = renderPipelineSetups.get(drawCall);
		final var structure = renderSetup.structure();
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final var resolver = findEntityResolver(renderSetup, structureAdapter);

		return resolver.resolveEntity(renderPointer);
	}

	private IEntityResolver findEntityResolver(final RenderPipelineSetup renderSetup,
											   final IStructureAdapter structureAdapter) throws AssertionError
	{
		IEntityResolver resolver = null;
		if (structureAdapter instanceof IEntityResolver)
		{
			resolver = (IEntityResolver) structureAdapter;
		}
		else
		{
			final var dataProviders = renderSetup.dataProviders();
			for (int i = 0; i < dataProviders.size(); i++)
			{
				final var dataProvider = dataProviders.get(i);
				resolver = dataProvider.adapt(IEntityResolver.class);
				if (resolver != null)
				{
					break;
				}
			}
		}
		if (resolver == null)
		{
			throwResolverNotFoundError();
		}
		return resolver;
	}

	private void printDebugInfo()
	{
		final var presentedEClass = ModelUtil.resolveGenericType(maintainer, RENDERER_ECLASS);
		final var classifier = presentedEClass.getInstanceClass();
		final var name = maintainer.getName();
		final var className = classifier.getSimpleName();
		final int count = renderPipelineSetups.size();
		System.out.printf("Create %d pipelines for %s [%s].%n", count, name, className);
	}

	private void throwResolverNotFoundError() throws AssertionError
	{
		throw new AssertionError("The StructureAdapter or one DataProviderAdapter of " + maintainer.eClass()
																								   .getName() + " must implements " + IEntityResolver.class
				.getSimpleName());
	}
}