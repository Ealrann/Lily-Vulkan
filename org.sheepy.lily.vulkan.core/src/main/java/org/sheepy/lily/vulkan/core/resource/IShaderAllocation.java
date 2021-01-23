package org.sheepy.lily.vulkan.core.resource;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAllocation extends IAdapter
{
	VkShaderStage getVkShaderStage();
}
