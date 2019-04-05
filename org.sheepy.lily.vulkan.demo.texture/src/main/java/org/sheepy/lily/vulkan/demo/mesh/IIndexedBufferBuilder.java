package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.vulkan.api.resource.IVertex;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBuffer;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexedBuffer<T> getIndexedBuffer();
	
	void fillBuffer();
	
}
