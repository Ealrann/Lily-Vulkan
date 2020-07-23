package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

import java.util.List;

public interface IBufferReferenceAllocation extends IExtender
{
	List<IBuffer> getBuffers(int index);
	List<IBufferAllocation> getBufferAllocations(int index);
	int getBufferCountPerInstance();
}
