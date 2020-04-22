package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = CompositeBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(allocateBeforeParent = true, reportStateToParent = true, features = VulkanResourcePackage.COMPOSITE_BUFFER__PARTS)
@AllocationDependency(features = VulkanResourcePackage.COMPOSITE_BUFFER__PARTS, type = BufferPartAllocation.class)
public final class CompositeBufferAllocation implements ICompositeBufferAllocation
{
	private final ExecutionContext context;
	private final List<BufferPartAllocation> partAllocations;
	private final GPUBufferBackend bufferBackend;

	public CompositeBufferAllocation(ExecutionContext context,
									 @InjectDependency(index = 0) List<BufferPartAllocation> partAllocations)
	{
		this.context = context;
		this.partAllocations = List.copyOf(partAllocations);

		final var usageSize = alignData();
		final long size = Math.max(usageSize.position, 1);
		this.bufferBackend = createBufferBackend(size, usageSize.usage);
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts)
	{
		final var transferBufferAdapter = transferBuffer.adapt(TransferBufferAllocation.class);
		final List<BufferPartAllocation> partsToFlush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		for (final var part : parts)
		{
			final var partAllocation = resolvePartAllocation(part);

			if (mode == EFlushMode.FETCH || partAllocation.needPush())
			{
				partsToFlush.add(partAllocation);

				if (partAllocation.reserveMemory(transferBufferAdapter) == false)
				{
					reservationSuccessfull = false;
					break;
				}
			}
		}

		for (final var partAdapter : partsToFlush)
		{
			if (reservationSuccessfull)
			{
				if (mode == EFlushMode.PUSH)
				{
					partAdapter.pushProvidedData();
				}
				else if (mode == EFlushMode.FETCH)
				{
					partAdapter.fetchDeviceData();
				}
			}
			else
			{
				partAdapter.releaseMemory();
			}
		}
	}

	private BufferPartAllocation resolvePartAllocation(BufferPart part)
	{
		for (var bufferPartAllocation : partAllocations)
		{
			if (bufferPartAllocation.bufferPart == part)
			{
				return bufferPartAllocation;
			}
		}
		throw new AssertionError("Buffer part is not contained in this CompositeBuffer");
	}

	private GPUBufferBackend createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false);
		final var bufferBuilder = new GPUBufferBackend.Builder(info, false);
		final var bufferBackend = bufferBuilder.build(context);

		for (int i = 0; i < partAllocations.size(); i++)
		{
			final var partAdapter = partAllocations.get(i);
			partAdapter.updateBuffer(bufferBackend.getAddress());
		}
		return bufferBackend;
	}

	private UsageSize alignData()
	{
		final var usageSize = new UsageSize();
		for (int i = 0; i < partAllocations.size(); i++)
		{
			final var partAdapter = partAllocations.get(i);
			partAdapter.updateAlignement(usageSize.position);

			final long offset = partAdapter.getInstanceOffset(0);
			final long size = partAdapter.getTotalSize();

			usageSize.position = offset + size;
			usageSize.usage |= partAdapter.getUsage();
		}
		return usageSize;
	}

	private static final class UsageSize
	{
		long position = 0;
		int usage = 0;
	}
}
