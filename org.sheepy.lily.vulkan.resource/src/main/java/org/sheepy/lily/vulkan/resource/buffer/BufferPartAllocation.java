package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferPartAllocation;
import org.sheepy.lily.vulkan.core.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

@ModelExtender(scope = BufferPart.class)
@Allocation(context = ExecutionContext.class)
public final class BufferPartAllocation implements IBufferPartAllocation
{
	public final BufferDataProvider dataProvider;
	public final BufferPart bufferPart;

	private final IAllocationState allocationState;
	private final int usage;
	private final int accessBeforePush;
	private final int accessBeforeFetch;
	private final long alignment;
	private final int instanceCount;

	private long bufferPtr;
	private long offset;
	private long instanceSize;

	private int instance = 0;
	private boolean firstPush = true;

	private boolean needPush = true;
	private MemoryTicket memTicket;
	private TransferBufferAllocation transferBuffer;

	private BufferPartAllocation(BufferPart bufferPart,
								 ExecutionContext context,
								 IAllocationState allocationState,
								 IObservatoryBuilder observatory)
	{
		this.bufferPart = bufferPart;
		this.allocationState = allocationState;

		assert bufferPart.getDataProvider() != null;

		this.dataProvider = bufferPart.getDataProvider();
		usage = computeUsage(dataProvider);

		accessBeforePush = VulkanModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforePush());
		accessBeforeFetch = VulkanModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforeFetch());

		final var physicalDevice = context.getPhysicalDevice();

		final var eInstanceCount = dataProvider.getInstanceCount();
		instanceCount = InstanceCountUtil.getInstanceCount(bufferPart, eInstanceCount);

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		alignment = Math.max(adapter.minAlignment(), physicalDevice.getBufferAlignement(usage, true));

		observatory.explore(VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER)
				   .listenNoParam(this::sizeChanged, VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE);
	}

	private void sizeChanged()
	{
		if (needResize())
		{
			allocationState.setAllocationObsolete();
			if (DebugUtil.DEBUG_VERBOSE_ENABLED)
			{
				final var compositeBuffer = (CompositeBuffer) bufferPart.eContainer();
				System.out.println("Need resize of composite buffer " + compositeBuffer.getName());
			}
		}
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		//TODO
	}

	private static int computeUsage(BufferDataProvider dataProvider)
	{
		final int usage = VulkanModelUtil.getEnumeratedFlag(dataProvider.getUsages());
		final int pushUsage = dataProvider.isUsedToPush() ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
		final int fetchUsage = dataProvider.isUsedToFetch() ? EBufferUsage.TRANSFER_SRC_BIT_VALUE : 0;

		return usage | pushUsage | fetchUsage;
	}

	public void updateAlignement(long desiredOffset)
	{
		final long size = computeSize();
		this.instanceSize = align(size, alignment);
		this.offset = align(desiredOffset, alignment);
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
		this.bufferPtr = bufferPtr;
	}

	public boolean needPush()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return (needPush /**|| adapter.hasChanged()**/) && instanceSize > 0;
	}

	public boolean reserveMemory(TransferBufferAllocation transferBuffer)
	{
		this.transferBuffer = transferBuffer;
		memTicket = (MemoryTicket) transferBuffer.reserveMemory(instanceSize);

		return memTicket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS;
	}

	public void releaseMemory()
	{
		if (memTicket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS || memTicket.getReservationStatus() == IMemoryTicket.EReservationStatus.FLUSHED)
		{
			transferBuffer.releaseTicket(memTicket);
		}
	}

	public void pushProvidedData()
	{
		assert (memTicket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS);

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

		System.out.println(String.format("[%s] record push %d bytes",
										 dataProvider.eClass().getName(),
										 memTicket.getSize()));
		System.out.println(String.format("\tfrom buffer %d, offset %d",
										 memTicket.getBufferPtr(),
										 memTicket.getBufferOffset()));
		System.out.println(String.format("\tto buffer %d, offset %d", bufferPtr, instanceOffset));

		transferBuffer.addTransferCommand(pushCommand);

		needPush = false;
	}

	private void nextInstance()
	{
		instance = (instance + 1) % instanceCount;
	}

	public void fetchDeviceData()
	{
		assert (memTicket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS);

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

		System.out.println(String.format("[%s] record fetch %d bytes",
										 dataProvider.eClass().getName(),
										 memTicket.getSize()));
		System.out.println(String.format("\tfrom buffer %d, offset %d", bufferPtr, instanceOffset));
		System.out.println(String.format("\tto buffer %d, offset %d",
										 memTicket.getBufferPtr(),
										 memTicket.getBufferOffset()));

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
