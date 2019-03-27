package org.sheepy.lily.vulkan.process.compute.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

public class ComputeCommandBuffer extends AbstractCommandBuffer
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";
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
	public void start(ECommandStage stage)
	{
		switch (stage)
		{
		case COMPUTE:
			Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo),
					FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
			break;
		case PRE_RENDER:
			break;
		case RENDER:
			break;
		case POST_RENDER:
			break;
		}
	}

	@Override
	public void end(ECommandStage stage)
	{
		switch (stage)
		{
		case COMPUTE:
			Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
			break;
		case POST_RENDER:
			break;
		case RENDER:
			break;
		case PRE_RENDER:
			break;
		}
	}
}
