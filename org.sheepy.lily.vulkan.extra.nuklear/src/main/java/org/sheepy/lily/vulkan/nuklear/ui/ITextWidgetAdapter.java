package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.model.ui.Font;

import java.util.function.Consumer;

public interface ITextWidgetAdapter extends INotifierAdapter<ITextWidgetAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<String>, Features> Text = Feature.newFeature();
	}

	String getText();
	Font getFont();
}
