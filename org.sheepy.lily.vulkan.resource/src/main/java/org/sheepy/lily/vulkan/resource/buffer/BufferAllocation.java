package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferBackend;
import org.sheepy.lily.vulkan.core.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.Buffer;

import java.nio.ByteBuffer;

@ModelExtender(scope = Buffer.class)
@Allocation(context = ExecutionContext.class)
public final class BufferAllocation implements IBufferAllocation
{
	private final IBufferBackend bufferBackend;
	private final ExecutionContext executionManager;

	public BufferAllocation(Buffer buffer, ExecutionContext context)
	{
		executionManager = context;
		final var info = createInfo(buffer);
		if (!buffer.isHostVisible())
		{
			final var bufferBuilder = new GPUBufferBackend.Builder(info, buffer.isKeptMapped());
			bufferBackend = bufferBuilder.build(context);
		}
		else
		{
			final var bufferBuilder = new CPUBufferBackend.Builder(info, buffer.isCoherent());
			bufferBackend = bufferBuilder.build(context);
		}

		final var data = buffer.getData();
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
		bufferBackend.nextInstance(executionManager.getVkDevice());
		bufferBackend.pushData(executionManager, data);
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		//TODO
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
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
		return bufferBackend.mapMemory(executionManager.getVkDevice());
	}

	@Override
	public void unmapMemory()
	{
		bufferBackend.unmapMemory(executionManager.getVkDevice());
	}

	private static BufferInfo createInfo(Buffer buffer)
	{
		final var size = buffer.getSize();
		final int usage = VulkanModelUtil.getEnumeratedFlag(buffer.getUsages());
		final var keptMapped = buffer.isKeptMapped();
		final var eInstanceCount = buffer.getInstanceCount();
		final int instanceCount = InstanceCountUtil.getInstanceCount(buffer, eInstanceCount);

		return new BufferInfo(size, usage, keptMapped, instanceCount);
	}

	@Override
	public void flush()
	{
		try (final var stack = MemoryStack.stackPush())
		{
			bufferBackend.flush(stack, executionManager.getVkDevice());
		}
	}

	@Override
	public void invalidate()
	{
		try (final var stack = MemoryStack.stackPush())
		{
			bufferBackend.invalidate(stack, executionManager.getVkDevice());
		}
	}
}
