package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;

import java.nio.ByteBuffer;

public interface IBufferObjectAllocation extends IBufferAllocation
{
	boolean needPush();
	void fillData(ByteBuffer buffer);

	static IBufferObjectAllocation adapt(IBufferObject bufferObject)
	{
		return bufferObject.adapt(IBufferObjectAllocation.class);
	}
}
