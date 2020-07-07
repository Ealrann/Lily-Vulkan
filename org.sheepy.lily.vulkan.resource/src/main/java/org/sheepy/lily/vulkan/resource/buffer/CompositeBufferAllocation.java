package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = CompositeBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.COMPOSITE_BUFFER__PARTS)
@AllocationDependency(features = VulkanResourcePackage.COMPOSITE_BUFFER__TRANSFER_BUFFER, type = TransferBufferAllocation.class)
public final class CompositeBufferAllocation implements ICompositeBufferAllocation
{
	private final ExecutionContext context;
	private final TransferBufferAllocation transferBufferAllocation;
	private final GPUBufferBackend bufferBackend;

	private List<BufferPartAllocation> partAllocations;

	public CompositeBufferAllocation(ExecutionContext context,
									 @InjectDependency(index = 0) List<BufferPartAllocation> partAllocations,
									 @InjectDependency(index = 1) TransferBufferAllocation transferBufferAllocation)
	{
		this.context = context;
		this.partAllocations = List.copyOf(partAllocations);
		this.transferBufferAllocation = transferBufferAllocation;

		final var usageSize = alignData();
		final long size = Math.max(usageSize.position, 1);
		this.bufferBackend = createBufferBackend(size, usageSize.usage);

		update();
	}

	@InjectChildren(index = 0, type = BufferPartAllocation.class)
	private void updateChildren(List<BufferPartAllocation> partAllocations)
	{
		this.partAllocations = partAllocations;
	}

	@Tick
	private void update()
	{
		recordFlushInternal(EFlushMode.PUSH, partAllocations);
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public void recordFlush(EFlushMode mode, List<BufferPart> parts)
	{
		final var partAllocations = parts.stream()
										 .map(this::resolvePartAllocation)
										 .collect(Collectors.toUnmodifiableList());

		recordFlushInternal(mode, partAllocations);
	}

	private void recordFlushInternal(final EFlushMode mode, final List<BufferPartAllocation> partAllocations)
	{
		final List<BufferPartAllocation> partsToFlush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		for (final var partAllocation : partAllocations)
		{
			if (mode == EFlushMode.FETCH || partAllocation.needPush())
			{
				partsToFlush.add(partAllocation);

				if (partAllocation.reserveMemory(transferBufferAllocation) == false)
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
