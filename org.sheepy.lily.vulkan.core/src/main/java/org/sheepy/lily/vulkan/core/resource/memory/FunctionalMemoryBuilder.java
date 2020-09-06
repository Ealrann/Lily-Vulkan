package org.sheepy.lily.vulkan.core.resource.memory;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.memory.builder.AlignmentBuilder;
import org.sheepy.lily.vulkan.core.resource.memory.builder.MemoryRequirementsBuilder;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.*;

public final class FunctionalMemoryBuilder
{
	private static final String ALLOC_ERROR = "Failed to allocate buffer";

	public final int properties;

	public FunctionalMemoryBuilder(final int properties)
	{
		this.properties = properties;
	}

	public Memory buildMemory(final IVulkanContext context,
							  final Stream<? extends IVulkanResourcePointer> resourcePointers)
	{
		final var memReqBuilder = new MemoryRequirementsBuilder(context);
		final var memReq = memReqBuilder.build(resourcePointers);
		final var alignmentBuilder = new AlignmentBuilder(memReq);
		final var alignedResources = alignmentBuilder.build();
		final var vkDevice = context.getVkDevice();
		final long ptr = allocateMemory(context, vkDevice, memReq.memoryTypeBits(), alignedResources.size());
		alignedResources.bindResources(vkDevice, ptr);
		return new Memory(ptr);
	}

	private long allocateMemory(final IVulkanContext context,
								final VkDevice vkDevice,
								final int memoryTypeBits,
								final long size)
	{
		final var allocInfo = allocateInfo(context, memoryTypeBits, size);
		final long[] aMemoryId = new long[1];
		Logger.check(ALLOC_ERROR, () -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
		return aMemoryId[0];
	}

	private VkMemoryAllocateInfo allocateInfo(final IVulkanContext context, int memoryTypeBits, long size)
	{
		final var physicalDevice = context.getPhysicalDevice();
		final var findMemoryType = physicalDevice.findMemoryType(memoryTypeBits, properties);
		final var allocInfo = VkMemoryAllocateInfo.callocStack(context.stack());
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
		allocInfo.allocationSize(size);
		allocInfo.memoryTypeIndex(findMemoryType);
		return allocInfo;
	}
}
