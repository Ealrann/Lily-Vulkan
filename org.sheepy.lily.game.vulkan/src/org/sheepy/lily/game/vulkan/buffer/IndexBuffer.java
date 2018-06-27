package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.SingleTimeCommand;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.IVertexDescriptor;

public class IndexBuffer
{
	private LogicalDevice logicalDevice;

	private Buffer buffer;
	private Buffer indexBuffer;

	private int vertexCount;
	private int indexCount;

	private Buffer indexStagingBuffer;
	private Buffer vertexStagingBuffer;

	public IndexBuffer(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public <T extends IVertex> void allocIndexBuffer(CommandPool commandPool,
			VkQueue queue,
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices,
			int[] indices)
	{
		SingleTimeCommand stc = new SingleTimeCommand(commandPool, queue)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				allocIndexBuffer(stack, commandBuffer, indices);
				allocIVertexBuffer(stack, commandBuffer, vertexDescriptor, vertices);
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

	private void allocIndexBuffer(MemoryStack stack, VkCommandBuffer commandBuffer, int[] indices)
	{
		ByteBuffer verticeBuffer = allocBuffer(indices);
		indexCount = indices.length;

		int byteSize = indexCount * Integer.BYTES;

		indexStagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		indexStagingBuffer.fillWithBuffer(verticeBuffer, byteSize);

		indexBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		Buffer.copyBuffer(commandBuffer, indexStagingBuffer.getId(), indexBuffer.getId(), byteSize);
		
		MemoryUtil.memFree(verticeBuffer);
	}

	private <T extends IVertex> void allocIVertexBuffer(MemoryStack stack,
			VkCommandBuffer commandBuffer,
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices)
	{
		ByteBuffer verticeBuffer = vertexDescriptor.toBuffer(vertices);
		vertexCount = vertices.length;

		int byteSize = vertexCount * vertexDescriptor.sizeOfVertex();

		vertexStagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		vertexStagingBuffer.fillWithBuffer(verticeBuffer, byteSize);

		buffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		Buffer.copyBuffer(commandBuffer, vertexStagingBuffer.getId(), buffer.getId(), byteSize);
		
		MemoryUtil.memFree(verticeBuffer);
	}

	private ByteBuffer allocBuffer(int[] indices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(indices.length * Integer.BYTES);;
		IntBuffer sb = res.asIntBuffer();

		for (int index : indices)
		{
			sb.put(index);
		}

		return res;
	}

	public void free()
	{
		indexBuffer.free();
		buffer.free();
	}

	public int verticeCount()
	{
		return vertexCount;
	}

	public long getBufferId()
	{
		return buffer.getId();
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
