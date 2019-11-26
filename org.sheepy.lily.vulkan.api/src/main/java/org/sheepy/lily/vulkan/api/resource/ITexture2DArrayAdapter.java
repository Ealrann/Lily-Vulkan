package org.sheepy.lily.vulkan.api.resource;

import java.util.List;

import org.sheepy.vulkan.resource.image.VkTexture;

public interface ITexture2DArrayAdapter extends IResourceAdapter
{
	List<VkTexture> getTextures();

	long[] getViewPtrs();
}
