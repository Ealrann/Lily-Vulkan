package org.sheepy.vulkan.demo.mesh;

import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.resource.indexed.IVertex;
import org.sheepy.vulkan.resource.indexed.IndexBuffer;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexBuffer<T> build(ExecutionManager executionManager);
}
