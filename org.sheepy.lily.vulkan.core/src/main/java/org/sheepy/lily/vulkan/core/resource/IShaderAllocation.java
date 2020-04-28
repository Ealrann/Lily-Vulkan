package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAllocation extends IAllocation
{
	VkShaderStage getVkShaderStage();
}
