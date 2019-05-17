package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;

public class IndexedBuffer implements IAllocable<IExecutionContext>
{
	private final VkIndexedVertexDescriptor meshDescriptor;
	private final int vertexBufferCapacity;
	private final int indexBufferCapacity;

	protected IExecutionContext context;
	protected GPUBufferBackend vertexBuffer;
	protected GPUBufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;

	public IndexedBuffer(	VkIndexedVertexDescriptor meshDescriptor,
							int vertexBufferCapacity,
							int indexBufferCapacity)
	{
		this.meshDescriptor = meshDescriptor;
		this.vertexBufferCapacity = vertexBufferCapacity;
		this.indexBufferCapacity = indexBufferCapacity;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		this.context = context;

		allocateIndexBuffer(stack);
		allocateVertexBuffer(stack);

		allocated = true;
	}

	private void allocateVertexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT;

		vertexBuffer = BufferAllocator.allocateGPUBuffer(stack, context, vertexBufferCapacity,
				usage, false, false);
	}

	private void allocateIndexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT;

		indexBuffer = BufferAllocator.allocateGPUBuffer(stack, context, indexBufferCapacity, usage,
				false, false);
	}

	public void fillBuffer(	MemoryStack stack,
							ByteBuffer vertices,
							int numberOfVertice,
							ByteBuffer indices,
							int numberOfIndice)
	{
		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		final int indexByteSize = numberOfIndice * meshDescriptor.indexSizeBytes;
		final int vertexByteSize = numberOfVertice * meshDescriptor.sizeOfVertex();

		final var vertexFiller = new BufferGPUFiller(stack, context, vertexBuffer.getAddress());
		final var indexFiller = new BufferGPUFiller(stack, context, indexBuffer.getAddress());

		vertexFiller.fill(vertices, 0, vertexByteSize);
		indexFiller.fill(indices, 0, indexByteSize);
	}

	public void fillBuffer(	CPUBufferBackend indexStaggingBuffer,
							int numberOfIndice,
							CPUBufferBackend vertexStaggingBuffer,
							int numberOfVertice)
	{
		this.indexCount = numberOfIndice;
		this.vertexCount = numberOfVertice;

		vertexBuffer.pushData(context, vertexStaggingBuffer);
		indexBuffer.pushData(context, indexStaggingBuffer);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vertexBuffer.free(context);
		indexBuffer.free(context);

		vertexBuffer = null;
		indexBuffer = null;

		allocated = false;
	}

	public VkIndexedVertexDescriptor getIndexBufferDescriptor()
	{
		return meshDescriptor;
	}

	public boolean isAllocated()
	{
		return allocated;
	}

	public int getVerticesCount()
	{
		return vertexCount;
	}

	public int getIndicesCount()
	{
		return indexCount;
	}

	public int getVertexBufferCapacity()
	{
		return vertexBufferCapacity;
	}

	public int getIndexBufferCapacity()
	{
		return indexBufferCapacity;
	}

	public long getVertexBufferAddress()
	{
		return vertexBuffer.getAddress();
	}

	public long getIndexBufferAddress()
	{
		return indexBuffer.getAddress();
	}

	public long getVertexBufferMemoryId()
	{
		return vertexBuffer.getMemoryAddress();
	}

	public long getIndexBufferMemoryId()
	{
		return indexBuffer.getMemoryAddress();
	}

	public int getVertexMemoryOffset()
	{
		return 0;
	}

	public int getIndexMemoryOffset()
	{
		return 0;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	public GPUBufferBackend getVertexBuffer()
	{
		return vertexBuffer;
	}

	public GPUBufferBackend getIndexBuffer()
	{
		return indexBuffer;
	}
}
