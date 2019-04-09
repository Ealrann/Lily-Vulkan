package org.sheepy.lily.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.resource.IIndexedBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVertex;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.lily.vulkan.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.GPUBufferBackend;

public class IndexedBufferWithUniform<T extends IVertex> extends IndexedBuffer<T>
{
	final int USAGE = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT;
	private final int uniformBufferCapacity;

	private GPUBufferBackend uniformBuffer;

	boolean allocated = false;

	public static <T extends IVertex> IndexedBufferWithUniform<T> alloc(IExecutionContext context,
																		IndexedBufferData<T> datas)
	{
		return alloc(context, datas.meshDescriptor, datas.vertices, datas.indices,
				datas.uniformData);
	}

	public static <T extends IVertex> IndexedBufferWithUniform<T> alloc(IExecutionContext context,
																		IIndexedBufferDescriptor<T> indexedDescriptor,
																		T[] vertices,
																		int[] indices,
																		byte[] uniformData)
	{
		final int vertexBufferSize = vertices.length * indexedDescriptor.sizeOfVertex();
		final int indexBufferSize = indices.length * indexedDescriptor.sizeOfIndex();
		final int uniformBufferSize = uniformData != null ? uniformData.length : 0;

		final IndexedBufferWithUniform<T> res = new IndexedBufferWithUniform<>(indexedDescriptor,
				vertexBufferSize, indexBufferSize, uniformBufferSize);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack, context);
			res.fillBuffer(stack, vertices, indices, uniformData);
		}

		return res;
	}

	public IndexedBufferWithUniform(IIndexedBufferDescriptor<T> meshDescriptor,
									int vertexBufferCapacity,
									int indexBufferCapacity,
									int uniformBufferCapacity)
	{
		super(meshDescriptor, vertexBufferCapacity, indexBufferCapacity);
		this.uniformBufferCapacity = uniformBufferCapacity;

		final BufferInfo info = new BufferInfo(uniformBufferCapacity, USAGE, false);
		uniformBuffer = new GPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		allocateUniformBuffer(stack);
	}

	private void allocateUniformBuffer(MemoryStack stack)
	{
		uniformBuffer.allocate(stack, context);
	}

	public void fillBuffer(MemoryStack stack, T[] vertices, int[] indices, byte[] uniformData)
	{
		super.fillBuffer(stack, vertices, indices);

		final int uniformCount = uniformData != null ? uniformData.length : 0;
		final var uniformBuffer = uniformCount != 0 ? MemoryUtil.memAlloc(uniformCount) : null;

		fillBuffer(stack, uniformBuffer, uniformCount);

		MemoryUtil.memFree(uniformBuffer);
	}

	private void fillBuffer(MemoryStack stack, ByteBuffer uniforms, int uniformDataCount)
	{
		final int uniformDataByteSize = uniformDataCount;
		final var uniformFiller = new BufferGPUFiller(stack, context, uniformBuffer.getAddress());

		uniformFiller.fill(uniforms, uniformDataByteSize);
	}

	public void fillBuffer(	IAllocationContext context,
							CPUBufferBackend indexStaggingBuffer,
							int numberOfIndice,
							CPUBufferBackend vertexStaggingBuffer,
							int numberOfVertice,
							CPUBufferBackend uniformStaggingBuffer)
	{
		super.fillBuffer(context, indexStaggingBuffer, numberOfIndice, vertexStaggingBuffer,
				numberOfVertice);

		final var executionContext = (ExecutionContext) context;

		uniformBuffer.pushData(executionContext, uniformStaggingBuffer);
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);

		uniformBuffer.free(context);
		uniformBuffer = null;
	}

	public long getUniformBufferAddress()
	{
		return uniformBuffer.getAddress();
	}

	public long getUniformBufferMemoryId()
	{
		return uniformBuffer.getMemoryAddress();
	}

	public GPUBufferBackend getUniformBuffer()
	{
		return uniformBuffer;
	}

	public int getUniformBufferCapacity()
	{
		return uniformBufferCapacity;
	}

	public int getUniformBufferOffset()
	{
		return 0;
	}
}
