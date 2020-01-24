package org.sheepy.lily.vulkan.resource.buffer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.adapter.util.NotificationListenerDeployer;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.common.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.common.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.common.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.common.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAdapter;

@Statefull
@Adapter(scope = CompositeBuffer.class, lazy = false)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final AdapterSetRegistry<BufferPartAdapter> partsRegistry = new AdapterSetRegistry<>(	BufferPartAdapter.class,
																									List.of(ResourcePackage.Literals.COMPOSITE_BUFFER__PARTS));
	private final INotificationListener sizeListener = this::partResized;
	private final NotificationListenerDeployer sizeListenerDeployer = new NotificationListenerDeployer(	List.of(ResourcePackage.Literals.COMPOSITE_BUFFER__PARTS,
																												ResourcePackage.Literals.BUFFER_PART__DATA_PROVIDER),
																										sizeListener,
																										ResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE);

	private final CompositeBuffer compositeBuffer;

	private GPUBufferBackend bufferBackend;
	private InternalExecutionContext context;
	private IAllocationConfigurator configurator;

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
		this.compositeBuffer = compositeBuffer;
	}

	@Load
	private void load()
	{
		partsRegistry.startRegister(compositeBuffer);
		sizeListenerDeployer.startRegister(compositeBuffer);
	}

	@Dispose
	private void dispose()
	{
		sizeListenerDeployer.stopRegister(compositeBuffer);
		partsRegistry.stopRegister(compositeBuffer);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator configurator,
									InternalExecutionContext context)
	{
		this.configurator = configurator;
		configurator.addChildren(partsRegistry.getAdapters());
	}

	private void partResized(Notification notification)
	{
		if (configurator != null)
		{
			final var provider = (BufferDataProvider<?>) notification.getNotifier();
			final var part = (BufferPart) provider.eContainer();
			final var adapter = part.adapt(BufferPartAdapter.class);
			if (adapter.needResize())
			{
				configurator.setDirty();
				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
				{
					System.out.println("Need resize of composite buffer "
							+ compositeBuffer.getName());
				}
			}
		}
	}

	@Override
	public void allocate(InternalExecutionContext context)
	{
		this.context = context;

		final var usageSize = alignData();
		final long size = Math.max(usageSize.position, 1);
		createBufferBackend(size, usageSize.usage);
	}

	@Override
	public void free(InternalExecutionContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	@Override
	public void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts)
	{
		final var transferBufferAdapter = transferBuffer.adaptNotNull(TransferBufferAdapter.class);

		final List<BufferPartAdapter> partsToFlush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		for (final var part : parts)
		{
			final var partAdapter = part.adapt(BufferPartAdapter.class);

			if (mode == EFlushMode.FETCH || partAdapter.needPush())
			{
				partsToFlush.add(partAdapter);

				if (partAdapter.reserveMemory(transferBufferAdapter) == false)
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

	private void createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false);
		bufferBackend = new GPUBufferBackend(info, false);
		bufferBackend.allocate(context);

		final var adapters = partsRegistry.getAdapters();
		for (int i = 0; i < adapters.size(); i++)
		{
			final var partAdapter = adapters.get(i);
			partAdapter.updateBuffer(bufferBackend.getAddress());
		}
	}

	private UsageSize alignData()
	{
		final var usageSize = new UsageSize();
		final var adapters = partsRegistry.getAdapters();
		for (int i = 0; i < adapters.size(); i++)
		{
			final var partAdapter = adapters.get(i);
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
