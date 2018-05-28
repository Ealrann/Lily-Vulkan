package org.sheepy.lily.game.vulkan.vertex;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

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

	public void allocIndexBuffer(VkQueue queue,
			Vertex[] vertices,
			short[] indices)
	{
		allocIndexBuffer(queue, indices);
		allocVertexBuffer(queue, vertices);
	}

	private void allocIndexBuffer(VkQueue queue, short[] indices)
	{
		ByteBuffer verticeBuffer = allocBuffer(indices);
		indexCount = indices.length;

		int byteSize = indexCount * Short.BYTES;

		Buffer stagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		long bufferMemoryId = stagingBuffer.getBufferMemoryId();

		PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(logicalDevice.getVkDevice(), bufferMemoryId, 0, byteSize, 0, pBuffer);
		long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(verticeBuffer), data, verticeBuffer.capacity());
		vkUnmapMemory(logicalDevice.getVkDevice(), bufferMemoryId);

		indexBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		copyBuffer(queue, stagingBuffer.getBufferId(),
				indexBuffer.getBufferId(), byteSize);

		stagingBuffer.free();
		MemoryUtil.memFree(verticeBuffer);
		MemoryUtil.memFree(pBuffer);
	}

	private void allocVertexBuffer(VkQueue queue, Vertex[] vertices)
	{
		ByteBuffer verticeBuffer = allocBuffer(vertices);
		vertexCount = vertices.length;

		int byteSize = vertexCount * Vertex.SIZE_OF;

		Buffer stagingBuffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		stagingBuffer.fillWithBuffer(verticeBuffer, byteSize);

		buffer = Buffer.alloc(logicalDevice, byteSize,
				VK_BUFFER_USAGE_TRANSFER_DST_BIT | VK_BUFFER_USAGE_VERTEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		copyBuffer(queue, stagingBuffer.getBufferId(), buffer.getBufferId(), byteSize);

		stagingBuffer.free();
		MemoryUtil.memFree(verticeBuffer);
	}

	private void copyBuffer(
			VkQueue queue,
			long srcBuffer,
			long dstBuffer,
			int size)
	{
		CommandPool commandPool = logicalDevice.getCommandPool();
		VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandPool(commandPool.getId());
		allocInfo.commandBufferCount(1);

		PointerBuffer pCommandBuffer = memAllocPointer(1);
		vkAllocateCommandBuffers(logicalDevice.getVkDevice(), allocInfo, pCommandBuffer);
		VkCommandBuffer vkCommandBuffer = new VkCommandBuffer(pCommandBuffer.get(0),
				logicalDevice.getVkDevice());
		memFree(pCommandBuffer);

		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);

		VkBufferCopy.Buffer copyRegion = VkBufferCopy.calloc(1);
		copyRegion.srcOffset(0); // Optional
		copyRegion.dstOffset(0); // Optional
		copyRegion.size(size);
		vkCmdCopyBuffer(vkCommandBuffer, srcBuffer, dstBuffer, copyRegion);

		vkEndCommandBuffer(vkCommandBuffer);

		// Now, we execute the command

		PointerBuffer pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(vkCommandBuffer);
		pCommandBuffers.flip();

		VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffers);

		vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE);
		vkQueueWaitIdle(queue);

		vkFreeCommandBuffers(logicalDevice.getVkDevice(), commandPool.getId(), pCommandBuffers);

		memFree(pCommandBuffers);
		allocInfo.free();
		beginInfo.free();
	}

	private ByteBuffer allocBuffer(short[] indices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(indices.length * Short.BYTES);
		ShortBuffer sb = res.asShortBuffer();

		for (short index : indices)
		{
			sb.put(index);
		}

		return res;
	}

	private ByteBuffer allocBuffer(Vertex[] vertices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(Vertex.SIZE_OF * vertices.length);
		FloatBuffer fb = res.asFloatBuffer();

		for (Vertex vertex : vertices)
		{
			fb.put(vertex.position.x);
			fb.put(vertex.position.y);
			fb.put(vertex.color.x);
			fb.put(vertex.color.y);
			fb.put(vertex.color.z);
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
		return buffer.getBufferId();
	}

	public long getIndexBufferId()
	{
		return indexBuffer.getBufferId();
	}

	public int indexCount()
	{
		return indexCount;
	}
}
