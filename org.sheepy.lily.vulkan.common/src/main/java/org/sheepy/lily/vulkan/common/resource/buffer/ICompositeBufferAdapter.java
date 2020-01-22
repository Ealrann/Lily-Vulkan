package org.sheepy.lily.vulkan.common.resource.buffer;

import java.util.List;

import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

public interface ICompositeBufferAdapter extends IVulkanResourceAdapter
{
	void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts);
}
