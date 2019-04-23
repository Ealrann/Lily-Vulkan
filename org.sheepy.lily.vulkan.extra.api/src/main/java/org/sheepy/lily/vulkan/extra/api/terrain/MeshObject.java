package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshUniformDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshVertexDataProvider;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.descriptor.VkDescriptorSet;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferDescriptor;
import org.sheepy.vulkan.resource.indexed.IVertex;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;
import org.sheepy.vulkan.resource.indexed.IndexedBufferWithUniform;

public class MeshObject implements IAllocable, IMeshObject
{
	private final IMeshVertexDataProvider vertexDataProvider;
	private final IMeshVertexDataProvider indexDataProvider;
	private final List<IMeshUniformDataProvider> uniformDataProviders;

	private final IndexedBufferWithUniform<? extends IVertex> buffer;
	private final VkDescriptorSet descriptorSet;

	private int instanceCount;

	public MeshObject(	IMeshVertexDataProvider vertexDataProvider,
						IMeshVertexDataProvider indexDataProvider,
						List<IMeshUniformDataProvider> uniformDataProviders,
						int instanceCount,
						IIndexedBufferDescriptor<? extends IVertex> descriptor)
	{
		this.instanceCount = instanceCount;
		this.vertexDataProvider = vertexDataProvider;
		this.indexDataProvider = indexDataProvider;
		this.uniformDataProviders = uniformDataProviders;

		final var vertexCapacity = vertexDataProvider.getCapacity();
		final var indexCapacity = indexDataProvider.getCapacity();

		int uniformCapacity = 0;
		for (final var uniformDataProvider : uniformDataProviders)
		{
			uniformCapacity += uniformDataProvider.getCapacity();
		}

		buffer = new IndexedBufferWithUniform<>(descriptor, vertexCapacity, indexCapacity,
				uniformCapacity);
		final var uniformBuffer = buffer.getUniformBuffer();

		int position = 0;
		final List<IVkDescriptor> descriptors = new ArrayList<>();
		for (final IMeshUniformDataProvider uniformDataProvider : uniformDataProviders)
		{
			descriptors.add(uniformDataProvider.createDescriptor(uniformBuffer, position));
			position += uniformDataProvider.getCapacity();
		}

		descriptorSet = new VkDescriptorSet(descriptors);
	}

	@Override
	public boolean update(IMeshStagingBuffer stagingBuffer)
	{
		boolean changed = false;
		if (hasChanged())
		{
			fillBuffer(stagingBuffer);

			changed = true;
		}

		return changed;
	}

	private boolean hasChanged()
	{
		boolean res = false;

		res |= vertexDataProvider.hasChanged();
		res |= indexDataProvider.hasChanged();
		for (final var uniformDataProvider : uniformDataProviders)
		{
			res |= uniformDataProvider.hasChanged();
		}

		return res;
	}

	private void fillBuffer(IMeshStagingBuffer stagingBuffer)
	{
		stagingBuffer.fillBufferWith(buffer, vertexDataProvider, indexDataProvider,
				uniformDataProviders);
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
		return descriptorSet;
	}

	@Override
	public IndexedBuffer<?> getIIndexedBuffer()
	{
		return buffer;
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
}
