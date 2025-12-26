package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMappedMemoryRange;

import static org.lwjgl.vulkan.VK10.*;

public final class BufferUtils
{
	private BufferUtils()
	{
	}

	public static int flush(MemoryStack stack, VkDevice vkDevice, long bufferMemoryId)
	{
		return BufferUtils.flush(stack, vkDevice, bufferMemoryId, VK_WHOLE_SIZE, 0);
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @param size   (Optional) Size of the memory range to flush. Pass VK_WHOLE_SIZE to flush the
	 *               complete buffer range.
	 * @param offset (Optional) Byte offset from beginning
	 * @return VkResult of the flush call
	 * @apiNote Only required for non-coherent memory
	 */
	public static int flush(MemoryStack stack, VkDevice vkDevice, long bufferMemoryId, long size, long offset)
	{
		final var mappedRange = VkMappedMemoryRange.calloc(1, stack);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkFlushMappedMemoryRanges(vkDevice, mappedRange);
	}

	public static int invalidate(MemoryStack stack, VkDevice vkDevice, long bufferMemoryId)
	{
		return BufferUtils.invalidate(stack, vkDevice, bufferMemoryId, VK_WHOLE_SIZE, 0);
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @param size   (Optional) Size of the memory range to invalidate. Pass VK_WHOLE_SIZE to
	 *               invalidate the complete buffer range.
	 * @param offset (Optional) Byte offset from beginning
	 * @return VkResult of the invalidate call
	 * @apiNote Only required for non-coherent memory
	 */
	public static int invalidate(MemoryStack stack, VkDevice vkDevice, long bufferMemoryId, long size, long offset)
	{
		final var mappedRange = VkMappedMemoryRange.calloc(1, stack);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkInvalidateMappedMemoryRanges(vkDevice, mappedRange);
	}

	public static void copyBuffer(MemoryStack stack,
								  VkCommandBuffer vkCommandBuffer,
								  long srcBuffer,
								  long srcOffset,
								  long dstBuffer,
								  long dstOffset,
								  long size)
	{
		final var copyRegion = VkBufferCopy.malloc(1, stack);
		copyRegion.srcOffset(srcOffset);
		copyRegion.dstOffset(dstOffset);
		copyRegion.size(size);
		vkCmdCopyBuffer(vkCommandBuffer, srcBuffer, dstBuffer, copyRegion);
	}
}
