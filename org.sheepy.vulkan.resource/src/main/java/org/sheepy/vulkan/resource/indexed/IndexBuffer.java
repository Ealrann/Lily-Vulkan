package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.buffer.BufferGPUFiller;

public class IndexBuffer<T extends IVertex> implements IBasicAllocable
{
	private final ExecutionManager context;
	private final IIndexBufferDescriptor<T> vertexDescriptor;
	private final int vertexBufferSizeInByte;
	private final int indexBufferSizeInByte;

	private BufferBackend vertexBuffer;
	private BufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;

	public static <T extends IVertex> IndexBuffer<T> alloc(	ExecutionManager context,
															IndexBufferData<T> datas)
	{
		return alloc(context, datas.indexDescriptor, datas.vertices, datas.indices);
	}

	public static <T extends IVertex> IndexBuffer<T> alloc(	ExecutionManager context,
															IIndexBufferDescriptor<T> vertexDescriptor,
															T[] vertices,
															int[] indices)
	{
		int vertexBufferSize = vertices.length * vertexDescriptor.sizeOfVertex();
		int indexBufferSize = indices.length * vertexDescriptor.sizeOfIndex();

		final IndexBuffer<T> res = new IndexBuffer<>(context, vertexDescriptor, vertexBufferSize,
				indexBufferSize);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack);
			res.fillBuffer(stack, vertices, indices);
		}

		return res;
	}

	public IndexBuffer(	ExecutionManager context,
						IIndexBufferDescriptor<T> vertexDescriptor,
						int vertexBufferSizeInByte,
						int indexBufferSizeInByte)
	{
		this.context = context;
		this.vertexDescriptor = vertexDescriptor;
		this.vertexBufferSizeInByte = vertexBufferSizeInByte;
		this.indexBufferSizeInByte = indexBufferSizeInByte;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocateIndexBuffer(stack);
		allocateVertexBuffer(stack);

		allocated = true;
	}

	private void allocateVertexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT;

		vertexBuffer = BufferAllocator.allocateGPUBuffer(stack, context.getLogicalDevice(),
				vertexBufferSizeInByte, usage);
	}

	private void allocateIndexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT;

		indexBuffer = BufferAllocator.allocateGPUBuffer(stack, context.getLogicalDevice(),
				indexBufferSizeInByte, usage);
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
	public void free()
	{
		indexBuffer.free();
		vertexBuffer.free();

		allocated = false;
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
	public boolean isAllocationDirty()
	{
		return false;
	}

	public BufferBackend getVertexBuffer()
	{
		return vertexBuffer;
	}

	public BufferBackend getIndexBuffer()
	{
		return indexBuffer;
	}
}
