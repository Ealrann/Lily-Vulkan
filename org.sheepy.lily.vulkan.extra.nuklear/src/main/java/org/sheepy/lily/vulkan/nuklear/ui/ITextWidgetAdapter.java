package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.function.Consumer;

public interface ITextWidgetAdapter extends INotifier<ITextWidgetAdapter.Features>, IAdapter
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<String>, Features> Text = Feature.newFeature();
	}

	String getText();
	Font getFont();
}
