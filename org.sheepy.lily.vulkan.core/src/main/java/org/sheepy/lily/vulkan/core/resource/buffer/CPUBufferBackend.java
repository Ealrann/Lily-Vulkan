package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.BufferPointer;
import org.sheepy.lily.vulkan.core.resource.memory.FunctionalMemoryBuilder;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

public final class CPUBufferBackend implements IBufferBackend
{
	private final long address;
	private final long size;
	private final boolean coherent;

	private long memoryAddress;
	private Memory memory;
	private long memoryMap = 0;

	private CPUBufferBackend(long address, long size, boolean coherent)
	{
		this.address = address;
		this.size = size;
		this.coherent = coherent;
	}

	@Deprecated
	@Override
	public void bindBufferMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		memoryAddress = memoryPtr;
		vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
		// System.out.println(Long.toHexString(bufferMemoryId));
	}

	@Deprecated
	private void linkMemory(final Memory memory)
	{
		this.memory = memory;
		this.memoryAddress = memory.ptr();
	}

	@Override
	public void free(IVulkanContext context)
	{
		final var vkDevice = context.getVkDevice();

		if (memoryMap != 0)
		{
			unmapMemory(vkDevice);
		}

		// System.out.println("free " + Long.toHexString(address));
		vkDestroyBuffer(vkDevice, address, null);
		if (memory != null) memory.free(context);

		memoryAddress = 0;
	}

	@Override
	public void pushData(IRecordContext context, ByteBuffer data)
	{
		pushDataInternal(context, () -> MemoryUtil.memCopy(memAddress(data), memoryMap, size));
	}

	@Override
	public void pushData(IRecordContext context, Consumer<ByteBuffer> dataProvider)
	{
		pushDataInternal(context, () -> dataProvider.accept(MemoryUtil.memByteBuffer(memoryMap, (int) size)));
	}

	private void pushDataInternal(IVulkanContext vulkanContext, Runnable doPush)
	{
		if (address == 0)
		{
			throw new AssertionError("Buffer not allocated");
		}

		final VkDevice vkDevice = vulkanContext.getVkDevice();
		final boolean wasMapped = memoryMap != 0;
		if (!wasMapped) mapMemory(vkDevice);
		doPush.run();
		if (!wasMapped) unmapMemory(vkDevice);
	}

	public long mapMemory(VkDevice vkDevice)
	{
		if (memoryMap == 0)
		{
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(vkDevice, memoryAddress, 0, size, 0, pBuffer);
			memoryMap = pBuffer.get(0);
			MemoryUtil.memFree(pBuffer);
		}

		return memoryMap;
	}

	public void unmapMemory(VkDevice vkDevice)
	{
		if (memoryMap != 0)
		{
			vkUnmapMemory(vkDevice, memoryAddress);
			memoryMap = 0;
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void flush(MemoryStack stack, VkDevice vkDevice)
	{
		if (coherent == false)
		{
			BufferUtils.flush(stack, vkDevice, memoryAddress);
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void invalidate(MemoryStack stack, VkDevice vkDevice)
	{
		if (coherent == false)
		{
			BufferUtils.invalidate(stack, vkDevice, memoryAddress);
		}
	}

	@Override
	public long getAddress()
	{
		return address;
	}

	public long getMemoryAddress()
	{
		return memoryAddress;
	}

	public long getMemoryMap()
	{
		return memoryMap;
	}

	public long getSize()
	{
		return size;
	}

	public static final class Builder
	{
		private final BufferInfo info;
		private final int properties;

		public Builder(BufferInfo info)
		{
			this.info = info;
			this.properties = createPropertyMask(info.coherent);
		}

		public CPUBufferBackend build(IVulkanContext context)
		{
			info.computeAlignment(context.getPhysicalDevice());
			final long ptr = VkBufferAllocator.allocate(context, info);
			final var memoryBuilder = new FunctionalMemoryBuilder(properties);
			final var backend = new CPUBufferBackend(ptr, info.getAlignedSize(), info.coherent);
			final var ptrs = Stream.of(new BufferPointer(ptr));
			final var memory = memoryBuilder.buildMemory(context, ptrs);
			backend.linkMemory(memory);
			return backend;
		}

		private static int createPropertyMask(boolean coherent)
		{
			int properties = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT;
			if (coherent)
			{
				properties |= VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;
			}
			return properties;
		}
	}
}
