package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.IVertexDescriptor;

public class IndexBuffer
{
	private LogicalDevice logicalDevice;

	private Buffer buffer;
	private Buffer indexBuffer;

	private int vertexCount;
	private int indexCount;

	public IndexBuffer(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public <T extends IVertex> void allocIndexBuffer(VkQueue queue,
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices,
			int[] indices)
	{
		allocIndexBuffer(queue, indices);
		allocIVertexBuffer(queue, vertexDescriptor, vertices);
	}

	private void allocIndexBuffer(VkQueue queue, int[] indices)
	{
		ByteBuffer verticeBuffer = allocBuffer(indices);
		indexCount = indices.length;

		int byteSize = indexCount * Integer.BYTES;

		Buffer stagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		stagingBuffer.fillWithBuffer(verticeBuffer, byteSize);

		indexBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		Buffer.copyBuffer(logicalDevice, queue, stagingBuffer.getId(),
				indexBuffer.getId(), byteSize);

		stagingBuffer.free();
		MemoryUtil.memFree(verticeBuffer);
	}

	private <T extends IVertex> void allocIVertexBuffer(VkQueue queue,
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices)
	{
		ByteBuffer verticeBuffer = vertexDescriptor.toBuffer(vertices);
		vertexCount = vertices.length;

		int byteSize = vertexCount * vertexDescriptor.sizeOfVertex();

		Buffer stagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		stagingBuffer.fillWithBuffer(verticeBuffer, byteSize);

		buffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		Buffer.copyBuffer(logicalDevice, queue, stagingBuffer.getId(), buffer.getId(),
				byteSize);

		stagingBuffer.free();
		MemoryUtil.memFree(verticeBuffer);
	}

	private ByteBuffer allocBuffer(int[] indices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(indices.length * Integer.BYTES);
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
