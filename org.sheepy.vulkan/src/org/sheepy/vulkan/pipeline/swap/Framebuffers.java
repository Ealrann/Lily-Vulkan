package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.vulkan.buffer.DepthResource;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.swapchain.SwapChainManager;
import org.sheepy.vulkan.view.ImageView;
import org.sheepy.vulkan.view.ImageViewManager;

public class Framebuffers implements IAllocable
{
	private LogicalDevice logicalDevice;
	private DepthResource depthResource;
	private SwapChainManager swapChainManager;
	private ImageViewManager imageViewManager;
	private IRenderPass renderPass;

	private List<Long> framebuffersIds = null;

	public Framebuffers(LogicalDevice logicalDevice, SwapChainManager swapChainManager,
			ImageViewManager imageViewManager, IRenderPass renderPass, DepthResource depthResource)
	{
		this.logicalDevice = logicalDevice;
		this.swapChainManager = swapChainManager;
		this.imageViewManager = imageViewManager;
		this.renderPass = renderPass;
		this.depthResource = depthResource;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		List<ImageView> aImageViews = imageViewManager.getImageViews();
		framebuffersIds = new ArrayList<>(aImageViews.size());
		for (ImageView aImageView : aImageViews)
		{
			int attachementCount = 1;
			attachementCount += depthResource != null ? 1 : 0;
			LongBuffer attachments = stack.mallocLong(attachementCount);
			attachments.put(aImageView.getId());
			if (depthResource != null)
			{
				attachments.put(depthResource.getDepthImageViewId());
			}
			attachments.flip();

			VkFramebufferCreateInfo framebufferInfo = VkFramebufferCreateInfo.callocStack(stack);
			framebufferInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
			framebufferInfo.renderPass(renderPass.getId());
			framebufferInfo.pAttachments(attachments);
			framebufferInfo.width(swapChainManager.getExtent().getWidth());
			framebufferInfo.height(swapChainManager.getExtent().getHeight());
			framebufferInfo.layers(1);

			long[] aFramebufferId = new long[1];
			if (vkCreateFramebuffer(logicalDevice.getVkDevice(), framebufferInfo, null,
					aFramebufferId) != VK_SUCCESS)
			{
				throw new AssertionError("failed to create framebuffer!");
			}
			framebuffersIds.add(aFramebufferId[0]);
		}

		framebuffersIds = Collections.unmodifiableList(framebuffersIds);
	}

	public List<Long> getIDs()
	{
		return framebuffersIds;
	}

	@Override
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
		return framebuffersIds != null ? framebuffersIds.size() : 0;
	}
}
