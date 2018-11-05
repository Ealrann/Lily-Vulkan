package org.sheepy.vulkan.resource.indexed;

import org.sheepy.vulkan.execution.ExecutionManager;

public interface IIndexedBufferBuilder<T extends IVertex>
{
	IndexBuffer<T> build(ExecutionManager executionManager);
}
