package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.common.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.IBufferBackend;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = Buffer.class)
public final class BufferAdapter extends Notifier implements IBufferAdapter
{
	protected Buffer buffer;
	protected IBufferBackend bufferBackend;

	private IExecutionContext executionManager;

	public BufferAdapter(Buffer buffer)
	{
		super(Features.values().length);
		this.buffer = buffer;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		executionManager = context;
		final var info = createInfo(context, buffer);

		if (!buffer.isHostVisible())
		{
			bufferBackend = new GPUBufferBackend(info, buffer.isKeptMapped());
		}
		else
		{
			bufferBackend = new CPUBufferBackend(info, buffer.isCoherent());
		}

		bufferBackend.allocate(context);

		final ByteBuffer data = buffer.getData();
		if (data != null)
		{
			bufferBackend.pushData(executionManager, data);
		}
	}

	@Override
	public void pushData(ByteBuffer data)
	{
		if (DebugUtil.DEBUG_ENABLED)
		{
			System.err.println("[Warning] BufferAdapter.pushData() is slow. Don't use it in the main loop.");
		}

		bufferBackend.nextInstance();
		bufferBackend.pushData(executionManager, data);
	}

	@Override
	public void free(IExecutionContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	@Override
	public long getPtr()
	{
		return bufferBackend.getAddress();
	}

	@Override
	public long getMemoryPtr()
	{
		return bufferBackend.getMemoryAddress();
	}

	@Override
	public long getBindOffset()
	{
		return bufferBackend.getInstanceOffset();
	}

	@Override
	public long getBindSize()
	{
		return bufferBackend.getInstanceSize();
	}

	@Override
	public long mapMemory()
	{
		return bufferBackend.mapMemory();
	}

	@Override
	public void unmapMemory()
	{
		bufferBackend.unmapMemory();
	}

	private static BufferInfo createInfo(IExecutionContext context, Buffer buffer)
	{
		final var size = buffer.getSize();
		final int usage = VkModelUtil.getEnumeratedFlag(buffer.getUsages());
		final var keptMapped = buffer.isKeptMapped();
		final var eInstanceCount = buffer.getInstanceCount();
		final int instanceCount = InstanceCountUtil.getInstanceCount(context, eInstanceCount);

		return new BufferInfo(size, usage, keptMapped, instanceCount);
	}

	@Override
	public void flush()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			bufferBackend.flush(stack, executionManager.getLogicalDevice());
		}
	}

	@Override
	public void invalidate()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			bufferBackend.invalidate(stack, executionManager.getLogicalDevice());
		}
	}
}
