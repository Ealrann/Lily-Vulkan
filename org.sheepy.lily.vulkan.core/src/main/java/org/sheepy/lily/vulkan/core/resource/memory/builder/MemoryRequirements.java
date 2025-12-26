package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

import java.util.List;

public record MemoryRequirements(int memoryTypeBits, long alignement, List<? extends ISizedResource<?>> sizedResources)
{
	public interface ISizedResource<T extends IVulkanResourcePointer>
	{
		T vkResource();
		long size();

		AlignmentBuilder.IAlignedResource<T> buildAlignedResource(final long size);
	}

	public record SizedImage(VkImage vkResource, long size) implements ISizedResource<VkImage>
	{
		@Override
		public AlignmentBuilder.IAlignedResource<VkImage> buildAlignedResource(final long size)
		{
			return new AlignmentBuilder.AlignedImage(vkResource, size);
		}
	}

	public record SizedBuffer(VkBuffer vkResource, long size) implements ISizedResource<VkBuffer>
	{
		@Override
		public AlignmentBuilder.IAlignedResource<VkBuffer> buildAlignedResource(final long size)
		{
			return new AlignmentBuilder.AlignedBuffer(vkResource, size);
		}
	}
}
