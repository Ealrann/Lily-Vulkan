package org.sheepy.lily.vulkan.api.resource.buffer;

public interface ICompositeBufferAdapter extends IBufferAdapter
{
	long getSize(int componentIndex);
	long getOffset(int componentIndex, int instance);
}
