package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.model.ui.Font;

import java.util.function.Consumer;

public interface ITextWidgetAdapter extends INotifierAdapter<ITextWidgetAdapter.Features>
{
	enum Features implements IFeature<Consumer<String>, Features>
	{
		Text
	}

	String getText();
	Font getFont();
}
