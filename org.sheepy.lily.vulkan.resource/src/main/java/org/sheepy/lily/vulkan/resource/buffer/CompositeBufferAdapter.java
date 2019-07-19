package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IPushBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.VkBufferDescriptor;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.IBufferBackend;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.IStagingBuffer;
import org.sheepy.vulkan.resource.staging.IStagingBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.IStagingBuffer.MemoryTicket.EReservationStatus;

@Statefull
@Adapter(scope = CompositeBuffer.class)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final List<DataProviderWrapper> providerWrappers;
	private final List<IVkDescriptor> descriptors = new ArrayList<>();

	private final PushBuffer pushBuffer;

	private IBufferBackend bufferBackend;
	private boolean allocated = false;

	private final AdapterImpl pushBufferListener = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getFeature() == ResourcePackage.Literals.PUSH_BUFFER__BEING_UPDATED
					&& notification.getNewBooleanValue() == true)
			{
				update();
			}
		}
	};

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
		this.pushBuffer = compositeBuffer.getPushBuffer();

		final List<DataProviderWrapper> tmpList = new ArrayList<>();
		for (final var dataProvider : compositeBuffer.getDataProviders())
		{
			tmpList.add(new DataProviderWrapper(dataProvider));
		}

		this.providerWrappers = List.copyOf(tmpList);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var physicalDevice = context.getPhysicalDevice();

		int usage = EBufferUsage.TRANSFER_DST_BIT_VALUE;
		long position = 0;
		for (final var providerWrapper : providerWrappers)
		{
			providerWrapper.updateAlignement(physicalDevice, position);
			position = providerWrapper.alignedOffset + providerWrapper.alignedSize;

			usage |= providerWrapper.dataProvider.getUsage().getValue();
		}

		createBuffer(position, usage);
		bufferBackend.allocate(stack, context);

		for (final var providerWrapper : providerWrappers)
		{
			if (providerWrapper.dataProvider instanceof DescribedDataProvider)
			{
				final var descriptor = providerWrapper.createDescriptor(bufferBackend.getAddress());
				descriptors.add(descriptor);
			}
		}

		pushBuffer.eAdapters().add(pushBufferListener);

		allocated = true;
	}

	public void update()
	{
		final var pushBufferAdapter = IPushBufferAdapter.adapt(pushBuffer);
		final var stagingBuffer = pushBufferAdapter.getStagingBuffer();

		final List<DataProviderWrapper> providersToPush = new ArrayList<>();
		boolean reservationSuccessfull = true;

		for (final var providerWrapper : providerWrappers)
		{
			if (providerWrapper.needUpdate())
			{
				if (providerWrapper.reserveMemory(stagingBuffer) == false)
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
				providerWrapper.pushProvidedData();
			}
			else
			{
				providerWrapper.releaseMemory();
			}
		}
	}

	private void createBuffer(long size, int usage)
	{
		final BufferInfo info = new BufferInfo(size, usage, false);
		bufferBackend = new GPUBufferBackend(info, false);
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
		return providerWrappers.get(componentIndex).alignedSize;
	}

	@Override
	public long getOffset(int componentIndex)
	{
		return providerWrappers.get(componentIndex).alignedOffset;
	}

	@Override
	public void pushData(ByteBuffer data)
	{}

	@Override
	public void free(IExecutionContext context)
	{
		allocated = false;

		bufferBackend.free(context);

		pushBuffer.eAdapters().remove(pushBufferListener);
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
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

	private final class DataProviderWrapper
	{
		private final int usage;
		private final BufferDataProvider<?> dataProvider;
		private final IBufferDataProviderAdapter adapter;

		private final EAccess access;
		private final EPipelineStage stage;

		private long alignedOffset;
		private long alignedSize;

		private boolean needUpdate = true;
		private MemoryTicket memTicket;
		private IStagingBuffer stagingBuffer;

		private DataProviderWrapper(BufferDataProvider<?> dataProvider)
		{
			this.dataProvider = dataProvider;
			this.adapter = IBufferDataProviderAdapter.adapt(dataProvider);
			usage = dataProvider.getUsage().getValue();

			access = guessAccessFromUsage(usage);
			stage = guessStageFromUsage(usage);
		}

		public boolean needUpdate()
		{
			return needUpdate || adapter.hasChanged();
		}

		public boolean reserveMemory(IStagingBuffer stagingBuffer)
		{
			this.stagingBuffer = stagingBuffer;
			final long size = adapter.getSize();
			memTicket = stagingBuffer.reserveMemory(size);

			return memTicket.getReservationStatus() == EReservationStatus.SUCCESS;
		}

		public void releaseMemory()
		{
			stagingBuffer.releaseTicket(memTicket);
		}

		private void pushProvidedData()
		{
			assert (memTicket.getReservationStatus() == EReservationStatus.SUCCESS);

			final long bufferAddress = bufferBackend.getAddress();

			adapter.fill(memTicket.getMemoryPtr());

			final var pushCommand = IDataFlowCommand.newPipelinePushCommand(memTicket, bufferAddress, alignedOffset,
					stage, access);

			stagingBuffer.addStagingCommand(pushCommand);

			needUpdate = false;
		}

		public IVkDescriptor createDescriptor(long bufferPtr)
		{
			final var described = (DescribedDataProvider<?>) dataProvider;

			final var type = described.getDescriptorType();
			final var stages = described.getShaderStages();

			return new VkBufferDescriptor(bufferPtr, alignedSize, alignedOffset, type, stages);
		}

		public void updateAlignement(PhysicalDevice physicalDevice, long desiredOffset)
		{
			final long size = adapter.getSize();
			final long alignment = physicalDevice.getBufferAlignement(usage);

			this.alignedOffset = align(desiredOffset, alignment);
			this.alignedSize = align(size, alignment);
		}
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
		}

		return res;
	}
}
