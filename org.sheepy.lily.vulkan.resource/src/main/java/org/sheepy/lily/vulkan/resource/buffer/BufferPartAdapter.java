package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.LongNotification;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.common.resource.buffer.IBufferPartAdapter;
import org.sheepy.lily.vulkan.common.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket.EReservationStatus;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = BufferPart.class)
public final class BufferPartAdapter extends Notifier implements IBufferPartAdapter
{
	public final BufferDataProvider<?> dataProvider;

	private final int usage;
	private final int accessBeforePush;
	private final int accessBeforeFetch;

	private long alignment;
	private long bufferPtr;
	private long offset;
	private long instanceSize;

	private int instance;
	private int instanceCount;
	private boolean firstPush = true;

	private boolean needPush = true;
	private MemoryTicket memTicket;
	private ITransferBuffer transferBuffer;

	private BufferPartAdapter(BufferPart bufferPart)
	{
		super(Features.values().length);

		assert bufferPart.getDataProvider() != null;

		this.dataProvider = bufferPart.getDataProvider();
		usage = computeUsage(dataProvider);

		accessBeforePush = VkModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforePush());
		accessBeforeFetch = VkModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforeFetch());
	}

	private static int computeUsage(BufferDataProvider<?> dataProvider)
	{
		final int usage = VkModelUtil.getEnumeratedFlag(dataProvider.getUsages());
		final int pushUsage = dataProvider.isUsedToPush() ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
		final int fetchUsage = dataProvider.isUsedToFetch()
				? EBufferUsage.TRANSFER_SRC_BIT_VALUE
				: 0;

		return usage | pushUsage | fetchUsage;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var physicalDevice = context.getPhysicalDevice();
		alignment = physicalDevice.getBufferAlignement(usage);

		final var eInstanceCount = dataProvider.getInstanceCount();
		instanceCount = InstanceCountUtil.getInstanceCount(context, eInstanceCount);
		instance = 0;
		firstPush = true;

		dataProvider.adapt(IBufferDataProviderAdapter.class);
	}

	@Override
	public void free(IExecutionContext context)
	{}

	public void updateAlignement(long desiredOffset)
	{
		final long oldSize = this.instanceSize;
		final long oldOffset = this.offset;
		final long size = computeSize();

		this.instanceSize = align(size, alignment);
		this.offset = align(desiredOffset, alignment);

		if (oldSize != this.instanceSize)
		{
			fireNotification(new LongNotification(this, Features.Size, oldSize, this.instanceSize));
		}
		if (oldOffset != this.offset)
		{
			fireNotification(new LongNotification(this, Features.Offset, oldOffset, this.offset));
		}
	}

	private long computeSize()
	{
		final long requestedSize = dataProvider.getRequestedSize();
		final float growFactor = dataProvider.getGrowFactor();
		final long minSize = dataProvider.getMinSize();
		final long size = (long) Math.ceil(requestedSize * growFactor);

		return Math.max(size, minSize);
	}

	public void updateBuffer(long bufferPtr)
	{
		assert bufferPtr != 0;
		final long oldBufferPtr = this.bufferPtr;
		this.bufferPtr = bufferPtr;

		if (oldBufferPtr != bufferPtr)
		{
			fireNotification(new LongNotification(	this,
													Features.Ptr,
													oldBufferPtr,
													this.bufferPtr));
		}
	}

	public boolean needPush()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return (needPush || adapter.hasChanged()) && instanceSize > 0;
	}

	public boolean reserveMemory(ITransferBuffer stagingBuffer)
	{
		this.transferBuffer = stagingBuffer;
		memTicket = stagingBuffer.reserveMemory(instanceSize);

		return memTicket.getReservationStatus() == EReservationStatus.SUCCESS;
	}

	public void releaseMemory()
	{
		if (memTicket.getReservationStatus() == EReservationStatus.SUCCESS
				|| memTicket.getReservationStatus() == EReservationStatus.FLUSHED)
		{
			transferBuffer.releaseTicket(memTicket);
		}
	}

	public void pushProvidedData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final var adapter = dataProvider.adaptNotNull(IBufferDataProviderAdapter.class);
		adapter.fill(memTicket.toBuffer());

		if (firstPush)
		{
			firstPush = false;
		}
		else
		{
			nextInstance();
		}

		final long instanceOffset = getInstanceOffset(instance);
		final var stage = dataProvider.getStageBeforePush();

		final var pushCommand = IDataFlowCommand.newPushCommand(memTicket,
																bufferPtr,
																instanceOffset,
																stage,
																accessBeforePush);

		// System.out.println(String.format( "[%s] push %d bytes",
		// dataProvider.eClass().getName(),
		// memTicket.getSize()));
		// System.out.println(String.format( "from buffer %d, offset %d",
		// bufferAddress,
		// alignedOffset));
		// System.out.println(String.format( "to buffer %d, offset %d",
		// memTicket.getBufferPtr(),
		// memTicket.getBufferOffset()));

		transferBuffer.addTransferCommand(pushCommand);

		needPush = false;
	}

	private void nextInstance()
	{
		final long oldOffset = getBindOffset();

		instance = (instance + 1) % instanceCount;

		final long newOffset = getBindOffset();

		fireNotification(new LongNotification(this, Features.Offset, oldOffset, newOffset));
	}

	public void fetchDeviceData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		final Consumer<MemoryTicket> transferDone = ticket -> adapter.fetch(memTicket.toReadBuffer());

		final long instanceOffset = getInstanceOffset(instance);
		final var stage = dataProvider.getStageBeforeFetch();

		final var fetchCommand = IDataFlowCommand.newFetchCommand(	memTicket,
																	bufferPtr,
																	instanceOffset,
																	stage,
																	accessBeforeFetch,
																	transferDone);

		transferBuffer.addTransferCommand(fetchCommand);
	}

	public boolean needResize()
	{
		final float growSize = instanceSize * dataProvider.getGrowThreshold();
		return dataProvider.getRequestedSize() > growSize;
	}

	public long getTotalSize()
	{
		return instanceSize * instanceCount;
	}

	public long getInstanceOffset(int instance)
	{
		return offset + (instance * instanceSize);
	}

	@Override
	public long getPtr()
	{
		return bufferPtr;
	}

	private static long align(long index, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) index) / alignment);
		return chunkCount * alignment;
	}

	public int getUsage()
	{
		return usage;
	}

	@Override
	public long getMemoryPtr()
	{
		return 0;
	}

	@Override
	public long getBindSize()
	{
		return instanceSize;
	}

	@Override
	public long getBindOffset()
	{
		return getInstanceOffset(instance);
	}

	@Override
	public long mapMemory()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void unmapMemory()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void flush()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void invalidate()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void pushData(ByteBuffer data)
	{
		throw new AssertionError("Unsupported Operation");
	}
}
