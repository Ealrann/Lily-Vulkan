package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.process.graphic.frame.Framebuffers.ClearInfo;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class RenderCommandBuffer extends GraphicCommandBuffer
{
	private VkClearValue.Buffer clearValues;
	private VkRenderPassBeginInfo renderPassInfo;

	public RenderCommandBuffer(int index)
	{
		super(index);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var extent = graphicContext.surfaceManager.getExtent();
		final var framebufferId = graphicContext.framebuffers.getIDs().get(index);

		var clearInfos = graphicContext.framebuffers.getClearInfos();

		int clearCount = clearInfos.size();
		clearValues = VkClearValue.malloc(clearCount);

		for (ClearInfo clearInfo : clearInfos)
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
		renderPassInfo.renderPass(graphicContext.renderPass.getId());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.getWidth(), extent.getHeight());
		renderPassInfo.pClearValues(clearValues);

		super.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		if (clearValues != null)
		{
			clearValues.free();
			clearValues = null;
		}

		renderPassInfo.free();
		renderPassInfo = null;

		super.free(context);
	}

	public void startCommand()
	{
		super.start();
	}

	@Override
	public void start()
	{
		startCommand();
		startRenderPass();
	}

	public void startRenderPass()
	{
		vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);

	}

	public void endRenderPass()
	{
		vkCmdEndRenderPass(vkCommandBuffer);
	}

	public void endCommand()
	{
		super.end();
	}

	@Override
	public void end()
	{
		endRenderPass();
		endCommand();
	}
}
