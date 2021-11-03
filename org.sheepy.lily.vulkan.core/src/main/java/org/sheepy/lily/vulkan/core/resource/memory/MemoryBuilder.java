package org.sheepy.lily.vulkan.core.resource.memory;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.memory.builder.AlignmentBuilder;
import org.sheepy.lily.vulkan.core.resource.memory.builder.MemoryBinder;
import org.sheepy.lily.vulkan.core.resource.memory.builder.MemoryRequirementsBuilder;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO;
import static org.lwjgl.vulkan.VK10.vkAllocateMemory;

public final class MemoryBuilder
{
	private static final String ALLOC_ERROR = "Failed to allocate buffer";

	public final Memory.Info info;

	public MemoryBuilder(final Memory.Info info)
	{
		this.info = info;
	}

	public Memory build(final IVulkanContext context, final Stream<? extends IVulkanResourcePointer> resourcePointers)
	{
		final var allocationContext = prepare(context, resourcePointers);
		return allocationContext.allocateMemory(allocationContext);
	}

	public Memory buildDebug(final IVulkanContext context,
							 final Stream<? extends IVulkanResourcePointer> resourcePointers,
							 final Consumer<String> logger)
	{
		final var allocationContext = prepare(context, resourcePointers);
		allocationContext.verify(logger);
		return allocationContext.allocateMemory(allocationContext);
	}

	private MemoryAllocationContext prepare(final IVulkanContext context,
											final Stream<? extends IVulkanResourcePointer> resourcePointers)
	{
		final var memReqBuilder = new MemoryRequirementsBuilder(context);
		final var memReq = memReqBuilder.build(resourcePointers);
		final var alignmentBuilder = new AlignmentBuilder(memReq);
		final var alignedResources = alignmentBuilder.build();
		final var vkDevice = context.getVkDevice();
		return new MemoryAllocationContext(context, memReq.memoryTypeBits(), info, alignedResources, vkDevice);
	}

	private record MemoryAllocationContext(IVulkanContext context,
										   int memoryTypeBits,
										   Memory.Info info,
										   AlignmentBuilder.AlignedResources alignedResources,
										   VkDevice vkDevice)
	{
		public void verify(final Consumer<String> logger)
		{
			if(alignedResources.size() == 0) logger.accept("Size is 0.");
			if(memoryTypeBits == 0) logger.accept("Memory typpe is 0");
		}

		public Memory allocateMemory(final MemoryAllocationContext allocationContext)
		{
			final long ptr = allocateMemory();
			final var binder = new MemoryBinder(allocationContext.alignedResources(),
												allocationContext.vkDevice(),
												ptr);
			final var boundResources = binder.bindResources();
			return new Memory(info, ptr, boundResources);
		}

		private long allocateMemory()
		{
			final var allocInfo = allocateInfo();
			final long[] aMemoryId = new long[1];
			Logger.check(ALLOC_ERROR, () -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
			return aMemoryId[0];
		}

		private VkMemoryAllocateInfo allocateInfo()
		{
			final var physicalDevice = context.getPhysicalDevice();
			final var findMemoryType = physicalDevice.findMemoryType(memoryTypeBits, info.propertyFlag());
			final var allocInfo = VkMemoryAllocateInfo.calloc(context.stack());
			allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
			allocInfo.allocationSize(alignedResources.size());
			allocInfo.memoryTypeIndex(findMemoryType);
			return allocInfo;
		}
	}
}
