package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector4fc;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.IFramebufferAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public class Framebuffers implements IAllocable
{
	private boolean depthAttachment = false;
	private List<Long> framebuffersIds = null;
	private List<ClearInfo> clearInfos = null;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var vkDevice = graphicContext.getVkDevice();
		final var imageViews = graphicContext.imageViewManager.getImageViews();
		final var aFramebufferId = new long[1];

		final var configuration = graphicContext.configuration.getFramebufferConfiguration();

		final var attachments = allocAttachments(stack, configuration);
		final var createInfo = allocCreateInfo(stack, graphicContext, attachments);

		framebuffersIds = new ArrayList<>(imageViews.size());
		for (final VkImageView imageView : imageViews)
		{
			fillAttachements(attachments, imageView.getAddress(), configuration);

			Logger.check("Failed to create framebuffer!",
					() -> vkCreateFramebuffer(vkDevice, createInfo, null, aFramebufferId));
			framebuffersIds.add(aFramebufferId[0]);
		}

		framebuffersIds = List.copyOf(framebuffersIds);
	}

	private void fillAttachements(	LongBuffer attachments,
									long imageViewId,
									FramebufferConfiguration configuration)
	{
		attachments.put(imageViewId);

		clearInfos = new ArrayList<>();
		clearInfos.add(new ClearInfo(false, configuration.getClearValue()));

		for (final IFramebufferAttachment attachement : configuration.getAtachments())
		{
			long viewAddress = -1;
			if (attachement instanceof DepthFramebufferAttachment)
			{
				final var depthImage = ((DepthFramebufferAttachment) attachement)
						.getDepthImageRef();
				final var adapter = DepthImageAdapter.adapt(depthImage);
				viewAddress = adapter.getDepthImageViewId();
				depthAttachment = true;
				clearInfos.add(new ClearInfo(true, null));
			}
			else if (attachement instanceof ImageFramebufferAttachment)
			{
				final var attachment = (ImageFramebufferAttachment) attachement;
				final var image = attachment.getImageRef();
				final var adapter = ImageAdapter.adapt(image);
				viewAddress = adapter.getViewAddress();
				clearInfos.add(new ClearInfo(false, attachment.getClearValue()));
			}
			attachments.put(viewAddress);
		}

		clearInfos = List.copyOf(clearInfos);

		attachments.flip();
	}

	private LongBuffer allocAttachments(MemoryStack stack, FramebufferConfiguration configuration)
	{
		int attachementCount = 1;
		attachementCount += configuration.getAtachments().size();
		final var attachments = stack.mallocLong(attachementCount);
		return attachments;
	}

	private static VkFramebufferCreateInfo allocCreateInfo(	MemoryStack stack,
															GraphicContext graphicContext,
															LongBuffer attachments)
	{
		final var extent = graphicContext.surfaceManager.getExtent();
		final var createInfo = VkFramebufferCreateInfo.callocStack(stack);
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
		final var graphicContext = (GraphicContext) context;
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
		final var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context)
				|| graphicContext.imageViewManager.isAllocationDirty(context);
	}

	public boolean hasDepthAttachment()
	{
		return depthAttachment;
	}

	public List<ClearInfo> getClearInfos()
	{
		return clearInfos;
	}

	public class ClearInfo
	{
		public final boolean isdepthStencil;
		public final Vector4fc color;

		public ClearInfo(boolean isdepthStencil, Vector4fc color)
		{
			this.isdepthStencil = isdepthStencil;
			this.color = color;
		}
	}
}
