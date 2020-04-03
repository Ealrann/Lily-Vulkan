package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.Font;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public interface IImageWidgetAdapter extends IAdapter
{
	Collection<? extends IImage> getImages();
}
