package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

public interface IUIElementAdapter extends IExtender
{
	boolean layout(UIContext context, IUIElement control);
	boolean needLayout();
}
