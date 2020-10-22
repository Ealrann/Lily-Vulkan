package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public final class MemoryBinder
{
	private final List<? extends AlignmentBuilder.IAlignedResource<?>> alignedResources;
	private final VkDevice vkDevice;
	private final long ptr;

	private AtomicLong offset;

	public MemoryBinder(AlignmentBuilder.AlignedResources alignedResources, final VkDevice vkDevice, final long ptr)
	{
		this.alignedResources = alignedResources.alignedResources();
		this.vkDevice = vkDevice;
		this.ptr = ptr;
	}

	public List<Memory.BoundResource<?>> bindResources()
	{
		offset = new AtomicLong(0);

		return alignedResources.stream().map(this::bind).collect(Collectors.toUnmodifiableList());
	}

	private <T extends IVulkanResourcePointer> Memory.BoundResource<T> bind(final AlignmentBuilder.IAlignedResource<T> alignedResource)
	{
		final var size = alignedResource.size();
		alignedResource.bind(vkDevice, ptr, offset.getAndAdd(size));
		return new Memory.BoundResource<>(alignedResource.vkResource(), size);
	}
}
