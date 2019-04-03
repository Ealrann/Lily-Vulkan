package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

public interface IIndexedBufferDescriptor<T extends IVertex> extends IVertexBufferDescriptor<T>
{
	int sizeOfIndex();
	ByteBuffer toIndexBuffer(int[] indices);
}
