package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.util.VulkanDebugUtil;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public final class DeviceLocalBufferBackend implements IBufferBackend
{
	private final VkBuffer vkBuffer;
	private final long size;

	public DeviceLocalBufferBackend(final VkBuffer vkBuffer, final long size)
	{
		this.vkBuffer = vkBuffer;
		this.size = size;
	}

	@Override
	public void free(IVulkanContext context)
	{
		// System.out.println("free " + Long.toHexString(address));
		final var vkDevice = context.getVkDevice();
		vkBuffer.free(vkDevice);
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
		final var bufferFiller = new BufferGPUFiller(vkBuffer.ptr());
		fillWithFiller.accept(bufferFiller);

		if (VulkanDebugUtil.DEBUG_ENABLED)
		{
			System.err.println("[Warning] Pushing in a non staged GPU Buffer is slow. Don't use it in the main loop.");
		}
	}

	@Override
	public long getAddress()
	{
		return vkBuffer.ptr();
	}
}
