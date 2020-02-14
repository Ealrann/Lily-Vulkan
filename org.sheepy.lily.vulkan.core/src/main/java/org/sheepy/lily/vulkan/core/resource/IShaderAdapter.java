package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAdapter extends IAllocableAdapter<InternalExecutionContext>
{
	VkShaderStage getVkShaderStage();
}
