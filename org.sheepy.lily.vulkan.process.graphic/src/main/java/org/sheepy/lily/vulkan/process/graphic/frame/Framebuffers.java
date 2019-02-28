package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.resource.DepthImage;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public class Framebuffers implements IAllocable
{
	private List<Long> framebuffersIds = null;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		var vkDevice = graphicContext.getVkDevice();
		var imageViews = graphicContext.imageViewManager.getImageViews();
		var depthImage = graphicContext.graphicProcess.getDepthImage();
		var aFramebufferId = new long[1];
		var adapter = depthImage != null ? DepthImageAdapter.adapt(depthImage) : null;
		var depthImageViewId = adapter != null ? adapter.getDepthImageViewId() : -1;

		var attachments = allocAttachments(stack, depthImage);
		var createInfo = allocCreateInfo(stack, graphicContext, attachments);

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final VkImageView imageView : imageViews)
		{
			fillAttachements(attachments, imageView.getId(), depthImageViewId);

			Logger.check("Failed to create framebuffer!",
					() -> vkCreateFramebuffer(vkDevice, createInfo, null, aFramebufferId));
			framebuffersIds.add(aFramebufferId[0]);
		}

		framebuffersIds = List.copyOf(framebuffersIds);
	}

	private static void fillAttachements(	LongBuffer attachments,
											long imageViewId,
											long depthImageViewId)
	{
		attachments.put(imageViewId);
		if (depthImageViewId != -1)
		{
			attachments.put(depthImageViewId);
		}
		attachments.flip();
	}

	private static LongBuffer allocAttachments(MemoryStack stack, final DepthImage depthImage)
	{
		int attachementCount = 1;
		attachementCount += depthImage != null ? 1 : 0;
		var attachments = stack.mallocLong(attachementCount);
		return attachments;
	}

	private static VkFramebufferCreateInfo allocCreateInfo(	MemoryStack stack,
															GraphicContext graphicContext,
															LongBuffer attachments)
	{
		final var extent = graphicContext.surfaceManager.getExtent();
		var createInfo = VkFramebufferCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
		createInfo.renderPass(graphicContext.renderPass.getId());
		createInfo.width(extent.getWidth());
		createInfo.height(extent.getHeight());
		createInfo.layers(1);
		createInfo.pAttachments(attachments);
		return createInfo;
	}

	@Override
	public void free(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		for (final long framebuffer : framebuffersIds)
		{
			vkDestroyFramebuffer(graphicContext.getVkDevice(), framebuffer, null);
		}
		framebuffersIds = null;
	}

	public List<Long> getIDs()
	{
		return framebuffersIds;
	}

	public int size()
	{
		return framebuffersIds != null ? framebuffersIds.size() : 0;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context)
				|| graphicContext.imageViewManager.isAllocationDirty(context);
	}
}
