package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.resource.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
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
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;

@Statefull
@Adapter(scope = CompositeBuffer.class)
public final class CompositeBufferAdapter implements ICompositeBufferAdapter
{
	private final List<DataProviderWrapper> providerWrappers;
	private final List<IVkDescriptor> descriptors = new ArrayList<>();

	private IBufferBackend bufferBackend;
	private final boolean hasChanged = true;
	private boolean needUpdate = true;

	public CompositeBufferAdapter(CompositeBuffer compositeBuffer)
	{
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
				final var descriptor = providerWrapper.createDescriptor();
				descriptors.add(descriptor);
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
		bufferBackend.free(context);
	}

	public void update(IStagingBuffer stagingBuffer)
	{
		
		getPushBuffer
		
		hasChanged = false;

		for (final var providerWrapper : providerWrappers)
		{
			final var dataProvider = providerWrapper.dataProvider;
			final boolean providerChanged = providerWrapper.adapter.hasChanged();
			if (providerChanged || needUpdate)
			{
				final long memAddress = stagingBuffer.reserveMemory(dataProvider.getSize());
				final long bufferAddress = bufferBackend.getAddress();
				final long offset = providerWrapper.alignedOffset;
				final int usage = dataProvider.getUsage().getValue();

				final EPipelineStage stage = guessStageFromUsage(usage);
				final EAccess access = guessAccessFromUsage(usage);

				providerWrapper.adapter.fill(memAddress);
				stagingBuffer.pushSynchronized(memAddress, bufferAddress, offset, stage, access);

				hasChanged = true;
			}
		}

		needUpdate = false;
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

	public boolean hasChanged()
	{
		return hasChanged;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		return descriptors;
	}

	public long getBufferAddress()
	{
		return bufferBackend.getAddress();
	}

	class DataProviderWrapper
	{
		private final int usage;
		private final BufferDataProvider dataProvider;
		private final IBufferDataProviderAdapter adapter;

		private long alignedOffset;
		private long alignedSize;

		private DataProviderWrapper(BufferDataProvider dataProvider)
		{
			this.dataProvider = dataProvider;
			this.adapter = IBufferDataProviderAdapter.adapt(dataProvider);
			usage = dataProvider.getUsage().getValue();
		}

		public IVkDescriptor createDescriptor()
		{
			final var described = (DescribedDataProvider) dataProvider;
			final long bufferPtr = bufferBackend.getAddress();

			final var type = described.getDescriptorType();
			final var stages = described.getShaderStages();

			return new VkBufferDescriptor(bufferPtr, alignedSize, alignedOffset, type, stages);
		}

		public void updateAlignement(PhysicalDevice physicalDevice, long desiredOffset)
		{
			final long size = dataProvider.getSize();
			final long alignment = physicalDevice.getBufferAlignement(usage);

			this.alignedOffset = align(desiredOffset, alignment);
			this.alignedSize = align(size, alignment);
		}

		private long align(long index, long alignment)
		{
			final int chunkCount = (int) Math.ceil(((double) index) / alignment);
			return chunkCount * alignment;
		}
	}
}
