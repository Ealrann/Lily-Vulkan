package org.sheepy.lily.game.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager.Extent2D;
import org.sheepy.lily.game.vulkan.swappipeline.SwapConfiguration;

public class CommandBuffer
{
	private VkCommandBuffer vkCommandBuffer;
	private SwapConfiguration configuration;
	private long framebufferId;
	private Extent2D extent;

	public CommandBuffer(VkCommandBuffer vkCommandBuffer, SwapConfiguration configuration, long framebufferId, Extent2D extent)
	{
		this.vkCommandBuffer = vkCommandBuffer;
		this.configuration = configuration;
		this.framebufferId = framebufferId;
		this.extent = extent;
	}

	public void startRenderpass(RenderPass renderPass)
	{
		// Start buffer record
		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null); // Optional

		if (vkBeginCommandBuffer(vkCommandBuffer, beginInfo) != VK_SUCCESS)
		{
			throw new AssertionError("failed to begin recording command buffer!");
		}
		
		// Start Render Pass
		int clearCount = 1;
		clearCount += configuration.depthBuffer == true ? 1 : 0;
		VkClearValue.Buffer clearValues = VkClearValue.malloc(clearCount);
		VkClearValue clearColor = clearValues.get();
		clearColor.color().float32(0, 0f);
		clearColor.color().float32(1, 0f);
		clearColor.color().float32(2, 0f);
		clearColor.color().float32(3, 1f);
		
		if(configuration.depthBuffer == true)
		{
			VkClearValue clearDepth = clearValues.get();
			clearDepth.depthStencil().set(1.0f, 0);
		}
		clearValues.flip();

		VkRenderPassBeginInfo renderPassInfo = VkRenderPassBeginInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassInfo.renderPass(renderPass.getID());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.getWidth(), extent.getHeight());
		renderPassInfo.pClearValues(clearValues);

		vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);

		clearColor.free();
		renderPassInfo.free();
		beginInfo.free();
	}
	
	public void endRenderPass()
	{
		vkCmdEndRenderPass(vkCommandBuffer);
		
		if (vkEndCommandBuffer(vkCommandBuffer) != VK_SUCCESS) {
			throw new AssertionError("failed to record command buffer!");
		}
	}
	
	public VkCommandBuffer getVkCommandBuffer()
	{
		return vkCommandBuffer;
	}
}
