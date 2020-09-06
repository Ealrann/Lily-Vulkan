package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.util.VulkanDebugUtil;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import static org.lwjgl.vulkan.VK10.vkBindBufferMemory;
import static org.lwjgl.vulkan.VK10.vkDestroyBuffer;

public final class GPUBufferBackend implements IBufferBackend
{
	private final long size;
	private final long address;

	private long memoryAddress;

	public GPUBufferBackend(long size, long address)
	{
		this.size = size;
		this.address = address;
	}

	@Override
	public void bindBufferMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		memoryAddress = memoryPtr;
		vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
		// System.out.println(Long.toHexString(bufferMemoryId));
	}

	@Override
	public void free(IVulkanContext context)
	{
		// System.out.println("free " + Long.toHexString(address));
		final var vkDevice = context.getVkDevice();
		vkDestroyBuffer(vkDevice, address, null);
		memoryAddress = 0;
	}

	@Override
	public void pushData(final IRecordContext recordContext, final Consumer<ByteBuffer> dataProvider)
	{
		final int pushSize = (int) this.size;
		pushDataInternal(filler -> filler.fill(recordContext, dataProvider, 0, pushSize));
	}

	@Override
	public void pushData(IRecordContext recordContext, ByteBuffer data)
	{
		final int pushSize = (int) Math.min(data.remaining(), this.size);
		pushDataInternal(filler -> filler.fill(recordContext, data, 0, pushSize));
	}

	public void pushDataInternal(Consumer<BufferGPUFiller> fillWithFiller)
	{
		final var bufferFiller = new BufferGPUFiller(address);
		fillWithFiller.accept(bufferFiller);

		if (VulkanDebugUtil.DEBUG_ENABLED)
		{
			System.err.println("[Warning] Pushing in a non staged GPU Buffer is slow. Don't use it in the main loop.");
		}
	}

	@Override
	public long getAddress()
	{
		return address;
	}
}
