package org.sheepy.lily.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.resource.IIndexedBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVertex;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.lily.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.lily.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.GPUBufferBackend;

public class IndexedBuffer<T extends IVertex> implements IAllocable
{
	private final IIndexedBufferDescriptor<T> meshDescriptor;
	private final int vertexBufferSizeInByte;
	private final int indexBufferSizeInByte;
	private final boolean isOftenChanged;

	private ExecutionContext context;
	private GPUBufferBackend vertexBuffer;
	private GPUBufferBackend indexBuffer;

	private int vertexCount;
	private int indexCount;

	boolean allocated = false;

	public static <T extends IVertex> IndexedBuffer<T> alloc(	IExecutionContext context,
																IndexedBufferData<T> datas,
																boolean isOftenChanged)
	{
		return alloc(context, datas.meshDescriptor, datas.vertices, datas.indices, isOftenChanged);
	}

	public static <T extends IVertex> IndexedBuffer<T> alloc(	IExecutionContext context,
																IIndexedBufferDescriptor<T> indexedDescriptor,
																T[] vertices,
																int[] indices,
																boolean isOftenChanged)
	{
		final int vertexBufferSize = vertices.length * indexedDescriptor.sizeOfVertex();
		final int indexBufferSize = indices.length * indexedDescriptor.sizeOfIndex();

		final IndexedBuffer<T> res = new IndexedBuffer<>(indexedDescriptor, vertexBufferSize,
				indexBufferSize, isOftenChanged);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack, context);
			res.fillBuffer(stack, vertices, indices);
		}

		return res;
	}

	public IndexedBuffer(	IIndexedBufferDescriptor<T> meshDescriptor,
							int vertexBufferSizeInByte,
							int indexBufferSizeInByte,
							boolean isOftenChanged)
	{
		this.meshDescriptor = meshDescriptor;
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

		vertexBuffer = BufferAllocator.allocateGPUBuffer(stack, context, vertexBufferSizeInByte,
				usage, isOftenChanged, isOftenChanged);
	}

	private void allocateIndexBuffer(MemoryStack stack)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT;

		indexBuffer = BufferAllocator.allocateGPUBuffer(stack, context, indexBufferSizeInByte,
				usage, isOftenChanged, isOftenChanged);
	}

	public void fillBuffer(MemoryStack stack, T[] vertices, int[] indices)
	{
		final ByteBuffer vertexBuffer = meshDescriptor.toVertexBuffer(vertices);
		final ByteBuffer indexBuffer = meshDescriptor.toIndexBuffer(indices);
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

		final int indexByteSize = numberOfIndice * meshDescriptor.sizeOfIndex();
		final int vertexByteSize = numberOfVertice * meshDescriptor.sizeOfVertex();

		final var vertexFiller = new BufferGPUFiller(stack, context, vertexBuffer.getAddress());
		final var indexFiller = new BufferGPUFiller(stack, context, indexBuffer.getAddress());

		vertexFiller.fill(verticeBuffer, vertexByteSize);
		indexFiller.fill(indiceBuffer, indexByteSize);
	}

	public void fillBuffer(	IAllocationContext context,
							CPUBufferBackend indexStaggingBuffer,
							int numberOfIndice,
							CPUBufferBackend vertexStaggingBuffer,
							int numberOfVertice)
	{
		final var executionContext = (ExecutionContext) context;

		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		vertexBuffer.pushData(executionContext, vertexStaggingBuffer);
		indexBuffer.pushData(executionContext, indexStaggingBuffer);
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

	public void pushFromMemoryMap()
	{
		vertexBuffer.pushStagging(context);
		indexBuffer.pushStagging(context);
	}

	public long mapVertexMemory(VkDevice vkDevice)
	{
		return vertexBuffer.mapMemory(vkDevice);
	}

	public long mapIndexMemory(VkDevice vkDevice)
	{
		return indexBuffer.mapMemory(vkDevice);
	}

	public void unmapVertexMemory(VkDevice vkDevice)
	{
		vertexBuffer.unmapMemory(vkDevice);
	}

	public void unmapIndexMemory(VkDevice vkDevice)
	{
		indexBuffer.unmapMemory(vkDevice);
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

	public int getIndicesCount()
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
