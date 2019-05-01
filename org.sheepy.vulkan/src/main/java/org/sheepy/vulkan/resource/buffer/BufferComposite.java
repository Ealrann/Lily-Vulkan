package org.sheepy.vulkan.resource.buffer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.DescriptorUtil;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.descriptor.VkDescriptor;
import org.sheepy.vulkan.descriptor.VkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class BufferComposite implements IAllocable
{
	private final Map<IBufferDataProvider, DataProviderWrapper> providerWrappers = new LinkedHashMap<>();
	private final VkDescriptorSet descriptorSet = new VkDescriptorSet();

	private IBufferBackend bufferBackend;
	private boolean hasChanged = true;
	private boolean needUpdate = true;

	public BufferComposite(List<IBufferDataProvider> dataProviders)
	{
		for (final var dataProvider : dataProviders)
		{
			this.providerWrappers.put(dataProvider, new DataProviderWrapper(dataProvider));
		}
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var vContext = (IVulkanContext) context;
		final var physicalDevice = vContext.getPhysicalDevice();

		int usage = EBufferUsage.TRANSFER_DST_BIT_VALUE;
		long position = 0;
		for (final var providerWrapper : providerWrappers.values())
		{
			providerWrapper.updateAlignement(physicalDevice, position);
			position = providerWrapper.alignedOffset + providerWrapper.alignedSize;

			usage |= providerWrapper.dataProvider.getUsage();
		}

		createBuffer(position, usage);
		bufferBackend.allocate(stack, context);

		for (final var providerWrapper : providerWrappers.values())
		{
			if (providerWrapper.dataProvider instanceof IDescriptedDataProvider)
			{
				final var descriptor = providerWrapper.createDescriptor();
				descriptorSet.addDescriptor(descriptor);
			}
		}
	}

	private void createBuffer(long size, int usage)
	{
		final BufferInfo info = new BufferInfo(size, usage, false);
		bufferBackend = new GPUBufferBackend(info, false);
	}

	@Override
	public void free(IAllocationContext context)
	{
		bufferBackend.free(context);
	}

	public void update(IStagingBuffer stagingBuffer)
	{
		hasChanged = false;

		for (final var providerWrapper : providerWrappers.values())
		{
			final var dataProvider = providerWrapper.dataProvider;
			final boolean providerChanged = dataProvider.hasChanged();
			if (providerChanged || needUpdate)
			{
				final long memAddress = stagingBuffer.reserveMemory(dataProvider.getSize());
				final long bufferAddress = bufferBackend.getAddress();
				final long offset = providerWrapper.alignedOffset;
				final int usage = dataProvider.getUsage();

				final EPipelineStage stage = guessStageFromUsage(usage);
				final EAccess access = guessAccessFromUsage(usage);

				dataProvider.fill(memAddress);
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
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public IVkDescriptorSet getDescriptorSet()
	{
		return descriptorSet;
	}

	public long getBufferAddress()
	{
		return bufferBackend.getAddress();
	}

	public long getOffset(IBufferDataProvider dataProvider)
	{
		return providerWrappers.get(dataProvider).alignedOffset;
	}

	class DataProviderWrapper
	{
		private final int usage;
		final IBufferDataProvider dataProvider;

		long alignedOffset;
		long alignedSize;

		DataProviderWrapper(IBufferDataProvider dataProvider)
		{
			this.dataProvider = dataProvider;
			usage = dataProvider.getUsage();
		}

		public IVkDescriptor createDescriptor()
		{
			final var descripted = (IDescriptedDataProvider) dataProvider;

			final var type = DescriptorUtil.guessType(usage);
			final var stages = descripted.getStages();

			return new VkDescriptor(bufferBackend, alignedSize, alignedOffset, type, stages);
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
