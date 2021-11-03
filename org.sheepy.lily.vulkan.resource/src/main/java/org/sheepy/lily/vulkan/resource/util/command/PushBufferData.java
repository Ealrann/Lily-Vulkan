package org.sheepy.lily.vulkan.resource.util.command;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.vulkan.core.execution.RecordContext;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

public final class PushBufferData implements IDataFlow
{
	private final long srcBuffer;
	private final long trgBuffer;
	private final List<RegionFlowInfo> regions;

	public PushBufferData(final long srcBuffer, final long trgBuffer, final List<RegionFlowInfo> regions)
	{
		this.srcBuffer = srcBuffer;
		this.trgBuffer = trgBuffer;
		this.regions = List.copyOf(regions);
	}

	@Override
	public void record(final RecordContext recordContext)
	{
		final var commandBuffer = recordContext.commandBuffer;
		final var stack = recordContext.stack();
		final var copyRegions = VkBufferCopy.malloc(regions.size(), stack);

		regions.forEach(region -> region.fill(copyRegions.get()));
		copyRegions.flip();
		vkCmdCopyBuffer(commandBuffer, srcBuffer, trgBuffer, copyRegions);
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.PUSH;
	}

	@Override
	public String toString()
	{
		return "PushBufferData{" + "srcBuffer=" + srcBuffer + ", trgBuffer=" + trgBuffer + ", regions=" + regions + '}';
	}

	public record RegionFlowInfo(long srcOffset, long dstOffset, long size)
	{
		public void fill(VkBufferCopy vkRegion)
		{
			vkRegion.set(srcOffset, dstOffset, size);
		}
	}
}
