package org.sheepy.lily.vulkan.process.compute.execution;

import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.*;

public class ComputeCommandBuffer extends AbstractCommandBuffer
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";
	private final VkCommandBufferBeginInfo beginInfo;

	public ComputeCommandBuffer(ProcessContext context)
	{
		super(context);

		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);
	}

	@Override
	public void free(ExecutionContext context)
	{
		beginInfo.free();

		super.free(context);
	}

	@Override
	public void start(ECommandStage stage)
	{
		if (stage == ECommandStage.TRANSFER)
		{
			Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo), FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
		}
	}

	@Override
	public void end(ECommandStage stage)
	{
		if (stage == ECommandStage.COMPUTE)
		{
			Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
		}
	}
}
