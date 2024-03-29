package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.util.AlignmentUtil;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkBindBufferMemory;
import static org.lwjgl.vulkan.VK10.vkBindImageMemory;

public final class AlignmentBuilder
{
	private final MemoryRequirements memReq;

	private long position = 0;

	public AlignmentBuilder(MemoryRequirements memReq)
	{
		this.memReq = memReq;
	}

	public AlignedResources build()
	{
		position = 0;

		final var alignedResources = memReq.sizedResources().stream().map(this::buildAlignedResource).toList();

		return new AlignedResources(alignedResources, position);
	}

	private <T extends IVulkanResourcePointer> IAlignedResource<T> buildAlignedResource(MemoryRequirements.ISizedResource<T> resource)
	{
		final long initialPosition = position;
		position += resource.size();
		position = AlignmentUtil.align(position, memReq.alignement());

		final long alignedSize = position - initialPosition;
		return resource.buildAlignedResource(alignedSize);
	}

	public record AlignedResources(List<? extends IAlignedResource<?>> alignedResources, long size)
	{
	}

	public interface IAlignedResource<T extends IVulkanResourcePointer>
	{
		T vkResource();
		long size();

		void bind(VkDevice vkDevice, long memoryPtr, long offset);
	}

	public record AlignedImage(VkImage vkResource, long size) implements IAlignedResource<VkImage>
	{
		@Override
		public void bind(final VkDevice vkDevice, final long memoryPtr, final long offset)
		{
			vkBindImageMemory(vkDevice, vkResource.ptr(), memoryPtr, offset);
		}
	}

	public record AlignedBuffer(VkBuffer vkResource, long size) implements IAlignedResource<VkBuffer>
	{
		@Override
		public void bind(final VkDevice vkDevice, final long memoryPtr, final long offset)
		{
			vkBindBufferMemory(vkDevice, vkResource.ptr(), memoryPtr, offset);
		}
	}
}
