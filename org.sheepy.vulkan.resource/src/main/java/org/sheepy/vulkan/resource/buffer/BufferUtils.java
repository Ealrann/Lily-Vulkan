package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkMappedMemoryRange;
import org.sheepy.vulkan.common.device.LogicalDevice;

public class BufferUtils
{

	public static int flush(LogicalDevice logicalDevice, int bufferMemoryId)
	{
		return BufferUtils.flush(logicalDevice, bufferMemoryId, VK_WHOLE_SIZE, 0);
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @note Only required for non-coherent memory
	 *
	 * @param size
	 *            (Optional) Size of the memory range to flush. Pass VK_WHOLE_SIZE to flush the
	 *            complete buffer range.
	 * @param offset
	 *            (Optional) Byte offset from beginning
	 *
	 * @return VkResult of the flush call
	 */
	public static int flush(LogicalDevice logicalDevice, int bufferMemoryId, long size, int offset)
	{
		VkMappedMemoryRange.Buffer mappedRange = VkMappedMemoryRange.create(1);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkFlushMappedMemoryRanges(logicalDevice.getVkDevice(), mappedRange);
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @note Only required for non-coherent memory
	 *
	 * @param size
	 *            (Optional) Size of the memory range to invalidate. Pass VK_WHOLE_SIZE to
	 *            invalidate the complete buffer range.
	 * @param offset
	 *            (Optional) Byte offset from beginning
	 *
	 * @return VkResult of the invalidate call
	 */
	public static int invalidate(	LogicalDevice logicalDevice,
									int bufferMemoryId,
									int size,
									int offset)
	{
		VkMappedMemoryRange.Buffer mappedRange = VkMappedMemoryRange.create(1);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkInvalidateMappedMemoryRanges(logicalDevice.getVkDevice(), mappedRange);
	}

	public static void copyBuffer(	VkCommandBuffer vkCommandBuffer,
									long srcBuffer,
									long dstBuffer,
									long size)
	{
		var copyRegion = VkBufferCopy.create(1);
		copyRegion.srcOffset(0); // Optional
		copyRegion.dstOffset(0); // Optional
		copyRegion.size(size);
		vkCmdCopyBuffer(vkCommandBuffer, srcBuffer, dstBuffer, copyRegion);
	}
}
