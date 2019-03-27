package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.ClearInfo;
import org.sheepy.lily.vulkan.api.resource.attachment.ISwapAttachmentAdapter;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.lily.vulkan.process.graphic.api.IFramebufferManager;
import org.sheepy.lily.vulkan.process.graphic.api.IGraphicContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public class FramebufferManager implements IFramebufferManager
{
	private boolean depthAttachment = false;
	private List<Long> framebuffersIds = null;
	private List<ClearInfo> clearInfos = null;
	private EList<ISwapAttachment> attachments;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var vkDevice = graphicContext.getVkDevice();
		final var imageViews = graphicContext.getImageViewManager().getImageViews();
		final var aFramebufferId = new long[1];

		final var configuration = graphicContext.getConfiguration().getFramebufferConfiguration();
		final var swapChainConfiguration = graphicContext.getConfiguration()
				.getSwapchainConfiguration();
		attachments = swapChainConfiguration.getAtachments();

		final var attachmentsBuffer = allocAttachmentsBuffer(stack);
		final var createInfo = allocCreateInfo(stack, graphicContext, attachmentsBuffer);

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final VkImageView imageView : imageViews)
		{
			fillAttachments(attachmentsBuffer, imageView.getAddress(), configuration);

			Logger.check("Failed to create framebuffer!",
					() -> vkCreateFramebuffer(vkDevice, createInfo, null, aFramebufferId));
			framebuffersIds.add(aFramebufferId[0]);
		}

		framebuffersIds = List.copyOf(framebuffersIds);
	}

	private void fillAttachments(	LongBuffer attachmentsBuffer,
									long imageViewId,
									FramebufferConfiguration configuration)
	{
		attachmentsBuffer.put(imageViewId);

		clearInfos = new ArrayList<>();
		clearInfos.add(new ClearInfo(false, configuration.getClearValue()));

		for (final var attachment : attachments)
		{
			final var adapter = ISwapAttachmentAdapter.adapt(attachment);

			depthAttachment |= adapter.isDepthAttachment();
			clearInfos.add(adapter.getClearInfos());
			attachmentsBuffer.put(adapter.getImageViewId());
		}

		clearInfos = List.copyOf(clearInfos);

		attachmentsBuffer.flip();
	}

	private LongBuffer allocAttachmentsBuffer(MemoryStack stack)
	{
		int attachementCount = 1;
		attachementCount += attachments.size();
		final var attachments = stack.mallocLong(attachementCount);
		return attachments;
	}

	private static VkFramebufferCreateInfo allocCreateInfo(	MemoryStack stack,
															IGraphicContext graphicContext,
															LongBuffer attachments)
	{
		final var extent = graphicContext.getSurfaceManager().getExtent();
		final var createInfo = VkFramebufferCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
		createInfo.renderPass(graphicContext.getRenderPass().getAddress());
		createInfo.width(extent.getWidth());
		createInfo.height(extent.getHeight());
		createInfo.layers(1);
		createInfo.pAttachments(attachments);
		return createInfo;
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		for (final long framebuffer : framebuffersIds)
		{
			vkDestroyFramebuffer(graphicContext.getVkDevice(), framebuffer, null);
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

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		return graphicContext.getSwapChainManager().isAllocationDirty(context)
				|| graphicContext.getImageViewManager().isAllocationDirty(context);
	}

	@Override
	public boolean hasDepthAttachment()
	{
		return depthAttachment;
	}

	@Override
	public List<ClearInfo> getClearInfos()
	{
		return clearInfos;
	}
}
