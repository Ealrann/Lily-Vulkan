package org.sheepy.lily.vulkan.process.graphic.execution;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.*;

public class GraphicCommandBuffer extends AbstractCommandBuffer
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";

	private final VkClearValue.Buffer clearValues;
	private final VkRenderPassBeginInfo renderPassBeginInfo;
	private final VkCommandBufferBeginInfo beginInfo;

	public GraphicCommandBuffer(ExecutionContext context,
								PhysicalSurfaceAllocation surfaceAllocation,
								RenderPassAllocation renderPassAllocation,
								long framebufferPtr)
	{
		super(context);

		final var clearInfos = renderPassAllocation.getClearInfos();
		final int clearCount = clearInfos.size();

		clearValues = VkClearValue.malloc(clearCount);
		for (final var clearInfo : clearInfos)
		{
			final VkClearValue clearValue = clearValues.get();
			if (clearInfo.isdepthStencil == false)
			{
				clearValue.color().float32(0, clearInfo.color.x());
				clearValue.color().float32(1, clearInfo.color.y());
				clearValue.color().float32(2, clearInfo.color.z());
				clearValue.color().float32(3, clearInfo.color.w());
			}
			else
			{
				clearValue.depthStencil().set(1.0f, 0);
			}
		}
		clearValues.flip();

		final var extent = surfaceAllocation.getExtent();
		renderPassBeginInfo = VkRenderPassBeginInfo.calloc();
		renderPassBeginInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassBeginInfo.framebuffer(framebufferPtr);
		renderPassBeginInfo.pClearValues(clearValues);
		renderPassBeginInfo.renderPass(renderPassAllocation.getPtr());
		renderPassBeginInfo.renderArea().offset().set(0, 0);
		renderPassBeginInfo.renderArea().extent().set(extent.x(), extent.y());

		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);
	}

	@Override
	public void free(ExecutionContext context)
	{
		if (clearValues != null) clearValues.free();

		renderPassBeginInfo.free();
		beginInfo.free();
		super.free(context);
	}

	@Override
	public void start(ECommandStage stage)
	{
		switch (stage)
		{
			case TRANSFER -> Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo),
										  FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
			case RENDER -> vkCmdBeginRenderPass(vkCommandBuffer, renderPassBeginInfo, VK_SUBPASS_CONTENTS_INLINE);
		}
	}

	@Override
	public void end(ECommandStage stage)
	{
		switch (stage)
		{
			case RENDER -> vkCmdEndRenderPass(vkCommandBuffer);
			case POST_RENDER -> Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
		}
	}
}
