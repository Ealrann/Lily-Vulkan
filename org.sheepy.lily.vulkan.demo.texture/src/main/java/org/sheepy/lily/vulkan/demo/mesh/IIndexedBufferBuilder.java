package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBuffer;
import org.sheepy.lily.vulkan.api.resource.IVertex;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexedBuffer<T> getIndexedBuffer();
	
	void fillBuffer();
	
}
