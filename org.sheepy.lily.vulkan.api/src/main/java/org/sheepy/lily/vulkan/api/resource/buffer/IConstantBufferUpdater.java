package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;

public interface IConstantBufferUpdater extends IVulkanAdapter
{
	void beforePush(ConstantBuffer buffer);
}
