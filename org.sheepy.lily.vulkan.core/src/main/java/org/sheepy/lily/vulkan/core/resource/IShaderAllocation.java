package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAllocation extends IExtender
{
	VkShaderStage getVkShaderStage();
}
