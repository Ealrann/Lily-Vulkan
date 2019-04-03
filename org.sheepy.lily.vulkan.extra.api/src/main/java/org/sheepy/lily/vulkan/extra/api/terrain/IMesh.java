package org.sheepy.lily.vulkan.extra.api.terrain;

public interface IMesh
{

	long getVertexBufferAddress();

	long getIndexBufferAddress();

	int getIndicesCount();

	int getVerticesCount();
}
