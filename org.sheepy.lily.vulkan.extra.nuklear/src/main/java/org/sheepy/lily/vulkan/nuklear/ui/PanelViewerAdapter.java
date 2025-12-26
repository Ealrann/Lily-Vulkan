package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.adapter.Load;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.extra.api.nuklear.IControlProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;

import java.util.function.Consumer;

@ModelExtender(scope = PanelViewer.class)
@Adapter
public final class PanelViewerAdapter extends PanelAdapter implements IPanelAdapter
{
	private final Consumer<Object> selectionListener = this::updateValue;
	private final PanelViewer viewer;
	private final DirectVariableResolver resolver;

	private IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private boolean dirty = false;
	private LMObject selectedElement;

	public PanelViewerAdapter(PanelViewer viewer)
	{
		super(viewer);
		this.viewer = viewer;
		resolver = viewer.variableResolver();
	}

	@Load
	public void load()
	{
		resolverAdapter = resolver.adaptNotNullGeneric(IVariableResolverAdapter.class);
		resolverAdapter.listen(selectionListener);
		selectedElement = (LMObject) resolverAdapter.getValue(resolver);
		update();
	}

	private void updateValue(Object value)
	{
		this.selectedElement = (LMObject) value;
		update();
	}

	private void update()
	{
		final var controls = viewer.controls();
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

		if (viewer.controls().isEmpty() == false)
		{
			res |= super.layout(context);
		}

		return res;
	}
}
