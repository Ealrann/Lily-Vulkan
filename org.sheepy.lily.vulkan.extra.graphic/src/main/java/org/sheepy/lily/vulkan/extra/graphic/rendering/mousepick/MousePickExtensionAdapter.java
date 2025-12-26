package org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.util.ModelCopier;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IEntityResolverAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IEntitySelectionBuilder;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

@ModelExtender(scope = MousePickExtension.class)
@Adapter
@AutoLoad
public final class MousePickExtensionAdapter implements IAdapter
{
	private final StaticBuffer buffer;
	private final MousePickExtension pickExtension;
	private final ModelCopier copier = new ModelCopier();

	private PresentableEntity pickedEntity = null;

	private MousePickExtensionAdapter(final MousePickExtension pickExtension)
	{
		this.pickExtension = pickExtension;
		this.buffer = pickExtension.mousePickBuffer();
	}

	@Tick
	private void updatePick()
	{
		if (pickExtension.selectionProxy()
						 .pickMode() == EMousePickMode.Disabled) return;

		final var fetchAdapter = buffer.adapt(MousePickDataConsumer.class);
		final int pipeline = fetchAdapter.getPipeline();
		final var renderPointer = fetchAdapter.getRenderPointer();

		if (renderPointer != null && pipeline > 0)
		{
			retrievePick(pipeline, renderPointer);
		}
		else
		{
			pickedEntity = null;
			setSelection(null, null);
		}
	}

	private void retrievePick(final int pipeline, final RenderPointer renderPointer)
	{
		final var offset = pickExtension.resolverPipelineOffset();
		final var index = pipeline - offset;
		final var resolverPipeline = pickExtension.entityResolverPipelines()
												  .get(index);
		final var resolverIndex = resolverPipeline.takeFirst() ? 0 : renderPointer.drawcall;
		final var resolver = resolverPipeline.entityResolvers()
											 .get(resolverIndex);
		final var resolverAdapter = resolver.adapt(IEntityResolverAdapter.class);
		final var newPickedEntity = resolverAdapter.resolveEntity(renderPointer);

		if (newPickedEntity != pickedEntity)
		{
			final var newSelection = buildSelection(renderPointer, newPickedEntity);
			setSelection(newPickedEntity, newSelection);
		}
	}

	private static IEntitySelection buildSelection(final RenderPointer renderPointer,
												   final PresentableEntity newPickedEntity)
	{
		if (newPickedEntity != null)
		{
			final var selectionBuilder = newPickedEntity.adapt(IEntitySelectionBuilder.class);
			return selectionBuilder.buildSelection(renderPointer, newPickedEntity);
		}
		else
		{
			return null;
		}
	}

	private void setSelection(final PresentableEntity newPickedEntity, final IEntitySelection newSelection)
	{
		pickedEntity = newPickedEntity;
		pickExtension.selectionProxy()
					 .focus(newSelection);
		if (pickExtension.selectionProxy()
						 .pickMode() != EMousePickMode.Lock)
		{
			final var selection = newSelection != null ? copier.copyTree(newSelection) : null;
			pickExtension.selectionProxy()
						 .selection(selection);
		}
	}
}
