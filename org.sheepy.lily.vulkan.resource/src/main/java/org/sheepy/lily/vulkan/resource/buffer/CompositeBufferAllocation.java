package org.sheepy.lily.vulkan.resource.buffer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.util.NotificationListenerDeployer;
import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ModelExtender(scope = CompositeBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.COMPOSITE_BUFFER__PARTS, type = BufferPartAllocation.class)
@AllocationDependency(features = VulkanResourcePackage.COMPOSITE_BUFFER__PARTS, type = BufferPartAllocation.class)
public final class CompositeBufferAllocation implements ICompositeBufferAllocation
{
	private final Consumer<Notification> sizeListener = this::partResized;
	private final NotificationListenerDeployer sizeListenerDeployer = new NotificationListenerDeployer(List.of(
			VulkanResourcePackage.Literals.COMPOSITE_BUFFER__PARTS,
			VulkanResourcePackage.Literals.BUFFER_PART__DATA_PROVIDER),
																									   sizeListener,
																									   VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE);

	private final CompositeBuffer compositeBuffer;
	private final ExecutionContext context;
	private final List<BufferPartAllocation> partAllocations;

	private GPUBufferBackend bufferBackend;
	private boolean dirty = false;

	public CompositeBufferAllocation(CompositeBuffer compositeBuffer,
									 ExecutionContext context,
									 @InjectDependency(type = BufferPartAllocation.class) List<BufferPartAllocation> partAllocations)
	{
		this.compositeBuffer = compositeBuffer;
		this.context = context;
		this.partAllocations = List.copyOf(partAllocations);

		sizeListenerDeployer.startDeploy(compositeBuffer);

		final var usageSize = alignData();
		final long size = Math.max(usageSize.position, 1);
		createBufferBackend(size, usageSize.usage);
	}

	@Dispose
	public void dispose()
	{
		sizeListenerDeployer.stopDeploy(compositeBuffer);
	}

	private void partResized(Notification notification)
	{
		final var provider = (BufferDataProvider) notification.getNotifier();
		final var part = (BufferPart) provider.eContainer();
		final var allocation = resolvePartAllocation(part);
		if (allocation.needResize())
		{
			dirty = true;
			if (DebugUtil.DEBUG_VERBOSE_ENABLED)
			{
				System.out.println("Need resize of composite buffer " + compositeBuffer.getName());
			}
		}
	}

	@Dirty
	public boolean isDirty()
	{
		return dirty;
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	@Override
	public void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts)
	{
		final var transferBufferAdapter = transferBuffer.allocationHandle(TransferBufferAllocation.class).get();

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
		return null;
	}

	private void createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false);
		final var bufferBuilder = new GPUBufferBackend.Builder(info, false);
		bufferBackend = bufferBuilder.build(context);

		for (int i = 0; i < partAllocations.size(); i++)
		{
			final var partAdapter = partAllocations.get(i);
			partAdapter.updateBuffer(bufferBackend.getAddress());
		}
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
