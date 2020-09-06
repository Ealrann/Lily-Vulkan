package org.sheepy.lily.vulkan.core.resource.memory.builder;

import org.sheepy.lily.vulkan.core.resource.memory.FunctionalMemoryBuilder;

import java.util.List;

public record MemoryRequirements(int memoryTypeBits, long alignement, List<ISizedResource> sizedResources)
{
	public interface ISizedResource
	{
		long ptr();
		long size();

		AlignmentBuilder.IAlignedResource buildAlignedResource(final long size);
	}

	public record SizedImage(long ptr, long size) implements ISizedResource
	{
		@Override
		public AlignmentBuilder.IAlignedResource buildAlignedResource(final long size)
		{
			return new AlignmentBuilder.AlignedImage(ptr, size);
		}
	}

	public record SizedBuffer(long ptr, long size) implements ISizedResource
	{
		@Override
		public AlignmentBuilder.IAlignedResource buildAlignedResource(final long size)
		{
			return new AlignmentBuilder.AlignedBuffer(ptr, size);
		}
	}

}
