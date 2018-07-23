package org.sheepy.vulkan.command.graphic;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.graphic.IRenderPass;
import org.sheepy.vulkan.pipeline.graphic.SwapConfiguration;
import org.sheepy.vulkan.swapchain.SwapChainManager.Extent2D;

public class RenderCommandBuffer extends GraphicCommandBuffer
{
	private SwapConfiguration configuration;
	private long framebufferId;
	private Extent2D extent;
	private IRenderPass renderPass;

	public RenderCommandBuffer(LogicalDevice logicalDevice, long commandBufferId,
			SwapConfiguration configuration, long framebufferId, Extent2D extent,
			IRenderPass renderPass)
	{
		super(logicalDevice, commandBufferId);
		this.configuration = configuration;
		this.framebufferId = framebufferId;
		this.extent = extent;
		this.renderPass = renderPass;
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
		// Start Render Pass
		int clearCount = 1;
		clearCount += configuration.depthBuffer == true ? 1 : 0;
		VkClearValue.Buffer clearValues = VkClearValue.malloc(clearCount);
		VkClearValue clearColor = clearValues.get();
		clearColor.color().float32(0, 0f);
		clearColor.color().float32(1, 0f);
		clearColor.color().float32(2, 0f);
		clearColor.color().float32(3, 1f);

		if (configuration.depthBuffer == true)
		{
			VkClearValue clearDepth = clearValues.get();
			clearDepth.depthStencil().set(1.0f, 0);
		}
		clearValues.flip();

		VkRenderPassBeginInfo renderPassInfo = VkRenderPassBeginInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassInfo.renderPass(renderPass.getId());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.getWidth(), extent.getHeight());
		renderPassInfo.pClearValues(clearValues);

		vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);

		clearColor.free();
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
