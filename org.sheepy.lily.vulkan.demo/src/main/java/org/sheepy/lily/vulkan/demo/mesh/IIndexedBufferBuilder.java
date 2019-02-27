package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.indexed.IVertex;
import org.sheepy.lily.vulkan.resource.indexed.IndexBuffer;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexBuffer<T> build(ExecutionContext executionManager);
}
