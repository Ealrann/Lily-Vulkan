package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.graphic.ClearInfo;
import org.sheepy.lily.vulkan.api.graphic.IFramebufferManager;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.resource.attachment.ISwapAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.resource.image.VkImageView;

public class FramebufferManager implements IFramebufferManager
{
	private boolean depthAttachment = false;
	private List<Long> framebuffersIds = null;
	private List<ClearInfo> clearInfos = null;
	private EList<ISwapAttachment> attachments;

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();
		final var imageViewManager = context.getImageViewManager();

		config.addDependencies(List.of(swapChainManager, imageViewManager));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		final var imageViews = context.getImageViewManager().getImageViews();
		final var aFramebufferId = new long[1];

		final var configuration = context.getConfiguration().getFramebufferConfiguration();
		final var swapChainConfiguration = context.getConfiguration().getSwapchainConfiguration();
		attachments = swapChainConfiguration.getAtachments();

		final var attachmentsBuffer = allocAttachmentsBuffer(stack);
		final var createInfo = allocCreateInfo(stack, context, attachmentsBuffer);

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final VkImageView imageView : imageViews)
		{
			fillAttachments(attachmentsBuffer, imageView.getPtr(), configuration);

			Logger.check(	"Failed to create framebuffer!",
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
			final var adapter = attachment.adaptNotNull(ISwapAttachmentAdapter.class);

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
	public void free(IGraphicContext context)
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
