package org.sheepy.lily.vulkan.resource.buffer.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.notification.LongNotification;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.common.resource.IDataProviderAlignmentAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.VkBufferDescriptor;
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
	private final List<VkBufferDescriptor> descriptors;
	private final INotificationListener firstDescriptorListener = n -> updateDescriptors();
	private final int accessBeforePush;

	private long alignment;

	private long bufferPtr;
	private long offset;
	private long instanceSize;

	private boolean needPush = true;
	private MemoryTicket memTicket;
	private ITransferBuffer transferBuffer;

	private long providedSize = 0;

	public DataProviderWrapper(BufferDataProvider<?> dataProvider)
	{
		super(FEATURES.values().length);
		this.dataProvider = dataProvider;
		usage = computeUsage(dataProvider);

		accessBeforePush = VkModelUtil.getEnumeratedFlag(dataProvider.getAccessBeforePush());

		// access = guessAccessFromUsage(usage);
		// stage = guessStageFromUsage(usage);
		descriptors = createDescriptors(dataProvider);
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

	@Load
	public void load()
	{
		dataProvider.addListener(	firstDescriptorListener,
									ResourcePackage.BUFFER_DATA_PROVIDER__FIRST_DESCRIPTOR);
	}

	@Dispose
	public void dispose()
	{
		dataProvider.removeListener(firstDescriptorListener,
									ResourcePackage.BUFFER_DATA_PROVIDER__FIRST_DESCRIPTOR);
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
		providedSize = adapter.getSize();
		this.instanceSize = align(providedSize, alignment);
		this.offset = align(desiredOffset, alignment);

		updateDescriptors();

		if (oldSize != this.instanceSize)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.SIZE.ordinal(),
													oldSize,
													this.instanceSize));
		}
		if (oldOffset != this.offset)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.OFFSET.ordinal(),
													oldOffset,
													this.offset));
		}
	}

	private void updateDescriptors()
	{
		long currentOffset = offset;
		final var instanceCount = dataProvider.getInstanceCount();
		final int firstDescriptor = dataProvider.getFirstDescriptor();
		final int end = firstDescriptor + descriptors.size();
		for (int i = firstDescriptor; i < end; i++)
		{
			final int index = i % instanceCount;
			final var descriptor = descriptors.get(index);
			descriptor.updateSize(instanceSize);
			descriptor.updateOffset(currentOffset);
			currentOffset += instanceSize;
		}
	}

	public void updateBuffer(long bufferPtr)
	{
		final long oldBufferPtr = this.bufferPtr;
		this.bufferPtr = bufferPtr;

		for (final var descriptor : descriptors)
		{
			descriptor.updateBufferPtr(bufferPtr);
		}

		if (oldBufferPtr != bufferPtr)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.BUFFER_PTR.ordinal(),
													oldBufferPtr,
													this.bufferPtr));
		}
	}

	public boolean needPush()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return (needPush || adapter.hasChanged()) && providedSize > 0;
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

	public void pushProvidedData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		adapter.fill(memTicket.getMemoryPtr(), (int) memTicket.getSize());
		final long instanceOffset = getCurrentOffset();
		final var stage = dataProvider.getStageBeforePush();

		final var pushCommand = IDataFlowCommand.newPipelinePushCommand(memTicket,
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

	private long getCurrentOffset()
	{
		return offset + (instanceSize * dataProvider.getInstance());
	}

	public void fetchDeviceData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		final Consumer<MemoryTicket> transferDone = ticket -> adapter.fetch(memTicket.getMemoryPtr(),
																			(int) memTicket.getSize());
		final long instanceOffset = getCurrentOffset();

		final var pushCommand = IDataFlowCommand.newPipelineFetchCommand(	memTicket,
																			bufferPtr,
																			instanceOffset,
																			transferDone);

		transferBuffer.addTransferCommand(pushCommand);
	}

	public boolean hasChanged()
	{
		final var adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		return providedSize != adapter.getSize();
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

	public List<? extends IVkDescriptor> getDescriptors()
	{
		return descriptors;
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

	private static List<VkBufferDescriptor> createDescriptors(BufferDataProvider<?> dataProvider)
	{
		if (dataProvider instanceof DescribedDataProvider<?>)
		{
			final var described = (DescribedDataProvider<?>) dataProvider;
			final var descriptor = described.getDescriptor();
			final var type = descriptor.getDescriptorType();
			final var stages = descriptor.getShaderStages();

			assert descriptor != null;

			final List<VkBufferDescriptor> res = new ArrayList<>();
			for (int i = 0; i < dataProvider.getInstanceCount(); i++)
			{
				res.add(new VkBufferDescriptor(0, 0, 0, type, stages));
			}
			return List.copyOf(res);
		}
		else
		{
			return List.of();
		}
	}

	public int getUsage()
	{
		return usage;
	}
}
