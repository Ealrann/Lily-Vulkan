package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.graphic.IIndexBufferDescriptor;

public class IndexBuffer<T extends IVertex> implements IAllocable
{
	private LogicalDevice logicalDevice;
	private IIndexBufferDescriptor<T> vertexDescriptor;
	private CommandPool commandPool;

	private Buffer vertexBuffer;
	private Buffer indexBuffer;

	private int vertexCount;
	private int indexCount;

	private Buffer indexStagingBuffer;
	private Buffer vertexStagingBuffer;

	public static <T extends IVertex> IndexBuffer<T> alloc(LogicalDevice logicalDevice,
			IIndexBufferDescriptor<T> vertexDescriptor,
			CommandPool commandPool,
			T[] vertices,
			int[] indices)
	{
		IndexBuffer<T> res = new IndexBuffer<>(logicalDevice, vertexDescriptor, commandPool,
				vertices.length, indices.length);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			res.allocate(stack);
		}
		res.fillBuffer(vertices, indices);

		return res;
	}

	public IndexBuffer(LogicalDevice logicalDevice, IIndexBufferDescriptor<T> vertexDescriptor,
			CommandPool commandPool, int vertexSize, int indiceSize)
	{
		this.logicalDevice = logicalDevice;
		this.vertexDescriptor = vertexDescriptor;
		this.commandPool = commandPool;

		long indexByteSize = indiceSize * vertexDescriptor.sizeOfIndex();
		indexBuffer = new Buffer(logicalDevice, indexByteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		long vertexByteSize = vertexSize * vertexDescriptor.sizeOfVertex();
		vertexBuffer = new Buffer(logicalDevice, vertexByteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		indexBuffer.allocate();
		vertexBuffer.allocate();
	}

	public void fillBuffer(T[] vertices, int[] indices)
	{
		ByteBuffer vertexBuffer = vertexDescriptor.toVertexBuffer(vertices);
		ByteBuffer indexBuffer = vertexDescriptor.toIndexBuffer(indices);
		fillBuffer(vertexBuffer, vertices.length, indexBuffer, indices.length);
		MemoryUtil.memFree(indexBuffer);
		MemoryUtil.memFree(vertexBuffer);
	}

	public void fillBuffer(ByteBuffer verticeBuffer,
			int numberOfVertice,
			ByteBuffer indiceBuffer,
			int numberOfIndice)
	{
		indexCount = numberOfIndice;
		vertexCount = numberOfVertice;

		SingleTimeCommand stc = new SingleTimeCommand(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue())
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				fillVertexBuffer(stack, commandBuffer, verticeBuffer);
				fillIndexBuffer(stack, commandBuffer, indiceBuffer);
			}

			@Override
			protected void postExecute()
			{
				indexStagingBuffer.free();
				vertexStagingBuffer.free();
			}
		};
		stc.execute();
	}

	private void fillIndexBuffer(MemoryStack stack,
			VkCommandBuffer commandBuffer,
			ByteBuffer verticeBuffer)
	{
		int byteSize = indexCount * vertexDescriptor.sizeOfIndex();

		indexStagingBuffer = new Buffer(logicalDevice, byteSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		indexStagingBuffer.allocate();

		indexStagingBuffer.fillWithBuffer(verticeBuffer);

		Buffer.copyBuffer(commandBuffer, indexStagingBuffer.getId(), indexBuffer.getId(), byteSize);
		
		indexStagingBuffer.flush();
	}

	private void fillVertexBuffer(MemoryStack stack,
			VkCommandBuffer commandBuffer,
			ByteBuffer verticeBuffer)
	{
		int byteSize = vertexCount * vertexDescriptor.sizeOfVertex();

		vertexStagingBuffer = new Buffer(logicalDevice, byteSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		vertexStagingBuffer.allocate();

		vertexStagingBuffer.fillWithBuffer(verticeBuffer);

		Buffer.copyBuffer(commandBuffer, vertexStagingBuffer.getId(), vertexBuffer.getId(),
				byteSize);

		vertexStagingBuffer.flush();
	}

	@Override
	public void free()
	{
		indexBuffer.free();
		vertexBuffer.free();
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

	public int indexCount()
	{
		return indexCount;
	}
}
