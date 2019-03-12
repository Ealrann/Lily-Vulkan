package org.sheepy.lily.vulkan.process.compute.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;

public class ComputeCommandBuffer extends AbstractCommandBuffer
{
	private VkCommandBufferBeginInfo beginInfo;

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

		super.free(context);
	}

	@Override
	public void start()
	{
		if (vkBeginCommandBuffer(vkCommandBuffer, beginInfo) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to begin recording command buffer");
		}
	}

	@Override
	public void end()
	{
		if (vkEndCommandBuffer(vkCommandBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to record command buffer");
		}
	}
}
