package org.sheepy.lily.vulkan.extra.api.mesh;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;

public interface IMeshObject extends IAllocable<IExecutionContext>
{
	long getIndexBufferAddress();
	long getIndexBufferOffset();
	int getIndicesCount();

	long getVertexBufferAddress();
	long getVertexBufferOffset();

	void update(ITransferBuffer stagingBuffer);
	boolean hasChanged();

	void setInstanceCount(int size);
	int getInstanceCount();

	List<DescriptedResource> getDescriptors();
	List<IResource> createResources();
	void createDrawTasks(CompositeTask compositeTask);
}
