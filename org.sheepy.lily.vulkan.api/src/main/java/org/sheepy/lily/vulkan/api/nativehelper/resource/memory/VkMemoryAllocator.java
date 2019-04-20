package org.sheepy.lily.vulkan.api.nativehelper.resource.memory;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.api.util.Logger;

public abstract class VkMemoryAllocator
{
	protected final MemoryAllocationInfo allocationInfo;

	public static MemoryInfo allocateFromBuffer(MemoryStack stack,
												MemoryAllocationInfo allocationInfo)
	{
		final var allocator = new VkBufferMemoryAllocator(allocationInfo);
		return allocator.allocate(stack);
	}

	public static MemoryInfo allocateFromImage(	MemoryStack stack,
												MemoryAllocationInfo allocationInfo)
	{
		final var allocator = new VkImageMemoryAllocator(allocationInfo);
		return allocator.allocate(stack);
	}

	public VkMemoryAllocator(MemoryAllocationInfo allocationInfo)
	{
		this.allocationInfo = allocationInfo;
	}

	public MemoryInfo allocate(MemoryStack stack)
	{
		final var memRequirements = allocateMemoryRequirements(stack);
		final var allocInfo = allocateInfo(stack, memRequirements);
		final var id = allocate(allocInfo);

		return new MemoryInfo(id, memRequirements.size());
	}

	private VkMemoryAllocateInfo allocateInfo(	MemoryStack stack,
												VkMemoryRequirements memRequirements)
	{
		final var physicalDevice = allocationInfo.logicalDevice.getPhysicalDevice();
		final var memoryTypeBits = memRequirements.memoryTypeBits();
		final var properties = allocationInfo.properties;
		final var findMemoryType = physicalDevice.findMemoryType(memoryTypeBits, properties);

		final VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
		allocInfo.allocationSize(memRequirements.size());
		allocInfo.memoryTypeIndex(findMemoryType);

		return allocInfo;
	}

	private long allocate(VkMemoryAllocateInfo allocInfo) throws AssertionError
	{
		final var vkDevice = allocationInfo.logicalDevice.getVkDevice();
		final long[] aMemoryId = new long[1];
		Logger.check("Failed to allocate buffer",
				() -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
		return aMemoryId[0];
	}

	public static class MemoryAllocationInfo
	{
		public final ILogicalDevice logicalDevice;
		public final long bufferId;
		public final int properties;

		public MemoryAllocationInfo(ILogicalDevice logicalDevice, long bufferId, int properties)
		{
			this.logicalDevice = logicalDevice;
			this.bufferId = bufferId;
			this.properties = properties;
		}
	}

	public static class MemoryInfo
	{
		public final long id;
		public final long size;

		private MemoryInfo(long id, long size)
		{
			this.id = id;
			this.size = size;
		}
	}

	protected abstract VkMemoryRequirements allocateMemoryRequirements(MemoryStack stack);

	private static class VkBufferMemoryAllocator extends VkMemoryAllocator
	{
		protected VkBufferMemoryAllocator(MemoryAllocationInfo allocationInfo)
		{
			super(allocationInfo);
		}

		@Override
		protected VkMemoryRequirements allocateMemoryRequirements(MemoryStack stack)
		{
			final var vkDevice = allocationInfo.logicalDevice.getVkDevice();
			final var bufferId = allocationInfo.bufferId;
			final var memRequirements = VkMemoryRequirements.callocStack(stack);

			vkGetBufferMemoryRequirements(vkDevice, bufferId, memRequirements);
			return memRequirements;
		}
	}

	private static class VkImageMemoryAllocator extends VkMemoryAllocator
	{
		protected VkImageMemoryAllocator(MemoryAllocationInfo allocationInfo)
		{
			super(allocationInfo);
		}

		@Override
		protected VkMemoryRequirements allocateMemoryRequirements(MemoryStack stack)
		{
			final var vkDevice = allocationInfo.logicalDevice.getVkDevice();
			final var imageAddress = allocationInfo.bufferId;
			final var memRequirements = VkMemoryRequirements.callocStack(stack);

			vkGetImageMemoryRequirements(vkDevice, imageAddress, memRequirements);
			return memRequirements;
		}
	}
}
