package org.sheepy.lily.vulkan.demo.mesh;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.resource.indexed.IVertex;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;
import org.sheepy.vulkan.resource.indexed.IndexedBufferData;
import org.sheepy.vulkan.resource.indexed.IndexedBufferWithUniform;

public abstract class AbstractMeshBuilder<T extends IVertex> implements IIndexedBufferBuilder<T>
{
	private final IndexedBufferData<T> data;
	private final IndexedBuffer<T> indexBuffer;

	public AbstractMeshBuilder()
	{
		data = buildData();

		final var descriptor = data.meshDescriptor;
		final int vertexBufferCapacity = data.vertices.length * descriptor.sizeOfVertex();
		final int indexBufferCapacity = data.indices.length * descriptor.sizeOfIndex();
		final int uniformCapacity = data.uniformData != null ? data.uniformData.length : 0;

		if (uniformCapacity > 0)
		{
			indexBuffer = new IndexedBufferWithUniform<>(descriptor, vertexBufferCapacity,
					indexBufferCapacity, uniformCapacity);
		}
		else
		{
			indexBuffer = new IndexedBuffer<>(descriptor, vertexBufferCapacity,
					indexBufferCapacity);
		}
	}

	@Override
	public IndexedBuffer<T> getIndexedBuffer()
	{
		return indexBuffer;
	}

	@Override
	public void fillBuffer()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			if (indexBuffer instanceof IndexedBufferWithUniform)
			{
				((IndexedBufferWithUniform<T>) indexBuffer).fillBuffer(stack, data.vertices,
						data.indices, data.uniformData);
			}
			else
			{
				indexBuffer.fillBuffer(stack, data.vertices, data.indices);
			}
		}
	}

	protected abstract IndexedBufferData<T> buildData();
}
