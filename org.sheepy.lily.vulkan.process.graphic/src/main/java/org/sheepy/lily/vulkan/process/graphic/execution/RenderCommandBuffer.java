package org.sheepy.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager.Extent2D;

public class RenderCommandBuffer extends GraphicCommandBuffer
{
	private final long framebufferId;
	private final Extent2D extent;
	private final GraphicContext context;

	public RenderCommandBuffer(	GraphicContext context,
	                           	int index,
								long commandBufferId,
								long framebufferId)
	{
		super(context.logicalDevice, index, commandBufferId);
		this.framebufferId = framebufferId;
		this.extent = context.swapChainManager.getExtent();
		this.context = context;
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
		final var configuration = context.configuration;
		final var useDepthBuffer = context.graphicProcess.getDepthImage() != null;

		// Start Render Pass
		VkClearValue.Buffer clearValues = null;

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

		final VkRenderPassBeginInfo renderPassInfo = VkRenderPassBeginInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassInfo.renderPass(context.renderPass.getId());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.getWidth(), extent.getHeight());
		renderPassInfo.pClearValues(clearValues);

		vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);

		if (clearValues != null) clearValues.free();
		renderPassInfo.free();
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
