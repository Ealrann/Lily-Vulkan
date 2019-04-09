package org.sheepy.lily.vulkan.api.resource;

public interface IIndexedBuffer
{

	long getVertexBufferAddress();
	long getIndexBufferAddress();

	int getIndicesCount();


}
