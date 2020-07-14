package org.sheepy.lily.vulkan.core.resource.memory;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.AlignmentUtil;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class MemoryBuilder
{
	private static final String ALLOC_ERROR = "Failed to allocate buffer";

	public final ExecutionContext context;
	public final int properties;
	private final MemoryRequirements memReq;
	private final List<MemoryConsumer> consumers = new ArrayList<>();

	public MemoryBuilder(ExecutionContext context, int properties)
	{
		this.context = context;
		this.properties = properties;
		this.memReq = new MemoryRequirements(context);
	}

	public void registerImage(long imagePtr, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		final long size = memReq.updateRequirementsFromImage(imagePtr);
		addConsumer(size, whenMemoryIsAllocated);
	}

	public void registerBuffer(long bufferPtr, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		final long size = memReq.updateRequirementsFromBuffer(bufferPtr);
		addConsumer(size, whenMemoryIsAllocated);
	}

	private void addConsumer(long size, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		consumers.add(new MemoryConsumer(size, whenMemoryIsAllocated));
	}

	public Memory build(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		final var alignedMemoryBuilder = new AlignedMemoryBuilder(consumers, memReq);
		final long ptr = allocateMemory(context, vkDevice, alignedMemoryBuilder.size);
		alignedMemoryBuilder.notifyConsumers(vkDevice, ptr);
		return new Memory(ptr);
	}

	private long allocateMemory(final ExecutionContext context, final VkDevice vkDevice, final long size)
	{
		final var allocInfo = allocateInfo(context.stack(), size);
		final long[] aMemoryId = new long[1];
		Logger.check(ALLOC_ERROR, () -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
		return aMemoryId[0];
	}

	private VkMemoryAllocateInfo allocateInfo(MemoryStack stack, long size)
	{
		final var physicalDevice = context.getPhysicalDevice();
		final var memoryTypeBits = memReq.memoryTypeBits;
		final var findMemoryType = physicalDevice.findMemoryType(memoryTypeBits, properties);

		final VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);

		allocInfo.allocationSize(size);
		allocInfo.memoryTypeIndex(findMemoryType);

		return allocInfo;
	}

	private static final class AlignedMemoryBuilder
	{
		public final long size;
		public final List<MemoryConsumer> alignedConsumers;

		public AlignedMemoryBuilder(List<MemoryConsumer> consumers, MemoryRequirements memReq)
		{
			final List<MemoryConsumer> alignedConsumers = new ArrayList<>(consumers.size());
			long position = 0;
			for (int i = 0; i < consumers.size(); i++)
			{
				final long initialPosition = position;
				final var memoryConsumer = consumers.get(i);
				position += memoryConsumer.size;
				position = AlignmentUtil.align(position, memReq.alignement);

				final long alignedSize = position - initialPosition;
				alignedConsumers.add(new MemoryConsumer(alignedSize, memoryConsumer.callBack));
			}
			this.size = position;
			this.alignedConsumers = List.copyOf(alignedConsumers);
		}

		public void notifyConsumers(final VkDevice vkDevice, final long ptr)
		{
			long offset = 0;
			for (int i = 0; i < alignedConsumers.size(); i++)
			{
				final var memoryConsumer = alignedConsumers.get(i);
				final var size = memoryConsumer.size;

				memoryConsumer.callBack.finalize(vkDevice, ptr, offset, size);
				offset += size;
			}
		}
	}

	private static final class MemoryRequirements
	{
		private final VkDevice device;
		private final VkMemoryRequirements requirementBuffer;

		private int memoryTypeBits = 0;
		private long alignement = 1;

		public MemoryRequirements(ExecutionContext context)
		{
			final var stack = context.stack();
			requirementBuffer = VkMemoryRequirements.mallocStack(stack);
			this.device = context.getVkDevice();
		}

		public long updateRequirementsFromImage(long imagePtr)
		{
			vkGetImageMemoryRequirements(device, imagePtr, requirementBuffer);
			updateRequirements();
			return requirementBuffer.size();
		}

		public long updateRequirementsFromBuffer(long bufferPtr)
		{
			vkGetBufferMemoryRequirements(device, bufferPtr, requirementBuffer);
			updateRequirements();
			return requirementBuffer.size();
		}

		private void updateRequirements()
		{
			this.alignement = AlignmentUtil.leastCommonMultiple(alignement, requirementBuffer.alignment());
			this.memoryTypeBits |= requirementBuffer.memoryTypeBits();
		}
	}

	@FunctionalInterface
	public interface MemoryAllocationCallback
	{
		void finalize(VkDevice vkDevice, long memoryPtr, long offset, long size);
	}
}
