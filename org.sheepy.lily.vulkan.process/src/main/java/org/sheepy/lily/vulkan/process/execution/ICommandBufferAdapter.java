package org.sheepy.lily.vulkan.process.execution;

import org.logoce.extender.api.IAdapter;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;

public interface ICommandBufferAdapter extends IAdapter
{
	VkCommandBuffer getVkCommandBuffer();
	void prepare(final FenceManager fenceManager);
}
