package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBufferAllocator;
import org.sheepy.lily.vulkan.core.resource.util.AlignmentUtil;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAdapter;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = BufferMemory.class)
@Adapter
@AllocationChild(features = VulkanResourcePackage.BUFFER_MEMORY__BUFFERS)
public final class BufferMemoryAdapter implements IMemoryChunkPartAdapter
{
	private final BufferMemory bufferMemory;

	private ChunkInfo chunkInfo = null;

	public BufferMemoryAdapter(final BufferMemory bufferMemory)
	{
		this.bufferMemory = bufferMemory;
	}

	@Override
	public IVulkanResourcePointer allocateVulkanResource(IVulkanContext context)
	{
		chunkInfo = new ChunkInfo(buildAlignmentData(context.getPhysicalDevice(), bufferMemory));
		final var info = new BufferInfo(chunkInfo.size(), chunkInfo.usage(), true);
		info.computeAlignment(context.getPhysicalDevice());

		return VkBufferAllocator.allocate(context, info, bufferMemory.getName());
	}

	public ChunkInfo getChunkInfo()
	{
		return chunkInfo;
	}

	private static List<AlignmentData> buildAlignmentData(final PhysicalDevice physicalDevice,
														  final BufferMemory bufferMemory)
	{
		long position = 0;
		final List<AlignmentData> tmpData = new ArrayList<>();
		for (final var buffer : bufferMemory.getBuffers())
		{
			final var sizeAdapter = buffer.adaptNotNull(IBufferAdapter.class);
			final long size = sizeAdapter.getSize(buffer);
			final int usage = VulkanModelUtil.getEnumeratedFlag(buffer.getUsages());

			final long alignment = physicalDevice.getBufferAlignement(usage, true);
			position = AlignmentUtil.align(position, alignment);
			final long alignedSize = AlignmentUtil.align(size, alignment);

			tmpData.add(new AlignmentData(position, alignedSize, usage));
			position += alignedSize;
		}
		return List.copyOf(tmpData);
	}

	public static record ChunkInfo(List<AlignmentData> data, long size, int usage)
	{
		public ChunkInfo(List<AlignmentData> data)
		{
			this(data, totalSize(data), cumulateUsages(data));
		}

		private static long totalSize(final List<AlignmentData> data)
		{
			return data.stream().mapToLong(AlignmentData::size).sum();
		}

		private static int cumulateUsages(final List<AlignmentData> data)
		{
			return data.stream().mapToInt(AlignmentData::usage).reduce((a, b) -> a | b).orElse(0);
		}
	}
}
