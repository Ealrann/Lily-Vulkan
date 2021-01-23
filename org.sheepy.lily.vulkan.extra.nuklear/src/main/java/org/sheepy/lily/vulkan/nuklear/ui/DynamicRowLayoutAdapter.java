package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.ui.DynamicRowLayout;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import static org.lwjgl.nuklear.Nuklear.nk_layout_row_dynamic;

@ModelExtender(scope = DynamicRowLayout.class)
@Adapter(singleton = true)
public final class DynamicRowLayoutAdapter implements IUIElementAdapter
{
	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final DynamicRowLayout layout = (DynamicRowLayout) control;

		nk_layout_row_dynamic(context.nkContext, layout.getHeight(), layout.getColumnCount());

		return false;
	}

	@Override
	public boolean needLayout()
	{
		return false;
	}
}
