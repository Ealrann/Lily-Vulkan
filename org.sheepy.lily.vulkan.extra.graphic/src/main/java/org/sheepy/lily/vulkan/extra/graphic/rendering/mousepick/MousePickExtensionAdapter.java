package org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IEntitySelectionBuilder;
import org.sheepy.lily.vulkan.extra.api.rendering.IGenericRendererAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IMousePickDataConsumer;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

@ModelExtender(scope = MousePickExtension.class)
@Adapter
@AutoLoad
public final class MousePickExtensionAdapter implements IAdapter
{
	private final StaticBuffer buffer;
	private final Subpass subpass;
	private final MousePickExtension pickExtension;

	private PresentableEntity pickedEntity = null;

	private MousePickExtensionAdapter(final MousePickExtension pickExtension)
	{
		this.pickExtension = pickExtension;
		this.buffer = pickExtension.getMousePickBuffer();
		subpass = ModelUtil.findParent(pickExtension, Subpass.class);
	}

	@Tick
	private void updatePick()
	{
		if (pickExtension.getPickMode() == EMousePickMode.DISABLED) return;

		final var fetchAdapter = buffer.adapt(IMousePickDataConsumer.class);
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
		final var pipelines = subpass.getPipelinePkg()
									 .getPipelines();
		final var renderer = pipelines.get(pipeline);
		final var rendererAdapter = renderer.adaptNotNull(IGenericRendererAdapter.class);
		final var newPickedEntity = rendererAdapter.resolvePresentedEntity(renderPointer);

		final int newAddress;

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
		pickExtension.setFocus(newSelection);
		if (pickExtension.getPickMode() != EMousePickMode.LOCK)
		{
			pickExtension.setSelection(EcoreUtil.copy(newSelection));
		}
	}
}
