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
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.FlushListener;

@Statefull
@Adapter(scope = CompositeBuffer.class)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final List<DataProviderWrapper> providerWrappers;
	private final List<IVkDescriptor> descriptors = new ArrayList<>();
	private final CompositeBuffer compositeBuffer;
	private final ITransferBuffer transferBuffer;
	private final FlushListener flushListener = this::update;

	private GPUBufferBackend oldBufferBackend;
	private GPUBufferBackend bufferBackend;
	private boolean allocated = false;
	private IExecutionContext context;
	private int freeOldBufferIn = 0;

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
		this.compositeBuffer = compositeBuffer;
		final var pushBuffer = compositeBuffer.getTransferBuffer();
		final var pushBufferAdapter = pushBuffer.adaptNotNull(ITransferBufferAdapter.class);
		transferBuffer = pushBufferAdapter.getTransferBufferBackend();
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

		transferBuffer.addListener(flushListener);

		for (int i = 0; i < providerWrappers.size(); i++)
		{
			final var providerWrapper = providerWrappers.get(i);
			final var descriptor = providerWrapper.getDescriptor();
			if (descriptor != null)
			{
				descriptors.add(descriptor);
			}
		}

		allocated = true;
	}

	@Override
	public void free(IExecutionContext context)
	{
		allocated = false;
		if (oldBufferBackend != null)
		{
			oldBufferBackend.free(context);
			oldBufferBackend = null;
		}
		bufferBackend.free(context);
		transferBuffer.removeListener(flushListener);
	}

	private void update()
	{
		final var mode = compositeBuffer.getMode();

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
					providerWrapper.pushProvidedData();
				}
				else if (mode == EFlushMode.FETCH)
				{
					providerWrapper.fetchDeviceData();
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

		int usage = EBufferUsage.TRANSFER_DST_BIT_VALUE;
		long position = 0;
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
			for (int i = 0; i < providerWrappers.size(); i++)
			{
				final var providerWrapper = providerWrappers.get(i);
				providerWrapper.updateAlignement(position);
				position = providerWrapper.getOffset() + providerWrapper.getSize();
				usage |= providerWrapper.dataProvider.getUsage().getValue();
			}

			final long size = Math.max(Math.max(position, compositeBuffer.getMinSize()), 1);
			updateBuffer(size, usage);
		}
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

	@Override
	public long getSize(int componentIndex)
	{
		return providerWrappers.get(componentIndex).getSize();
	}

	@Override
	public long getOffset(int componentIndex)
	{
		return providerWrappers.get(componentIndex).getOffset();
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

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		assert allocated == true;
		return descriptors;
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
}
