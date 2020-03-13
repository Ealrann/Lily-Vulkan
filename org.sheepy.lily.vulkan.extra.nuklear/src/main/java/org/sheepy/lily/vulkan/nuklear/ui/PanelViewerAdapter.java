package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.extra.api.nuklear.IControlProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;

import java.util.function.Consumer;

@Statefull
@Adapter(scope = PanelViewer.class)
public final class PanelViewerAdapter extends PanelAdapter implements IPanelAdapter
{
	private final Consumer<Object> selectionListener = this::updateValue;
	private final PanelViewer viewer;
	private final DirectVariableResolver resolver;

	private IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private boolean dirty = false;
	private LilyEObject selectedElement;

	public PanelViewerAdapter(PanelViewer viewer)
	{
		super(viewer);
		this.viewer = viewer;
		resolver = viewer.getVariableResolver();
	}

	@Load
	public void load()
	{
		resolverAdapter = resolver.adaptNotNullGeneric(IVariableResolverAdapter.class);
		resolverAdapter.listen(selectionListener);
		selectedElement = (LilyEObject) resolverAdapter.getValue(resolver);
		update();
	}

	private void updateValue(Object value)
	{
		this.selectedElement = (LilyEObject) value;
		update();
	}

	private void update()
	{
		final var controls = viewer.getControls();
		controls.clear();
		dirty = true;
		if (selectedElement != null)
		{
			final var adapter = selectedElement.adapt(IControlProviderAdapter.class);
			if (adapter != null)
			{
				controls.addAll(adapter.buildControls(selectedElement));
			}
		}
	}

	@Override
	public void unsetTarget()
	{
		resolverAdapter.sulk(selectionListener);
		super.unsetTarget();
	}

	@Override
	public boolean layout(UIContext context)
	{
		boolean res = dirty;
		dirty = false;
		updateWindow(context);

		if (viewer.getControls().isEmpty() == false)
		{
			res |= super.layout(context);
		}

		return res;
	}
}
