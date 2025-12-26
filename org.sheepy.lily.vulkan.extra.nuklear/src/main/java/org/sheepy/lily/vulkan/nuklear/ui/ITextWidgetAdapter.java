package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.function.Consumer;

public interface ITextWidgetAdapter extends INotifier<ITextWidgetAdapter.Features>, IAdapter
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Consumer<String>, Features> Text = IFeature.newFeature();
	}

	String getText();
	Font getFont();
}
