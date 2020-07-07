package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;

public interface IMemoryPartAllocation extends IBufferAllocation
{
	boolean needPush();
	void fillData(long dstPtr);
}
