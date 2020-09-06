package org.sheepy.lily.vulkan.core.resource.image;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

public record VkImageDescription(long imagePtr,
								 int width,
								 int height,
								 int format,
								 int usage,
								 int tiling,
								 int mipLevels,
								 EImageLayout initialLayout,
								 int aspect)
{
}
