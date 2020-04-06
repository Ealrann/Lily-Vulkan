package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.graphic.IFramebufferManager;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public class FramebufferManager implements IFramebufferManager, IAllocable<GraphicContext>
{
	private static final String FAILED_TO_CREATE_FRAMEBUFFER = "Failed to create framebuffer";

	private List<Long> framebuffersIds = null;

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();
		final var imageViewManager = context.getImageViewManager();
		final var renderPass = context.getRenderPass();

		config.addDependencies(List.of(swapChainManager, imageViewManager, renderPass));
	}

	@Override
	public void allocate(GraphicContext context)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		final var imageViews = context.getImageViewManager().getImageViews();
		final var aFramebufferId = new long[1];
		final var attachments = context.getRenderPass().getUsedExtraAttachments();

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final var imageView : imageViews)
		{
			final var attachmentsBuffer = allocAttachments(stack, attachments, imageView.getPtr());
			final var createInfo = allocCreateInfo(stack, context, attachmentsBuffer);

			Logger.check(vkCreateFramebuffer(vkDevice, createInfo, null, aFramebufferId), FAILED_TO_CREATE_FRAMEBUFFER);
			framebuffersIds.add(aFramebufferId[0]);
		}

		framebuffersIds = List.copyOf(framebuffersIds);
	}

	private static LongBuffer allocAttachments(MemoryStack stack, List<ExtraAttachment> attachments, long imageViewId)
	{
		final var attachmentsBuffer = stack.mallocLong(attachments.size() + 1);
		attachmentsBuffer.put(imageViewId);

		for (final var attachment : attachments)
		{
			final var description = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
			attachmentsBuffer.put(description.getViewPtr());
		}

		attachmentsBuffer.flip();
		return attachmentsBuffer;
	}

	private static VkFramebufferCreateInfo allocCreateInfo(MemoryStack stack,
														   IGraphicContext graphicContext,
														   LongBuffer attachments)
	{
		final var extent = graphicContext.getSurfaceManager().getExtent();
		final var createInfo = VkFramebufferCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
		createInfo.renderPass(graphicContext.getRenderPass().getPtr());
		createInfo.width(extent.x());
		createInfo.height(extent.y());
		createInfo.layers(1);
		createInfo.pAttachments(attachments);
		return createInfo;
	}

	@Override
	public void free(GraphicContext context)
	{
		for (final long framebuffer : framebuffersIds)
		{
			vkDestroyFramebuffer(context.getVkDevice(), framebuffer, null);
		}
		framebuffersIds = null;
	}

	@Override
	public List<Long> getFramebufferAddresses()
	{
		return framebuffersIds;
	}

	public int size()
	{
		return framebuffersIds != null ? framebuffersIds.size() : 0;
	}
}
