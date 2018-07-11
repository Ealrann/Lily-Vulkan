package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.graphic.IVertexDescriptor;

public class IndexBuffer<T extends IVertex> 
{
	private LogicalDevice logicalDevice;
	private IVertexDescriptor<T> vertexDescriptor;
	private T[] vertices;
	private int[] indices;
	
	private Buffer buffer;
	private Buffer indexBuffer;

	private int vertexCount;
	private int indexCount;

	private Buffer indexStagingBuffer;
	private Buffer vertexStagingBuffer;

	public IndexBuffer(LogicalDevice logicalDevice, 
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices,
			int[] indices)
	{
		this.logicalDevice = logicalDevice;
		
		this.vertexDescriptor = vertexDescriptor;
		this.vertices = vertices;
		this.indices = indices;
	}

	public void allocIndexBuffer(CommandPool commandPool)
	{
		SingleTimeCommand stc = new SingleTimeCommand(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue())
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

		indexStagingBuffer = new Buffer(logicalDevice, byteSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		indexStagingBuffer.allocate();
		
		indexStagingBuffer.fillWithBuffer(verticeBuffer);

		indexBuffer = new Buffer(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		indexBuffer.allocate();

		Buffer.copyBuffer(commandBuffer, indexStagingBuffer.getId(), indexBuffer.getId(), byteSize);

		MemoryUtil.memFree(verticeBuffer);
	}

	private void allocIVertexBuffer(MemoryStack stack,
			VkCommandBuffer commandBuffer,
			IVertexDescriptor<T> vertexDescriptor,
			T[] vertices)
	{
		ByteBuffer verticeBuffer = vertexDescriptor.toBuffer(vertices);
		vertexCount = vertices.length;

		int byteSize = vertexCount * vertexDescriptor.sizeOfVertex();

		vertexStagingBuffer = new Buffer(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		vertexStagingBuffer.allocate();
		
		vertexStagingBuffer.fillWithBuffer(verticeBuffer);

		buffer = new Buffer(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		buffer.allocate();
		
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
