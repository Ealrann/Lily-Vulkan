package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.util.AlignmentUtil;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.vkGetBufferMemoryRequirements;
import static org.lwjgl.vulkan.VK10.vkGetImageMemoryRequirements;

public final class MemoryRequirementsBuilder
{
	private final VkDevice device;
	private final VkMemoryRequirements requirementBuffer;

	private int memoryTypeBits;
	private long alignement;

	public MemoryRequirementsBuilder(final IVulkanContext context)
	{
		device = context.getVkDevice();
		requirementBuffer = VkMemoryRequirements.mallocStack(context.stack());
	}

	public MemoryRequirements build(final Stream<? extends IVulkanResourcePointer> resourcePointers)
	{
		memoryTypeBits = 0;
		alignement = 1;

		final var alignedDescriptions = resourcePointers.map(this::updateRequirementsAndSizeResource)
														.collect(Collectors.toUnmodifiableList());

		return new MemoryRequirements(memoryTypeBits, alignement, alignedDescriptions);
	}

	private MemoryRequirements.ISizedResource<?> updateRequirementsAndSizeResource(final IVulkanResourcePointer description)
	{
		final var wrapper = IResourceWrapper.of(description);
		wrapper.fillMemoryRequirements(device, requirementBuffer);
		alignement = AlignmentUtil.leastCommonMultiple(alignement, requirementBuffer.alignment());
		memoryTypeBits |= requirementBuffer.memoryTypeBits();
		return wrapper.buildSizedResource(requirementBuffer.size());
	}

	public interface IResourceWrapper<T extends IVulkanResourcePointer>
	{
		void fillMemoryRequirements(VkDevice device, VkMemoryRequirements memoryRequirements);
		MemoryRequirements.ISizedResource<T> buildSizedResource(long size);

		static IResourceWrapper<?> of(IVulkanResourcePointer description)
		{
			if (description instanceof VkBuffer bufferPointer)
			{
				return new BufferWrapper(bufferPointer);
			}
			else if (description instanceof VkImage imagePointer)
			{
				return new ImageWrapper(imagePointer);
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}

	public record BufferWrapper(VkBuffer resourcePointer) implements IResourceWrapper<VkBuffer>
	{
		@Override
		public void fillMemoryRequirements(final VkDevice device, final VkMemoryRequirements memoryRequirements)
		{
			vkGetBufferMemoryRequirements(device, resourcePointer.ptr(), memoryRequirements);
		}

		@Override
		public MemoryRequirements.ISizedResource<VkBuffer> buildSizedResource(final long size)
		{
			return new MemoryRequirements.SizedBuffer(resourcePointer, size);
		}
	}

	public record ImageWrapper(VkImage resourcePointer) implements IResourceWrapper<VkImage>
	{
		@Override
		public void fillMemoryRequirements(final VkDevice device, final VkMemoryRequirements memoryRequirements)
		{
			vkGetImageMemoryRequirements(device, resourcePointer.ptr(), memoryRequirements);
		}

		@Override
		public MemoryRequirements.ISizedResource<VkImage> buildSizedResource(final long size)
		{
			return new MemoryRequirements.SizedImage(resourcePointer, size);
		}
	}
}
