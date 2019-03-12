package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
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
		final var configuration = graphicContext.configuration;
		final var useDepthBuffer = graphicContext.graphicProcess.getDepthImage() != null;
		final var extent = graphicContext.surfaceManager.getExtent();
		final var framebufferId = graphicContext.framebuffers.getIDs().get(index);

		if (configuration.isClearBeforeRender())
		{
			int clearCount = 1;
			clearCount += useDepthBuffer == true ? 1 : 0;
			clearValues = VkClearValue.malloc(clearCount);
			final VkClearValue clearColor = clearValues.get();
			clearColor.color().float32(0, 0f);
			clearColor.color().float32(1, 0f);
			clearColor.color().float32(2, 0f);
			clearColor.color().float32(3, 1f);

			if (useDepthBuffer == true)
			{
				final VkClearValue clearDepth = clearValues.get();
				clearDepth.depthStencil().set(1.0f, 0);
			}
			clearValues.flip();
		}

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
