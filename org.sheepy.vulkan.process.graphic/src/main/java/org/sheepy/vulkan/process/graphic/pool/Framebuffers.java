package org.sheepy.vulkan.process.graphic.pool;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.resource.DepthImage;
import org.sheepy.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.vulkan.resource.image.ImageView;

public class Framebuffers implements IBasicAllocable
{
	private final GraphicContext context;

	private List<Long> framebuffersIds = null;

	public Framebuffers(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		var vkDevice = context.getVkDevice();
		var imageViews = context.imageViewManager.getImageViews();
		var depthImage = context.graphicProcessPool.getDepthImage();
		var aFramebufferId = new long[1];
		var adapter = depthImage != null ? DepthImageAdapter.adapt(depthImage) : null;
		var depthImageViewId = adapter != null ? adapter.getDepthImageViewId() : -1;

		var attachments = allocAttachments(stack, depthImage);
		var createInfo = allocCreateInfo(stack, attachments);

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final ImageView imageView : imageViews)
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

	private VkFramebufferCreateInfo allocCreateInfo(MemoryStack stack, LongBuffer attachments)
	{
		final var extent = context.swapChainManager.getExtent();
		var createInfo = VkFramebufferCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
		createInfo.renderPass(context.renderPass.getId());
		createInfo.width(extent.getWidth());
		createInfo.height(extent.getHeight());
		createInfo.layers(1);
		createInfo.pAttachments(attachments);
		return createInfo;
	}

	@Override
	public void free()
	{
		for (final long framebuffer : framebuffersIds)
		{
			vkDestroyFramebuffer(context.getVkDevice(), framebuffer, null);
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
	public boolean isAllocationDirty()
	{
		return context.swapChainManager.isAllocationDirty() || context.imageViewManager.isAllocationDirty();
	}
}
