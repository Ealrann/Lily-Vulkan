package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;

public interface IBufferObjectAllocation extends IBufferAllocation
{
	boolean needPush();
	void fillData(long dstPtr);

	static IBufferObjectAllocation adapt(IBufferObject bufferObject)
	{
		return bufferObject.adapt(IBufferObjectAllocation.class);
	}
}
