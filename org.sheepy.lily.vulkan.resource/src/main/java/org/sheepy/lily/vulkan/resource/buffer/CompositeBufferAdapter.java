package org.sheepy.lily.vulkan.resource.buffer;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;

@Statefull
@Adapter(scope = CompositeBuffer.class, lazy = false)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final AdapterSetRegistry<BufferPartAdapter> partsRegistry = new AdapterSetRegistry<>(	BufferPartAdapter.class,
																									List.of(ResourcePackage.Literals.COMPOSITE_BUFFER__PARTS));
	private final CompositeBuffer compositeBuffer;

	private GPUBufferBackend oldBufferBackend;
	private GPUBufferBackend bufferBackend;
	private IExecutionContext context;
	private int freeOldBufferIn = 0;

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
		this.compositeBuffer = compositeBuffer;
	}

	@Load
	private void load()
	{
		partsRegistry.startRegister(compositeBuffer);
	}

	@Dispose
	private void dispose()
	{
		partsRegistry.stopRegister(compositeBuffer);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator configuration,
									IExecutionContext context)
	{
		configuration.addChildren(partsRegistry.getAdapters());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		this.context = context;

		refreshConfiguration(true);
	}

	@Override
	public boolean needRecord()
	{
		for (final var partAdapter : partsRegistry.getAdapters())
		{
			if (partAdapter.sizeChanged())
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public void free(IExecutionContext context)
	{
		if (oldBufferBackend != null)
		{
			oldBufferBackend.free(context);
			oldBufferBackend = null;
		}
		bufferBackend.free(context);
	}

	@Override
	public void recordFlush(EFlushMode mode, TransferBuffer transferBuffer, List<BufferPart> parts)
	{
		final var transferBufferAdapter = transferBuffer.adaptNotNull(ITransferBufferAdapter.class);
		final var transferBackend = transferBufferAdapter.getTransferBufferBackend();

		final List<BufferPartAdapter> partsToFlush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		if (mode == EFlushMode.PUSH)
		{
			refreshConfiguration(false);
		}

		for (final var part : parts)
		{
			final var partAdapter = part.adapt(BufferPartAdapter.class);

			if (mode == EFlushMode.FETCH || partAdapter.needPush())
			{
				partsToFlush.add(partAdapter);

				if (partAdapter.reserveMemory(transferBackend) == false)
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

	private void refreshConfiguration(boolean force)
	{
		checkOldBuffer();

		boolean found = force;

		final var adapters = partsRegistry.getAdapters();
		for (int i = 0; i < adapters.size(); i++)
		{
			final var partAdapter = adapters.get(i);
			if (partAdapter.sizeChanged())
			{
				found |= true;
				break;
			}
		}

		if (found)
		{
			final var usageSize = alignData();
			final long size = Math.max(	Math.max(usageSize.position, compositeBuffer.getMinSize()),
										1);
			updateBuffer(size, usageSize.usage);
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

	private void updateBuffer(long size, int usage)
	{
		if (bufferBackend != null)
		{
			if (bufferBackend.getInfos().getInstanceSize() < size)
			{
				planFreeBuffer();
				bufferBackend = null;
				if (DebugUtil.DEBUG_ENABLED)
				{
					System.out.println("Resize composite buffer");
				}
			}
		}

		if (bufferBackend == null)
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
	}

	private void checkOldBuffer()
	{
		if (oldBufferBackend != null)
		{
			if (freeOldBufferIn == 0)
			{
				oldBufferBackend.free(context);
				oldBufferBackend = null;
			}
			else
			{
				freeOldBufferIn--;
			}
		}
	}

	private void planFreeBuffer()
	{
		if (oldBufferBackend != null)
		{
			oldBufferBackend.free(context);
			oldBufferBackend = null;
		}
		oldBufferBackend = bufferBackend;
		freeOldBufferIn = 20;
	}

	private static final class UsageSize
	{
		long position = 0;
		int usage = 0;
	}
}
