package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.resource.IImage;

import java.util.Collection;

public interface IImageWidgetAdapter extends IAdapter
{
	Collection<? extends IImage> getImages();
}
