package org.sheepy.vulkan.resource.indexed;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexBufferData<T> getDatas();
}
