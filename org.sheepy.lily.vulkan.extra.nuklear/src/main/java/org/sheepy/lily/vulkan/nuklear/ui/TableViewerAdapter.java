package org.sheepy.lily.vulkan.nuklear.ui;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.ui.UiFactory;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.extra.api.nuklear.ITableInputProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.TableViewer;
import org.sheepy.lily.vulkan.model.resource.PathResource;

@Statefull
@Adapter(scope = TableViewer.class)
public final class TableViewerAdapter extends PanelAdapter implements IPanelAdapter
{
	private final INotificationListener selectionListener = this::updateValue;
	private final TableViewer viewer;
	private final DirectVariableResolver resolver;

	private IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private boolean dirty = false;
	private LilyEObject selectedElement;

	public TableViewerAdapter(TableViewer viewer)
	{
		super(viewer);
		this.viewer = viewer;
		resolver = viewer.getVariableResolver();
	}

	@Load
	public void load()
	{
		resolverAdapter = resolver.adaptNotNullGeneric(IVariableResolverAdapter.class);
		resolverAdapter.addListener(selectionListener);
		selectedElement = (LilyEObject) resolverAdapter.getValue(resolver);
		update();
	}

	private void updateValue(Notification notification)
	{
		this.selectedElement = (LilyEObject) notification.getNewValue();
		update();
	}

	private void update()
	{
		final var controls = viewer.getControls();
		controls.clear();
		dirty = true;
		if (selectedElement == null) return;

		final var adapter = selectedElement.adapt(ITableInputProviderAdapter.class);
		if (adapter == null) return;

		final var elementProviders = adapter.buildElementProviders(selectedElement);

		final var layout = UiFactory.eINSTANCE.createDynamicRowLayout();
		layout.setColumnCount(2);
		layout.setHeight(16);
		controls.add(layout);

		for (final var provider : elementProviders)
		{
			final var name = provider.name;
			final var labelName = UiFactory.eINSTANCE.createLabel();
			labelName.setText(name);

			final var labelValue = UiFactory.eINSTANCE.createVariableLabel();
			labelValue.setText(name + "_varLabel");
			labelValue.setShowName(false);
			labelValue.setHorizontalRelative(EHorizontalRelative.RIGHT);
			labelValue.setVariableResolver(provider.resolver);

			controls.add(labelName);
			controls.add(labelValue);
		}
	}

	@Override
	@Dispose
	public void unsetTarget()
	{
		resolverAdapter.removeListener(selectionListener);
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

	@Override
	public void collectImages(List<PathResource> images)
	{}
}
