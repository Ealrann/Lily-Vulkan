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
import java.util.stream.Stream;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.vkMapMemory;
import static org.lwjgl.vulkan.VK10.vkUnmapMemory;

public final class HostVisibleBufferBackend implements IBufferBackend
{
	private final VkBuffer vkBuffer;
	private final long size;
	private final Memory memory;
	private final boolean freeMemory;

	private long memoryMap = 0;

	public HostVisibleBufferBackend(final VkBuffer vkBuffer, final long size, final Memory memory, final boolean freeMemory)
	{
		this.vkBuffer = vkBuffer;
		this.size = size;
		this.memory = memory;
		this.freeMemory = freeMemory;
	}

	@Override
	public void free(final IVulkanContext context)
	{
		final var vkDevice = context.getVkDevice();

		if (memoryMap != 0)
		{
			unmapMemory(vkDevice);
		}

		// System.out.println("free " + Long.toHexString(address));
		vkBuffer.free(vkDevice);
		if (freeMemory) memory.free(context);
	}

	@Override
	public void pushData(final IRecordContext context, final ByteBuffer data)
	{
		pushDataInternal(context, () -> MemoryUtil.memCopy(memAddress(data), memoryMap, size));
	}

	@Override
	public void pushData(final IRecordContext context, final Consumer<ByteBuffer> dataProvider)
	{
		pushDataInternal(context, () -> dataProvider.accept(MemoryUtil.memByteBuffer(memoryMap, (int) size)));
	}

	private void pushDataInternal(final IVulkanContext vulkanContext, final Runnable doPush)
	{
		final VkDevice vkDevice = vulkanContext.getVkDevice();
		final boolean wasMapped = memoryMap != 0;
		if (!wasMapped) mapMemory(vkDevice);
		doPush.run();
		if (!wasMapped) unmapMemory(vkDevice);
	}

	public long mapMemory(final VkDevice vkDevice)
	{
		if (memoryMap == 0)
		{
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(vkDevice, memory.ptr(), 0, size, 0, pBuffer);
			memoryMap = pBuffer.get(0);
			MemoryUtil.memFree(pBuffer);
		}

		return memoryMap;
	}

	public void unmapMemory(final VkDevice vkDevice)
	{
		if (memoryMap != 0)
		{
			vkUnmapMemory(vkDevice, memory.ptr());
			memoryMap = 0;
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void flush(final MemoryStack stack, final VkDevice vkDevice)
	{
		if (memory.info().coherent() == false)
		{
			BufferUtils.flush(stack, vkDevice, memory.ptr());
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void invalidate(final MemoryStack stack, final VkDevice vkDevice)
	{
		if (memory.info().coherent() == false)
		{
			BufferUtils.invalidate(stack, vkDevice, memory.ptr());
		}
	}

	@Override
	public long getAddress()
	{
		return vkBuffer.ptr();
	}

	public long getMemoryAddress()
	{
		return memory.ptr();
	}

	public long getMemoryMap()
	{
		return memoryMap;
	}

	public long getSize()
	{
		return size;
	}

	public static final record Builder(BufferInfo info)
	{
		public HostVisibleBufferBackend build(final IVulkanContext context)
		{
			info.computeAlignment(context.getPhysicalDevice());
			final var vkBuffer = VkBufferAllocator.allocate(context, info, "");
			final var info = new Memory.Info(true, this.info.coherent);
			final var memoryBuilder = new MemoryBuilder(info);
			final var ptrs = Stream.of(vkBuffer);
			final var memory = memoryBuilder.build(context, ptrs);
			final var backend = new HostVisibleBufferBackend(vkBuffer, this.info.getAlignedSize(), memory, true);
			return backend;
		}
	}
}
