package org.sheepy.lily.vulkan.api.resource;

import java.util.List;

import org.sheepy.vulkan.resource.image.VkTexture;

public interface ITextureArrayAdapter extends IVulkanResourceAdapter
{
	List<VkTexture> getTextures();

	long[] getViewPtrs();
}
