package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.util.AlignmentUtil;

import java.util.List;
import java.util.stream.Collectors;

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

		final var alignedResources = memReq.sizedResources()
										   .stream()
										   .map(this::buildAlignedResource)
										   .collect(Collectors.toUnmodifiableList());

		return new AlignedResources(alignedResources, position);
	}

	private IAlignedResource buildAlignedResource(MemoryRequirements.ISizedResource resource)
	{
		final long initialPosition = position;
		position += resource.size();
		position = AlignmentUtil.align(position, memReq.alignement());

		final long alignedSize = position - initialPosition;
		return resource.buildAlignedResource(alignedSize);
	}

	public record AlignedResources(List<IAlignedResource> alignedResources, long size)
	{
		public void bindResources(final VkDevice vkDevice, final long ptr)
		{
			long offset = 0;
			for (int i = 0; i < alignedResources.size(); i++)
			{
				final var alignedResource = alignedResources.get(i);
				final var size = alignedResource.size();

				alignedResource.bind(vkDevice, ptr, offset);
				offset += size;
			}
		}
	}

	public interface IAlignedResource
	{
		long ptr();
		long size();

		void bind(VkDevice vkDevice, long memoryPtr, long offset);
	}

	public record AlignedImage(long ptr, long size) implements IAlignedResource
	{
		@Override
		public void bind(final VkDevice vkDevice, final long memoryPtr, final long offset)
		{
			vkBindImageMemory(vkDevice, ptr, memoryPtr, offset);
		}
	}

	public record AlignedBuffer(long ptr, long size) implements IAlignedResource
	{
		@Override
		public void bind(final VkDevice vkDevice, final long memoryPtr, final long offset)
		{
			vkBindBufferMemory(vkDevice, ptr, memoryPtr, offset);
		}
	}
}
