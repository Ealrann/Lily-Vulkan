package org.sheepy.lily.vulkan.resource.buffer.provider;

import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.notification.LongNotification;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.VkBufferDescriptor;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket.EReservationStatus;

@Statefull
@Adapter(scope = BufferDataProvider.class, scopeInheritance = true)
public class DataProviderWrapper extends NotifierAdapter
		implements IAllocableAdapter<IExecutionContext>
{
	public static enum FEATURES
	{
		SIZE,
		OFFSET,
		BUFFER_PTR
	};

	public final BufferDataProvider<?> dataProvider;

	private final int usage;
	private final IBufferDataProviderAdapter adapter;
	private final EAccess access;
	private final EPipelineStage stage;
	private final VkBufferDescriptor descriptor;

	private long alignment;

	private long bufferPtr;
	private long alignedOffset;
	private long alignedSize;

	private boolean needPush = true;
	private MemoryTicket memTicket;
	private ITransferBuffer transferBuffer;

	private long providedSize = 0;

	public DataProviderWrapper(BufferDataProvider<?> dataProvider)
	{
		super(FEATURES.values().length);
		this.dataProvider = dataProvider;
		this.adapter = dataProvider.adapt(IBufferDataProviderAdapter.class);
		usage = dataProvider.getUsage().getValue();

		access = guessAccessFromUsage(usage);
		stage = guessStageFromUsage(usage);
		descriptor = createDescriptor(dataProvider);
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
		final long oldSize = this.alignedSize;
		final long oldOffset = this.alignedOffset;

		providedSize = adapter.getSize();
		this.alignedSize = align(providedSize, alignment);
		this.alignedOffset = align(desiredOffset, alignment);

		if (descriptor != null)
		{
			descriptor.updateSize(getSize());
			descriptor.updateOffset(getOffset());
		}

		if (oldSize != this.alignedSize)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.SIZE.ordinal(),
													oldSize,
													this.alignedSize));
		}
		if (oldOffset != this.alignedOffset)
		{
			fireNotification(new LongNotification(	this,
													FEATURES.OFFSET.ordinal(),
													oldOffset,
													this.alignedOffset));
		}
	}

	public void updateBuffer(long bufferPtr)
	{
		final long oldBufferPtr = this.bufferPtr;
		this.bufferPtr = bufferPtr;

		if (descriptor != null)
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
		return (needPush || adapter.hasChanged()) && adapter.getSize() > 0;
	}

	public boolean reserveMemory(ITransferBuffer stagingBuffer)
	{
		this.transferBuffer = stagingBuffer;
		memTicket = stagingBuffer.reserveMemory(alignedSize);

		return memTicket.getReservationStatus() == EReservationStatus.SUCCESS;
	}

	public void releaseMemory()
	{
		transferBuffer.releaseTicket(memTicket);
	}

	public void pushProvidedData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);
		adapter.fill(memTicket.getMemoryPtr());

		final var pushCommand = IDataFlowCommand.newPipelinePushCommand(memTicket,
																		bufferPtr,
																		alignedOffset,
																		stage,
																		access);

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

	public void fetchDeviceData()
	{
		assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

		final Consumer<MemoryTicket> transferDone = ticket -> adapter.fetch(memTicket.getMemoryPtr());

		final var pushCommand = IDataFlowCommand.newPipelineFetchCommand(	memTicket,
																			bufferPtr,
																			alignedOffset,
																			transferDone);

		transferBuffer.addTransferCommand(pushCommand);
	}

	public boolean hasChanged()
	{
		return providedSize != adapter.getSize();
	}

	public long getSize()
	{
		return alignedSize;
	}

	public long getOffset()
	{
		return alignedOffset;
	}

	public IVkDescriptor getDescriptor()
	{
		return descriptor;
	}

	public long getBufferPtr()
	{
		return bufferPtr;
	}

	private static long align(long index, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) index) / alignment);
		return chunkCount * alignment;
	}

	private static EPipelineStage guessStageFromUsage(int usage)
	{
		EPipelineStage res = null;
		switch (usage)
		{
		case EBufferUsage.VERTEX_BUFFER_BIT_VALUE:
			res = EPipelineStage.VERTEX_INPUT_BIT;
			break;
		case EBufferUsage.INDEX_BUFFER_BIT_VALUE:
			res = EPipelineStage.VERTEX_INPUT_BIT;
			break;
		case EBufferUsage.UNIFORM_BUFFER_BIT_VALUE:
			res = EPipelineStage.VERTEX_SHADER_BIT;
			break;
		case EBufferUsage.TRANSFER_SRC_BIT_VALUE:
			res = EPipelineStage.TRANSFER_BIT;
			break;
		}

		return res;
	}

	private static EAccess guessAccessFromUsage(int usage)
	{
		EAccess res = null;
		switch (usage)
		{
		case EBufferUsage.VERTEX_BUFFER_BIT_VALUE:
			res = EAccess.VERTEX_ATTRIBUTE_READ_BIT;
			break;
		case EBufferUsage.INDEX_BUFFER_BIT_VALUE:
			res = EAccess.VERTEX_ATTRIBUTE_READ_BIT;
			break;
		case EBufferUsage.UNIFORM_BUFFER_BIT_VALUE:
			res = EAccess.UNIFORM_READ_BIT;
			break;
		case EBufferUsage.TRANSFER_SRC_BIT_VALUE:
			res = EAccess.TRANSFER_READ_BIT;
			break;
		}

		return res;
	}

	private static final VkBufferDescriptor createDescriptor(BufferDataProvider<?> dataProvider)
	{
		if (dataProvider instanceof DescribedDataProvider<?>)
		{
			final var described = (DescribedDataProvider<?>) dataProvider;
			final var descriptor = described.getDescriptor();

			assert descriptor != null;

			final var type = descriptor.getDescriptorType();
			final var stages = descriptor.getShaderStages();

			return new VkBufferDescriptor(0, 0, 0, type, stages);
		}
		else
		{
			return null;
		}
	}
}
