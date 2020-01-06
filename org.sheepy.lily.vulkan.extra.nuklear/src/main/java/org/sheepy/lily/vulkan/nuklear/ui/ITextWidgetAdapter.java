package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.model.ui.Font;

public interface ITextWidgetAdapter extends INotifierAdapter
{
	enum Features {
		Text
	}

	String getText();
	Font getFont();
}
