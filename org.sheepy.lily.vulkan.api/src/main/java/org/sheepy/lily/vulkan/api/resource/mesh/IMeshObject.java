package org.sheepy.lily.vulkan.api.resource.mesh;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;

public interface IMeshObject extends IAllocable<IExecutionContext>
{
	long getIndexBufferAddress();
	long getIndexBufferOffset();
	int getIndicesCount();

	long getVertexBufferAddress();
	long getVertexBufferOffset();

	void update(IStagingBuffer stagingBuffer);
	boolean hasChanged();

	void setInstanceCount(int size);
	int getInstanceCount();
}
