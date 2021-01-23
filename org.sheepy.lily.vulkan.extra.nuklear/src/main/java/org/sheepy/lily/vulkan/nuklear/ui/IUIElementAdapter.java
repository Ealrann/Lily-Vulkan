package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

public interface IUIElementAdapter extends IAdapter
{
	boolean layout(UIContext context, IUIElement control);
	boolean needLayout();
}
