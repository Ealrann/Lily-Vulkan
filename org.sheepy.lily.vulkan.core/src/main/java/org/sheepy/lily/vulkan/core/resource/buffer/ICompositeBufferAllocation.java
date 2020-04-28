package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

import java.util.List;

public interface ICompositeBufferAllocation extends IAllocation
{
	void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts);
}
