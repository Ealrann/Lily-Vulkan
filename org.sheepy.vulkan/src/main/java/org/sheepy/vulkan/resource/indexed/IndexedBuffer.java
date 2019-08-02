package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.memory.MemoryChunk;
import org.sheepy.vulkan.resource.memory.MemoryChunkBuilder;

public class IndexedBuffer implements IAllocable<IExecutionContext>
{
	private final int vertexStride;
	private final int indexSize;
	private final int vertexBufferCapacity;
	private final int indexBufferCapacity;

	protected IExecutionContext context;
	protected GPUBufferBackend vertexBuffer;
	protected GPUBufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;
	private MemoryChunk memory;

	public IndexedBuffer(	int vertexStride,
							int indexSize,
							int vertexBufferCapacity,
							int indexBufferCapacity)
	{
		this.vertexStride = vertexStride;
		this.indexSize = indexSize;
		this.vertexBufferCapacity = vertexBufferCapacity;
		this.indexBufferCapacity = indexBufferCapacity;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		this.context = context;
		final int usage = getUsages();

		final var memoryBuilder = new MemoryChunkBuilder(stack, context, usage);

		allocateBuffers(stack, memoryBuilder);

		memory = memoryBuilder.build(stack);
		memory.allocate(stack, context);

		allocated = true;
	}

	protected int getUsages()
	{
		return VK_BUFFER_USAGE_TRANSFER_DST_BIT
				| VK_BUFFER_USAGE_VERTEX_BUFFER_BIT
				| VK_BUFFER_USAGE_INDEX_BUFFER_BIT;
	}

	protected void allocateBuffers(MemoryStack stack, final MemoryChunkBuilder memoryBuilder)
	{
		allocateIndexBuffer(stack, memoryBuilder);
		allocateVertexBuffer(stack, memoryBuilder);
	}

	private void allocateVertexBuffer(MemoryStack stack, MemoryChunkBuilder memoryBuilder)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT;
		vertexBuffer = createBuffer(stack, memoryBuilder, vertexBufferCapacity, usage);
	}

	private void allocateIndexBuffer(MemoryStack stack, MemoryChunkBuilder memoryBuilder)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT;
		indexBuffer = createBuffer(stack, memoryBuilder, indexBufferCapacity, usage);
	}

	private GPUBufferBackend createBuffer(	MemoryStack stack,
											MemoryChunkBuilder memoryBuilder,
											long size,
											int usage)
	{
		final var bufferInfo = new BufferInfo(size, usage, false);
		final var res = new GPUBufferBackend(bufferInfo, false);
		res.allocate(stack, context, memoryBuilder);
		return res;
	}

	public void fillBuffer(	MemoryStack stack,
							ByteBuffer vertices,
							int numberOfVertice,
							ByteBuffer indices,
							int numberOfIndice)
	{
		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		final int indexByteSize = numberOfIndice * indexSize;
		final int vertexByteSize = numberOfVertice * vertexStride;

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
		memory.free(context);

		vertexBuffer = null;
		indexBuffer = null;
		memory = null;

		allocated = false;
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
