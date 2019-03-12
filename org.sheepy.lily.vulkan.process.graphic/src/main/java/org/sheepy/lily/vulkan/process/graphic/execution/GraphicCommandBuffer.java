package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;

public abstract class GraphicCommandBuffer extends AbstractCommandBuffer
{
	public final int index;

	private VkCommandBufferBeginInfo beginInfo;

	public GraphicCommandBuffer(int index)
	{
		this.index = index;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);

		super.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		beginInfo.free();
		beginInfo = null;

		super.free(context);
	}

	@Override
	public void start()
	{
		// Start buffer record
		if (vkBeginCommandBuffer(vkCommandBuffer, beginInfo) != VK_SUCCESS)
		{
			throw new AssertionError("failed to begin recording command buffer!");
		}
	}

	@Override
	public void end()
	{
		if (vkEndCommandBuffer(vkCommandBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("failed to record command buffer!");
		}
	}
}
