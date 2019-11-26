package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.resource.buffer.provider.DataProviderWrapper;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;

@Statefull
@Adapter(scope = CompositeBuffer.class, lazy = false)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final List<DataProviderWrapper> providerWrappers;
	private final CompositeBuffer compositeBuffer;
	private final ITransferBuffer transferBuffer;

	private GPUBufferBackend oldBufferBackend;
	private GPUBufferBackend bufferBackend;
	private IExecutionContext context;
	private int freeOldBufferIn = 0;

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
		this.compositeBuffer = compositeBuffer;
		final var pushBuffer = compositeBuffer.getTransferBuffer();
		final var transferBufferAdapter = pushBuffer.adaptNotNull(ITransferBufferAdapter.class);
		transferBuffer = transferBufferAdapter.getTransferBufferBackend();
		this.providerWrappers = List.copyOf(buildProviderWrapers(compositeBuffer));
	}

	@Override
	public void configureAllocation(IAllocationConfiguration configuration,
									IExecutionContext context)
	{
		configuration.addChildren(providerWrappers);
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
		for (final var wrapper : providerWrappers)
		{
			if (wrapper.hasChanged())
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
	public void prepareFlush(EFlushMode mode, int instance)
	{
		if (mode == EFlushMode.PUSH)
		{
			refreshConfiguration(false);
		}

		final List<DataProviderWrapper> providersToPush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		for (final var providerWrapper : providerWrappers)
		{
			if (mode == EFlushMode.FETCH || providerWrapper.needPush())
			{
				if (providerWrapper.reserveMemory(transferBuffer) == false)
				{
					reservationSuccessfull = false;
					break;
				}

				providersToPush.add(providerWrapper);
			}
		}

		for (final var providerWrapper : providersToPush)
		{
			if (reservationSuccessfull)
			{
				if (mode == EFlushMode.PUSH)
				{
					providerWrapper.pushProvidedData(instance);
				}
				else if (mode == EFlushMode.FETCH)
				{
					providerWrapper.fetchDeviceData(instance);
				}
			}
			else
			{
				providerWrapper.releaseMemory();
			}
		}
	}

	private void refreshConfiguration(boolean force)
	{
		checkOldBuffer();

		boolean found = force;

		for (int i = 0; i < providerWrappers.size(); i++)
		{
			final var providerWrapper = providerWrappers.get(i);
			if (providerWrapper.hasChanged())
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
		for (int i = 0; i < providerWrappers.size(); i++)
		{
			final var providerWrapper = providerWrappers.get(i);
			providerWrapper.updateAlignement(usageSize.position);

			final long offset = providerWrapper.getInstanceOffset(0);
			final long size = providerWrapper.getTotalSize();

			usageSize.position = offset + size;
			usageSize.usage |= providerWrapper.getUsage();
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
			final long targetSize = (long) (size * compositeBuffer.getGrowFactor());
			final var info = new BufferInfo(targetSize, usage, false);
			bufferBackend = new GPUBufferBackend(info, false);
			bufferBackend.allocate(context);

			for (int i = 0; i < providerWrappers.size(); i++)
			{
				final var providerWrapper = providerWrappers.get(i);
				providerWrapper.updateBuffer(bufferBackend.getAddress());
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

	// @Override
	public long getSize(int componentIndex)
	{
		return providerWrappers.get(componentIndex).getInstanceSize();
	}

	@Override
	public long getOffset(int componentIndex, int instance)
	{
		return providerWrappers.get(componentIndex).getInstanceOffset(instance);
	}

	@Override
	public void pushData(ByteBuffer data)
	{}

	@Override
	public long mapMemory()
	{
		throw new AssertionError("Forbidden operation");
	}

	@Override
	public void unmapMemory()
	{
		throw new AssertionError("Forbidden operation");
	}

	public long getBufferAddress()
	{
		return bufferBackend.getAddress();
	}

	@Override
	public void flush()
	{
		// Nothing to flush for device local buffer
	}

	@Override
	public void invalidate()
	{
		// Nothing to invalidate for device local buffer
	}

	private static List<DataProviderWrapper> buildProviderWrapers(CompositeBuffer compositeBuffer)
	{
		final List<DataProviderWrapper> res = new ArrayList<>();
		for (final var child : compositeBuffer.getDataProviders())
		{
			res.add(child.adaptNotNull(DataProviderWrapper.class));
		}
		return res;
	}

	private static final class UsageSize
	{
		long position = 0;
		int usage = 0;
	}
}
