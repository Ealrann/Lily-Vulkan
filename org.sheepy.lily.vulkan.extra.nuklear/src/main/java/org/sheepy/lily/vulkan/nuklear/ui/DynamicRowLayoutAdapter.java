package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.nk_layout_row_dynamic;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.ui.DynamicRowLayout;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Adapter(scope = DynamicRowLayout.class)
public class DynamicRowLayoutAdapter implements IUIElementAdapter
{
	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		DynamicRowLayout layout = (DynamicRowLayout) control;

		nk_layout_row_dynamic(context.nkContext, layout.getHeight(), layout.getColumnCount());

		return false;
	}
}
