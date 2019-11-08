package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IEntityResolver;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IRenderDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IGenericRendererAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.rendering.builder.StructureDrawInstaller;
import org.sheepy.lily.vulkan.extra.rendering.data.IStructurePartDrawSetup;

@Statefull
@Adapter(scope = GenericRenderer.class, scopeInheritance = true, lazy = false)
public final class GenericRendererMaintainerAdapter<T extends Structure>
		implements IGenericRendererAdapter
{
	private static final EClass RENDERER_ECLASS = RenderingPackage.Literals.GENERIC_RENDERER;

	private final GenericRenderer<T> maintainer;
	private final List<IStructurePartDrawSetup> structurePartDrawSetups = new ArrayList<>();

	public GenericRendererMaintainerAdapter(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
	}

	@Load
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
		for (int i = 0; i < structurePartDrawSetups.size(); i++)
		{
			final var drawSetup = structurePartDrawSetups.get(i);
			drawSetup.update();
		}
	}

	private void buildPipelines()
	{
		final var structures = maintainer.getRenderedStructures();
		final var structureDrawInstaller = new StructureDrawInstaller<>(maintainer);

		for (final var structure : structures)
		{
			final var drawSetups = structureDrawInstaller.install(structure);
			structurePartDrawSetups.addAll(drawSetups);
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printDebugInfo();
		}
	}

	@Override
	public PresentableEntity resolvePresentedEntity(RenderPointer renderPointer)
	{
		final int drawCall = renderPointer.drawcall;
		final var drawSetup = structurePartDrawSetups.get(drawCall);
		final var structure = drawSetup.getStructure();
		final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
		final var resolver = findEntityResolver(drawSetup, structureAdapter);

		return resolver.resolveEntity(renderPointer);
	}

	private IEntityResolver findEntityResolver(	final IStructurePartDrawSetup drawSetup,
												IStructureAdapter structureAdapter)
			throws AssertionError
	{
		IEntityResolver resolver = null;
		if (structureAdapter instanceof IEntityResolver)
		{
			resolver = (IEntityResolver) structureAdapter;
		}
		else
		{
			final var dataProviders = drawSetup.getDataProviders();
			for (int i = 0; i < dataProviders.size(); i++)
			{
				final var dataProvider = dataProviders.get(i);
				final var dataProviderAdapter = dataProvider.adapt(IRenderDataProviderAdapter.class);
				if (dataProviderAdapter instanceof IEntityResolver)
				{
					resolver = (IEntityResolver) dataProviderAdapter;
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
		final int count = structurePartDrawSetups.size();
		System.out.println(String.format(	"Create %d pipelines for %s [%s].",
											count,
											name,
											className));
	}

	private void throwResolverNotFoundError() throws AssertionError
	{
		throw new AssertionError("The StructureAdapter or one DataProviderAdapter of "
				+ maintainer.eClass().getName()
				+ " must implements "
				+ IEntityResolver.class.getSimpleName());
	}
}