package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshIndexDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshUniformDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshVertexDataProvider;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.resource.buffer.BufferComposite;
import org.sheepy.vulkan.resource.buffer.IBufferDataProvider;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;

public class MeshObject implements IAllocable, IMeshObject
{
	private final IMeshVertexDataProvider vertexDataProvider;
	private final IMeshIndexDataProvider indexDataProvider;

	private final BufferComposite buffer;

	private boolean hasChanged = true;
	private int instanceCount;

	public MeshObject(	IMeshVertexDataProvider vertexDataProvider,
						IMeshIndexDataProvider indexDataProvider,
						List<IMeshUniformDataProvider> uniformDataProviders,
						int instanceCount)
	{
		this.instanceCount = instanceCount;
		this.vertexDataProvider = vertexDataProvider;
		this.indexDataProvider = indexDataProvider;

		final List<IBufferDataProvider> dataProviders = new ArrayList<>();
		dataProviders.add(vertexDataProvider);
		dataProviders.add(indexDataProvider);
		dataProviders.addAll(uniformDataProviders);

		buffer = new BufferComposite(dataProviders);
	}

	@Override
	public void update(IStagingBuffer stagingBuffer)
	{
		buffer.update(stagingBuffer);
		hasChanged = buffer.hasChanged();
	}

	@Override
	public boolean hasChanged()
	{
		return hasChanged;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		buffer.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		buffer.free(context);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return buffer.isAllocationDirty(context);
	}

	@Override
	public IVkDescriptorSet getDescriptorSet()
	{
		return buffer.getDescriptorSet();
	}

	@Override
	public void setInstanceCount(int instanceCount)
	{
		this.instanceCount = instanceCount;
	}

	@Override
	public int getInstanceCount()
	{
		return instanceCount;
	}

	@Override
	public long getIndexBufferAddress()
	{
		return buffer.getBufferAddress();
	}

	@Override
	public long getIndexBufferOffset()
	{
		return buffer.getOffset(indexDataProvider);
	}

	@Override
	public int getIndicesCount()
	{
		return indexDataProvider.getDataCount();
	}

	@Override
	public long getVertexBufferAddress()
	{
		return buffer.getBufferAddress();
	}

	@Override
	public long getVertexBufferOffset()
	{
		return buffer.getOffset(vertexDataProvider);
	}
}
