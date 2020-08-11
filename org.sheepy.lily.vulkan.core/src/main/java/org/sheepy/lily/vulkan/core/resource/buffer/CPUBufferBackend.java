package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

public final class CPUBufferBackend implements IBufferBackend
{
	public final BufferInfo info;
	private final long address;

	private long memoryAddress;
	private Memory memory;
	private long memoryMap = 0;
	private int currentInstance = 0;
	private long currentOffset = 0;

	private CPUBufferBackend(BufferInfo info, long address)
	{
		this.info = info;
		this.address = address;
	}

	@Override
	public void bindBufferMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		memoryAddress = memoryPtr;
		vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
		// System.out.println(Long.toHexString(bufferMemoryId));
		if (info.keptMapped)
		{
			mapMemory(vkDevice);
		}
	}

	private void linkMemory(final Memory memory)
	{
		this.memory = memory;
	}

	@Override
	public void free(IVulkanContext context)
	{
		final var vkDevice = context.getVkDevice();

		if (memoryMap != 0)
		{
			unmapMemory(vkDevice);
		}

		vkDestroyBuffer(vkDevice, address, null);
		if (memory != null) memory.free(context);

		memoryAddress = 0;
	}

	@Override
	public void pushData(IRecordContext context, ByteBuffer data)
	{
		pushDataInternal(context, () -> MemoryUtil.memCopy(memAddress(data), memoryMap, info.size));
	}

	@Override
	public void pushData(IRecordContext context, Consumer<ByteBuffer> dataProvider)
	{
		pushDataInternal(context,
						 () -> dataProvider.accept(MemoryUtil.memByteBuffer(memoryMap, (int) info.size)));
	}

	private void pushDataInternal(IVulkanContext vulkanContext, Runnable doPush)
	{
		if (address == 0)
		{
			throw new AssertionError("Buffer not allocated");
		}

		final VkDevice vkDevice = vulkanContext.getVkDevice();
		mapMemory(vkDevice);
		doPush.run();

		if (info.keptMapped == false)
		{
			unmapMemory(vkDevice);
		}
	}

	@Override
	public long mapMemory(VkDevice vkDevice)
	{
		if (memoryMap == 0)
		{
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(vkDevice, memoryAddress, currentOffset, info.getInstanceSize(), 0, pBuffer);
			memoryMap = pBuffer.get(0);
			MemoryUtil.memFree(pBuffer);
		}

		return memoryMap;
	}

	@Override
	public void unmapMemory(VkDevice vkDevice)
	{
		if (memoryMap != 0)
		{
			vkUnmapMemory(vkDevice, memoryAddress);
			memoryMap = 0;
		}
	}

	@Override
	public void nextInstance(VkDevice vkDevice)
	{
		final int newInstance = (currentInstance + 1) % info.instanceCount;

		if (newInstance != currentInstance)
		{
			final boolean wasMapped = memoryMap != 0;
			if (wasMapped)
			{
				unmapMemory(vkDevice);
			}

			currentInstance = newInstance;
			currentOffset = getOffset(currentInstance);

			if (wasMapped)
			{
				mapMemory(vkDevice);
			}
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	@Override
	public void flush(MemoryStack stack, VkDevice vkDevice)
	{
		if (info.coherent == false)
		{
			BufferUtils.flush(stack, vkDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void flush(MemoryStack stack, VkDevice vkDevice, int instance)
	{
		if (info.coherent == false)
		{
			final long size = info.getInstanceSize();
			final long offset = getOffset(instance);
			BufferUtils.flush(stack, vkDevice, memoryAddress, size, offset);
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	@Override
	public void invalidate(MemoryStack stack, VkDevice vkDevice)
	{
		if (info.coherent == false)
		{
			BufferUtils.invalidate(stack, vkDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void invalidate(MemoryStack stack, VkDevice vkDevice, int instance)
	{
		if (info.coherent == false)
		{
			final long size = info.getInstanceSize();
			final long offset = getOffset(instance);
			BufferUtils.invalidate(stack, vkDevice, memoryAddress, size, offset);
		}
	}

	private long getOffset(int instance)
	{
		return instance * info.getInstanceSize();
	}

	@Override
	public long getInstanceOffset()
	{
		return currentOffset;
	}

	@Override
	public long getInstanceSize()
	{
		return info.getInstanceSize();
	}

	public BufferInfo getInfos()
	{
		return info;
	}

	@Override
	public long getAddress()
	{
		return address;
	}

	@Override
	public long getMemoryAddress()
	{
		return memoryAddress;
	}

	public long getMemoryMap()
	{
		return memoryMap;
	}

	public int getCurrentInstance()
	{
		return currentInstance;
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
			final var memoryBuilder = new MemoryBuilder(context, properties);
			final var res = build(context, memoryBuilder);
			final var memory = memoryBuilder.build(context);
			res.linkMemory(memory);
			return res;
		}

		public CPUBufferBackend build(IVulkanContext context, MemoryBuilder memoryBuilder)
		{
			info.computeAlignment(context.getPhysicalDevice());
			final long address = VkBufferAllocator.allocate(context, info);
			final var backend = new CPUBufferBackend(info, address);
			memoryBuilder.registerBuffer(address, backend::bindBufferMemory);
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
