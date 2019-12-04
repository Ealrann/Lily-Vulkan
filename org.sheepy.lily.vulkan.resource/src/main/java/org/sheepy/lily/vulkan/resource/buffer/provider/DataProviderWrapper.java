package org.sheepy.lily.vulkan.resource.buffer.provider;

import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.notification.LongNotification;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.common.resource.IDataProviderAlignmentAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket.EReservationStatus;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = BufferDataProvider.class, scopeInheritance = true)
public final class DataProviderWrapper extends NotifierAdapter
		implements IAllocableAdapter<IExecutionContext>, IDataProviderAlignmentAdapter
{
	public final BufferDataProvider<?> dataProvider;

	private final int usage;
	private final int accessBeforePush;
	private final int accessBeforeFetch;

	private long alignment;
	private long bufferPtr;
	private long offset;
	private long instanceSize;

	private boolean needPush = true;
	private MemoryTicket memTicket;
	private ITransferBuffer transferBuffer;

	public DataProviderWrapper(BufferDataProvider<?> dataProvider)
	{
		super(FEATURES.values().length);

		assert dataProvider != null;

		this.dataProvider = dataProvider;
		usage = computeUsage(dataProvider);

		accessBeforePush = VkModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforePush());
		accessBeforeFetch = VkModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforeFetch());
	}

	private static int computeUsage(BufferDataProvider<?> dataProvider)
	{
		final int usage = dataProvider.getUsage().getValue();
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
	}

	@Override
	public void free(IExecutionContext context)
	{}

	public void updateAlignement(long desiredOffset)
	{
		final long oldSize = this.instanceSize;
		final long oldOffset = this.offset;

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		final long size = (long) (adapter.requestedSize() * dataProvider.getGrowFactor());

		this.instanceSize = align(size, alignment);
		this.offset = align(desiredOffset, alignment);

		if (oldSize != this.instanceSize)
		{
			fireNotification(new LongNotification(this, FEATURES.SIZE, oldSize, this.instanceSize));
		}
		if (oldOffset != this.offset)
		{
			fireNotification(new LongNotification(this, FEATURES.OFFSET, oldOffset, this.offset));
		}
	}

	public void updateBuffer(long bufferPtr)
	{
		assert bufferPtr != 0;
		final long oldBufferPtr = this.bufferPtr;
		this.bufferPtr = bufferPtr;

		if (oldBufferPtr != bufferPtr)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.BUFFER_PTR,
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
		transferBuffer.releaseTicket(memTicket);
	}

	public void pushProvidedData(int instance)
	{
		assert instance < dataProvider.getInstanceCount();
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		adapter.fill(memTicket.toBuffer());
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

	public void fetchDeviceData(int instance)
	{
		assert instance < dataProvider.getInstanceCount();
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

	public boolean sizeChanged()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return (instanceSize * dataProvider.getGrowThreshold()) < adapter.requestedSize();
	}

	@Override
	public long getInstanceSize()
	{
		return instanceSize;
	}

	public long getTotalSize()
	{
		return instanceSize * dataProvider.getInstanceCount();
	}

	@Override
	public long getInstanceOffset(int instance)
	{
		return offset + (instance * instanceSize);
	}

	@Override
	public long getBufferPtr()
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
}
