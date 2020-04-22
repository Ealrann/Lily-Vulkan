package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter.IMemoryTicket;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter.IMemoryTicket.EReservationStatus;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferPartAdapter;
import org.sheepy.lily.vulkan.core.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

@Statefull
@Adapter(scope = BufferPart.class)
public final class BufferPartAdapter extends Notifier<IBufferAdapter.Features> implements IBufferPartAdapter,
																						  IAllocableAdapter<ExecutionContext>
{
	public final BufferDataProvider dataProvider;

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
	private TransferBufferAdapter transferBuffer;

	private BufferPartAdapter(BufferPart bufferPart)
	{
		super(List.of(Features.Size, Features.Offset, Features.Ptr));

		assert bufferPart.getDataProvider() != null;

		this.dataProvider = bufferPart.getDataProvider();
		usage = computeUsage(dataProvider);

		accessBeforePush = VulkanModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforePush());
		accessBeforeFetch = VulkanModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforeFetch());
	}

	private static int computeUsage(BufferDataProvider dataProvider)
	{
		final int usage = VulkanModelUtil.getEnumeratedFlag(dataProvider.getUsages());
		final int pushUsage = dataProvider.isUsedToPush() ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
		final int fetchUsage = dataProvider.isUsedToFetch() ? EBufferUsage.TRANSFER_SRC_BIT_VALUE : 0;

		return usage | pushUsage | fetchUsage;
	}

	@Override
	public void allocate(ExecutionContext context)
	{
		final var physicalDevice = context.getPhysicalDevice();

		final var eInstanceCount = dataProvider.getInstanceCount();
		instanceCount = InstanceCountUtil.getInstanceCount(context, eInstanceCount);
		instance = 0;
		firstPush = true;

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		alignment = Math.max(adapter.minAlignment(), physicalDevice.getBufferAlignement(usage));
	}

	@Override
	public void free(ExecutionContext context)
	{
	}

	public void updateAlignement(long desiredOffset)
	{
		final long oldSize = this.instanceSize;
		final long oldOffset = this.offset;
		final long size = computeSize();

		this.instanceSize = align(size, alignment);
		this.offset = align(desiredOffset, alignment);

		if (oldSize != this.instanceSize)
		{
			notify(Features.Size, this.instanceSize);
		}
		if (oldOffset != this.offset)
		{
			notify(Features.Offset, this.offset);
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
			notify(Features.Ptr, this.bufferPtr);
		}
	}

	public boolean needPush()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return (needPush || adapter.hasChanged()) && instanceSize > 0;
	}

	public boolean reserveMemory(TransferBufferAdapter transferBuffer)
	{
		this.transferBuffer = transferBuffer;
		memTicket = (MemoryTicket) transferBuffer.reserveMemory(instanceSize);

		return memTicket.getReservationStatus() == EReservationStatus.SUCCESS;
	}

	public void releaseMemory()
	{
		if (memTicket.getReservationStatus() == EReservationStatus.SUCCESS ||
			memTicket.getReservationStatus() == EReservationStatus.FLUSHED)
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

		final var pushCommand = DataFlowCommandFactory.newPushCommand(memTicket,
																	  bufferPtr,
																	  instanceOffset,
																	  stage,
																	  accessBeforePush);

//		System.out.println(String.format("[%s] record push %d bytes",
//										 dataProvider.eClass().getName(),
//										 memTicket.getSize()));
//		System.out.println(String.format("\tfrom buffer %d, offset %d",
//										 memTicket.getBufferPtr(),
//										 memTicket.getBufferOffset()));
//		System.out.println(String.format("\tto buffer %d, offset %d", bufferPtr, instanceOffset));

		transferBuffer.addTransferCommand(pushCommand);

		needPush = false;
	}

	private void nextInstance()
	{
		instance = (instance + 1) % instanceCount;
		notify(Features.Offset, getBindOffset());
	}

	public void fetchDeviceData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final Consumer<IMemoryTicket> transferDone = ticket -> dataProvider.adapt(IBufferDataProviderAdapter.class)
																		   .fetch(memTicket.toReadBuffer());

		final long instanceOffset = getInstanceOffset(instance);
		final var stage = dataProvider.getStageBeforeFetch();

		final var fetchCommand = DataFlowCommandFactory.newFetchCommand(memTicket,
																		bufferPtr,
																		instanceOffset,
																		stage,
																		accessBeforeFetch,
																		transferDone);

//		System.out.println(String.format("[%s] record fetch %d bytes",
//										 dataProvider.eClass().getName(),
//										 memTicket.getSize()));
//		System.out.println(String.format("\tfrom buffer %d, offset %d", bufferPtr, instanceOffset));
//		System.out.println(String.format("\tto buffer %d, offset %d",
//										 memTicket.getBufferPtr(),
//										 memTicket.getBufferOffset()));

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

	private static long align(long size, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) size) / alignment);
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
