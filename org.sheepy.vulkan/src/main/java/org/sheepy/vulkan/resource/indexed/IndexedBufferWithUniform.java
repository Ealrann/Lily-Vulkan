package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferGPUFiller;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.memory.MemoryChunkBuilder;

public class IndexedBufferWithUniform extends IndexedBuffer
{
	final int USAGE = VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT;
	private final int uniformBufferCapacity;

	private GPUBufferBackend uniformBuffer;

	boolean allocated = false;

	public IndexedBufferWithUniform(int vertexStride,
									int indexSize,
									int vertexBufferCapacity,
									int indexBufferCapacity,
									int uniformBufferCapacity)
	{
		super(vertexStride, indexSize, vertexBufferCapacity, indexBufferCapacity);
		this.uniformBufferCapacity = uniformBufferCapacity;

		final BufferInfo info = new BufferInfo(uniformBufferCapacity, USAGE, false);
		uniformBuffer = new GPUBufferBackend(info, false);
	}

	@Override
	protected void allocateBuffers(MemoryStack stack, MemoryChunkBuilder memoryBuilder)
	{
		uniformBuffer.allocate(stack, context, memoryBuilder);
	}

	public void fillBuffer(	MemoryStack stack,
							ByteBuffer vertices,
							int numberOfVertice,
							ByteBuffer indices,
							int numberOfIndice,
							ByteBuffer uniforms,
							int uniformDataCount)
	{
		super.fillBuffer(stack, vertices, numberOfVertice, indices, numberOfIndice);

		final int uniformDataByteSize = uniformDataCount;
		final var uniformFiller = new BufferGPUFiller(stack, context, uniformBuffer.getAddress());

		uniformFiller.fill(uniforms, 0, uniformDataByteSize);
	}

	public void fillBuffer(	CPUBufferBackend indexStaggingBuffer,
							int numberOfIndice,
							CPUBufferBackend vertexStaggingBuffer,
							int numberOfVertice,
							CPUBufferBackend uniformStaggingBuffer)
	{
		super.fillBuffer(indexStaggingBuffer, numberOfIndice, vertexStaggingBuffer,
				numberOfVertice);

		uniformBuffer.pushData(context, uniformStaggingBuffer);
	}

	@Override
	protected int getUsages()
	{
		return super.getUsages() | VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT;
	}

	@Override
	public void free(IExecutionContext context)
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
