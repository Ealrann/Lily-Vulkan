package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.vulkan.resource.indexed.IVertex;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexedBuffer<T> getIndexedBuffer();
	
	void fillBuffer();
	
}
