package org.sheepy.lily.vulkan.core.resource;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAllocation extends IAdapter
{
	VkShaderStage getVkShaderStage();
}
