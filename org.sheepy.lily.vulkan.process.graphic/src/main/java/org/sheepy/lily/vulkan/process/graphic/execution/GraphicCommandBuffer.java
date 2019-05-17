package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class GraphicCommandBuffer extends AbstractCommandBuffer<IGraphicContext>
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";
	public final int index;
	private VkClearValue.Buffer clearValues;
	private VkRenderPassBeginInfo renderPassInfo;

	private VkCommandBufferBeginInfo beginInfo;

	public GraphicCommandBuffer(int index)
	{
		this.index = index;
	}

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		final var extent = context.getSurfaceManager().getExtent();
		final var framebufferManager = context.getFramebufferManager();
		final var framebufferId = framebufferManager.getFramebufferAddresses().get(index);
		final var clearInfos = framebufferManager.getClearInfos();
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

		renderPassInfo = VkRenderPassBeginInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassInfo.renderPass(context.getRenderPass().getAddress());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.getWidth(), extent.getHeight());
		renderPassInfo.pClearValues(clearValues);

		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);

		super.allocate(stack, context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		if (clearValues != null)
		{
			clearValues.free();
			clearValues = null;
		}

		renderPassInfo.free();
		renderPassInfo = null;

		beginInfo.free();
		beginInfo = null;

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
		case RENDER:
			vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);
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
		case RENDER:
			vkCmdEndRenderPass(vkCommandBuffer);
			break;
		case POST_RENDER:
			Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getFramebufferManager().isAllocationDirty(context);
	}

}
