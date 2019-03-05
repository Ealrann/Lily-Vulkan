package org.sheepy.lily.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.lily.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.lily.vulkan.resource.buffer.GPUBufferBackend;

public class IndexBuffer<T extends IVertex> implements IAllocable
{
	private final IIndexBufferDescriptor<T> vertexDescriptor;
	private final int vertexBufferSizeInByte;
	private final int indexBufferSizeInByte;
	private final boolean isOftenChanged;

	private ExecutionContext context;
	private GPUBufferBackend vertexBuffer;
	private GPUBufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;

	public static <T extends IVertex> IndexBuffer<T> alloc(	ExecutionContext context,
															IndexBufferData<T> datas,
															boolean isOftenChanged)
	{
		return alloc(context, datas.indexDescriptor, datas.vertices, datas.indices, isOftenChanged);
	}

	public static <T extends IVertex> IndexBuffer<T> alloc(	ExecutionContext context,
															IIndexBufferDescriptor<T> vertexDescriptor,
															T[] vertices,
															int[] indices,
															boolean isOftenChanged)
	{
		int vertexBufferSize = vertices.length * vertexDescriptor.sizeOfVertex();
		int indexBufferSize = indices.length * vertexDescriptor.sizeOfIndex();

		final IndexBuffer<T> res = new IndexBuffer<>(vertexDescriptor, vertexBufferSize,
				indexBufferSize, isOftenChanged);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack, context);
			res.fillBuffer(stack, vertices, indices);
		}

		return res;
	}

	public IndexBuffer(	IIndexBufferDescriptor<T> vertexDescriptor,
						int vertexBufferSizeInByte,
						int indexBufferSizeInByte,
						boolean isOftenChanged)
	{
		this.vertexDescriptor = vertexDescriptor;
		this.vertexBufferSizeInByte = vertexBufferSizeInByte;
		this.indexBufferSizeInByte = indexBufferSizeInByte;
		this.isOftenChanged = isOftenChanged;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		this.context = (ExecutionContext) context;

		allocateIndexBuffer(stack);
		allocateVertexBuffer(stack);

		allocated = true;
	}

	private void allocateVertexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT;

		vertexBuffer = BufferAllocator.allocateGPUBuffer(stack, context.getLogicalDevice(),
				vertexBufferSizeInByte, usage, isOftenChanged, isOftenChanged);
	}

	private void allocateIndexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT;

		indexBuffer = BufferAllocator.allocateGPUBuffer(stack, context.getLogicalDevice(),
				indexBufferSizeInByte, usage, isOftenChanged, isOftenChanged);
	}

	public void fillBuffer(MemoryStack stack, T[] vertices, int[] indices)
	{
		final ByteBuffer vertexBuffer = vertexDescriptor.toVertexBuffer(vertices);
		final ByteBuffer indexBuffer = vertexDescriptor.toIndexBuffer(indices);
		fillBuffer(stack, vertexBuffer, vertices.length, indexBuffer, indices.length);
		MemoryUtil.memFree(indexBuffer);
		MemoryUtil.memFree(vertexBuffer);
	}

	private void fillBuffer(MemoryStack stack,
							ByteBuffer verticeBuffer,
							int numberOfVertice,
							ByteBuffer indiceBuffer,
							int numberOfIndice)
	{
		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		final int indexByteSize = numberOfIndice * vertexDescriptor.sizeOfIndex();
		final int vertexByteSize = numberOfVertice * vertexDescriptor.sizeOfVertex();

		final var vertexFiller = new BufferGPUFiller(stack, context, vertexBuffer.getId());
		final var indexFiller = new BufferGPUFiller(stack, context, indexBuffer.getId());

		vertexFiller.fill(verticeBuffer, vertexByteSize);
		indexFiller.fill(indiceBuffer, indexByteSize);
	}

	@Override
	public void free(IAllocationContext context)
	{
		vertexBuffer.free();
		indexBuffer.free();

		vertexBuffer = null;
		indexBuffer = null;

		allocated = false;
	}

	public void pushFromMemoryMap()
	{
		vertexBuffer.pushStagging(context);
		indexBuffer.pushStagging(context);
	}

	public long mapVertexMemory()
	{
		return vertexBuffer.mapMemory();
	}

	public long mapIndexMemory()
	{
		return indexBuffer.mapMemory();
	}

	public void unmapVertexMemory()
	{
		vertexBuffer.unmapMemory();
	}

	public void unmapIndexMemory()
	{
		indexBuffer.unmapMemory();
	}

	public IIndexBufferDescriptor<T> getIndexBufferDescriptor()
	{
		return vertexDescriptor;
	}

	public boolean isAllocated()
	{
		return allocated;
	}

	public int verticeCount()
	{
		return vertexCount;
	}

	public long getVertexBufferId()
	{
		return vertexBuffer.getId();
	}

	public long getIndexBufferId()
	{
		return indexBuffer.getId();
	}

	public long getVertexBufferMemoryId()
	{
		return vertexBuffer.getMemoryId();
	}

	public long getIndexBufferMemoryId()
	{
		return indexBuffer.getMemoryId();
	}

	public int indexCount()
	{
		return indexCount;
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
