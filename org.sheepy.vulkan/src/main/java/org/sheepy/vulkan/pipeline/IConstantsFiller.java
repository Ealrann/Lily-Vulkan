package org.sheepy.vulkan.pipeline;

import org.lwjgl.vulkan.VkPushConstantRange;

public interface IConstantsFiller
{
	void fillRange(VkPushConstantRange range);
}
