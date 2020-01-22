package org.sheepy.lily.vulkan.process.compute.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.common.process.IComputeContext;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class ComputeCommandBuffer extends AbstractCommandBuffer<IComputeContext>
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";
	private VkCommandBufferBeginInfo beginInfo;

	@Override
	public void allocate(IComputeContext context)
	{
		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);

		super.allocate(context);
	}

	@Override
	public void free(IComputeContext context)
	{
		beginInfo.free();

		super.free(context);
	}

	@Override
	public void start(ECommandStage stage)
	{
		switch (stage)
		{
		case TRANSFER:
			Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo),
					FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
			break;
		default:
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
		default:
			break;
		}
	}
}
