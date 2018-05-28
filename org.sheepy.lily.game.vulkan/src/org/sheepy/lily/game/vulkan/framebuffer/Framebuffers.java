package org.sheepy.lily.game.vulkan.framebuffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.imageview.ImageView;
import org.sheepy.lily.game.vulkan.imageview.ImageViewManager;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class Framebuffers
{
	private LogicalDevice logicalDevice;

	private List<Long> framebuffersIds = null;

	public Framebuffers(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void load(SwapChainManager swapChain,
			ImageViewManager imageViews, RenderPass renderPass)
	{
		List<ImageView> aImageViews = imageViews.getImageViews();
		framebuffersIds = new ArrayList<>(aImageViews.size());
		for (ImageView aImageView: aImageViews)
		{
			LongBuffer attachments = MemoryUtil.memAllocLong(1);
			attachments.put(aImageView.getImageViewId());
			attachments.flip();

			VkFramebufferCreateInfo framebufferInfo = VkFramebufferCreateInfo.calloc();
			framebufferInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
			framebufferInfo.renderPass(renderPass.getID());
			framebufferInfo.pAttachments(attachments);
			framebufferInfo.width(swapChain.getExtent().getWidth());
			framebufferInfo.height(swapChain.getExtent().getHeight());
			framebufferInfo.layers(1);

			long[] aFramebufferId = new long[1];
			if (vkCreateFramebuffer(logicalDevice.getVkDevice(), framebufferInfo, null,
					aFramebufferId) != VK_SUCCESS)
			{
				throw new AssertionError("failed to create framebuffer!");
			}
			framebuffersIds.add(aFramebufferId[0]);

			framebufferInfo.free();
		}

		framebuffersIds = Collections.unmodifiableList(framebuffersIds);
	}

	public List<Long> getIDs()
	{
		return framebuffersIds;
	}

	public void free()
	{
		for (long framebuffer : framebuffersIds)
		{
			vkDestroyFramebuffer(logicalDevice.getVkDevice(), framebuffer, null);
		}
		framebuffersIds = null;
	}

	public int size()
	{
		return framebuffersIds != null ?  framebuffersIds.size() : 0;
	}
}
