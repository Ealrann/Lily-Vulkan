package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.function.Consumer;

public interface ITextWidgetAdapter extends INotifier<ITextWidgetAdapter.Features>, IExtender
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<String>, Features> Text = Feature.newFeature();
	}

	String getText();
	Font getFont();
}
