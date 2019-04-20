package org.sheepy.lily.vulkan.api.nativehelper.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.BufferAllocator;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.BufferGPUFiller;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.api.resource.IIndexedBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVertex;

public class IndexedBuffer<T extends IVertex> implements IAllocable
{
	private final IIndexedBufferDescriptor<T> meshDescriptor;
	private final int vertexBufferCapacity;
	private final int indexBufferCapacity;

	protected IExecutionContext context;
	protected GPUBufferBackend vertexBuffer;
	protected GPUBufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;

	public static <T extends IVertex> IndexedBuffer<T> alloc(	IExecutionContext context,
																IndexedBufferData<T> datas)
	{
		return alloc(context, datas.meshDescriptor, datas.vertices, datas.indices);
	}

	public static <T extends IVertex> IndexedBuffer<T> alloc(	IExecutionContext context,
																IIndexedBufferDescriptor<T> indexedDescriptor,
																T[] vertices,
																int[] indices)
	{
		final int vertexBufferSize = vertices.length * indexedDescriptor.sizeOfVertex();
		final int indexBufferSize = indices.length * indexedDescriptor.sizeOfIndex();

		final IndexedBuffer<T> res = new IndexedBuffer<>(indexedDescriptor, vertexBufferSize,
				indexBufferSize);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack, context);
			res.fillBuffer(stack, vertices, indices);
		}

		return res;
	}

	public IndexedBuffer(	IIndexedBufferDescriptor<T> meshDescriptor,
							int vertexBufferCapacity,
							int indexBufferCapacity)
	{
		this.meshDescriptor = meshDescriptor;
		this.vertexBufferCapacity = vertexBufferCapacity;
		this.indexBufferCapacity = indexBufferCapacity;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		this.context = (IExecutionContext) context;

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

	public void fillBuffer(MemoryStack stack, T[] vertices, int[] indices)
	{
		final int verticeCount = vertices.length;
		final int indiceCount = indices.length;

		final var vertexBuffer = meshDescriptor.toVertexBuffer(vertices);
		final var indexBuffer = meshDescriptor.toIndexBuffer(indices);

		fillBuffer(stack, vertexBuffer, verticeCount, indexBuffer, indiceCount);

		MemoryUtil.memFree(indexBuffer);
		MemoryUtil.memFree(vertexBuffer);
	}

	private void fillBuffer(MemoryStack stack,
							ByteBuffer vertices,
							int numberOfVertice,
							ByteBuffer indices,
							int numberOfIndice)
	{
		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		final int indexByteSize = numberOfIndice * meshDescriptor.sizeOfIndex();
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
	public void free(IAllocationContext context)
	{
		vertexBuffer.free(context);
		indexBuffer.free(context);

		vertexBuffer = null;
		indexBuffer = null;

		allocated = false;
	}

	public IIndexedBufferDescriptor<T> getIndexBufferDescriptor()
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
	public boolean isAllocationDirty(IAllocationContext context)
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
