package org.sheepy.vulkan.resource.memory;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.resource.memory.MemoryChunk.MemoryConsumer;

public final class MemoryChunkBuilder
{
	public final IVulkanContext context;
	public final int properties;
	private final MemoryRequirements memReq;
	private final List<MemoryConsumer> consumers = new ArrayList<>();

	public MemoryChunkBuilder(IVulkanContext context, int properties)
	{
		this.context = context;
		this.properties = properties;
		this.memReq = new MemoryRequirements(context);
	}

	public void registerImage(long imagePtr, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		final long initialSize = memReq.size;
		memReq.updateRequirementsFromImage(imagePtr);
		addConsumer(memReq.size - initialSize, whenMemoryIsAllocated);
	}

	public void registerBuffer(long bufferPtr, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		final long initialSize = memReq.size;
		memReq.updateRequirementsFromBuffer(bufferPtr);
		addConsumer(memReq.size - initialSize, whenMemoryIsAllocated);
	}

	private void addConsumer(long offset, MemoryAllocationCallback whenMemoryIsAllocated)
	{
		consumers.add(new MemoryConsumer(offset, whenMemoryIsAllocated));
	}

	public MemoryChunk build()
	{
		final var allocInfo = allocateInfo(context.stack());
		return new MemoryChunk(allocInfo, consumers);
	}

	private VkMemoryAllocateInfo allocateInfo(MemoryStack stack)
	{
		final var physicalDevice = context.getPhysicalDevice();
		final var memoryTypeBits = memReq.memoryTypeBits;
		final var findMemoryType = physicalDevice.findMemoryType(memoryTypeBits, properties);

		final VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);

		allocInfo.allocationSize(memReq.size);
		allocInfo.memoryTypeIndex(findMemoryType);

		return allocInfo;
	}

	private static final class MemoryRequirements
	{
		private final VkDevice device;
		private final VkMemoryRequirements requirementBuffer;

		private long size = 0;
		private int memoryTypeBits = 0;

		public MemoryRequirements(IVulkanContext context)
		{
			final var stack = context.stack();
			requirementBuffer = VkMemoryRequirements.mallocStack(stack);
			this.device = context.getVkDevice();
		}

		public void updateRequirementsFromImage(long imagePtr)
		{
			vkGetImageMemoryRequirements(device, imagePtr, requirementBuffer);
			updateRequirements();
		}

		public void updateRequirementsFromBuffer(long bufferPtr)
		{
			vkGetBufferMemoryRequirements(device, bufferPtr, requirementBuffer);
			updateRequirements();
		}

		private void updateRequirements()
		{
			this.size += requirementBuffer.size();
			this.memoryTypeBits |= requirementBuffer.memoryTypeBits();
		}
	}

	@FunctionalInterface
	public interface MemoryAllocationCallback
	{
		void finalize(long memoryPtr, long offset, long size);
	}
}
