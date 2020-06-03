package org.sheepy.lily.vulkan.nuklear.ui;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.resource.IImage;

import java.util.Collection;

public interface IImageWidgetAdapter extends IExtender
{
	Collection<? extends IImage> getImages();
}
