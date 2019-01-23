package org.sheepy.lily.vulkan.resource.indexed;

import java.nio.ByteBuffer;

public interface IIndexBufferDescriptor<T extends IVertex> extends IVertexBufferDescriptor<T>
{
	int sizeOfIndex();
	ByteBuffer toIndexBuffer(int[] indices);
}
