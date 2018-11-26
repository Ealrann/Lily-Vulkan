package org.sheepy.vulkan.process.graphic.pool;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.lwjgl.vulkan.VkAttachmentDescription.Buffer;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.process.graphic.pipeline.VkSubpassDependencyAllocator;
import org.sheepy.vulkan.resource.image.DepthImageAdapter;

public class RenderPass implements IBasicAllocable
{
	private final GraphicContext context;

	private VkSubpassDescription.Buffer subpass;
	private VkAttachmentReference.Buffer colorAttachmentRef;

	private long renderPass;

	public RenderPass(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		final var renderPassInfo = context.graphicProcessPool.getRenderPassInfo();
		final var attachmentCount = renderPassInfo.getAttachments().size();
		final var attachments = VkAttachmentDescription.callocStack(attachmentCount, stack);
		final int colorAttachmentCount = countColorAttachments(renderPassInfo);

		subpass = VkSubpassDescription.callocStack(1, stack);
		subpass.pipelineBindPoint(renderPassInfo.getBindPoint());
		subpass.colorAttachmentCount(colorAttachmentCount);

		createAttachments(stack, renderPassInfo, attachments, colorAttachmentCount);

		subpass.pColorAttachments(colorAttachmentRef);

		final var dependencyInfos = renderPassInfo.getDependencies();
		final var dependencies = VkSubpassDependencyAllocator.allocate(stack, dependencyInfos);

		final VkRenderPassCreateInfo createInfo = VkRenderPassCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		createInfo.pAttachments(attachments);
		createInfo.pSubpasses(subpass);
		createInfo.pDependencies(dependencies);

		final long[] aRenderPass = new long[1];
		Logger.check("Failed to create render pass!",
				() -> vkCreateRenderPass(context.getVkDevice(), createInfo, null, aRenderPass));
		renderPass = aRenderPass[0];
	}

	private static int countColorAttachments(final RenderPassInfo renderPassInfo)
	{
		int colorAttachmentCount = 0;
		for (final AttachmentDescription attachmentDescription : renderPassInfo.getAttachments())
		{
			if (attachmentDescription.isStencil() == false)
			{
				colorAttachmentCount++;
			}
		}
		return colorAttachmentCount;
	}

	private void createAttachments(	MemoryStack stack,
									final RenderPassInfo renderPassInfo,
									final Buffer attachments,
									int colorAttachmentCount)
			throws AssertionError
	{
		colorAttachmentRef = VkAttachmentReference.callocStack(colorAttachmentCount, stack);
		int index = 0;
		for (final AttachmentDescription attachmentDescription : renderPassInfo.getAttachments())
		{
			fillAttachment(attachments.get(), attachmentDescription);
			fillAttachmentRef(stack, index, attachmentDescription);
			index++;
		}
		attachments.flip();
		colorAttachmentRef.flip();
	}

	private void fillAttachmentRef(	MemoryStack stack,
									final int index,
									final AttachmentDescription attachmentDescription)
			throws AssertionError
	{
		final var attachmentRef = VkAttachmentReference.callocStack(stack);
		attachmentRef.attachment(index);

		if (attachmentDescription.isStencil())
		{
			if (subpass.pDepthStencilAttachment() != null)
			{
				throw new AssertionError("Multiple Stencil Atachments");
			}

			attachmentRef.layout(VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			subpass.pDepthStencilAttachment(attachmentRef);
		}
		else
		{
			attachmentRef.layout(VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL);
			colorAttachmentRef.put(attachmentRef);
		}
	}

	private void fillAttachment(final VkAttachmentDescription attachment,
								final AttachmentDescription attachmentDescription)
	{
		var format = getAttachmentFormat(attachmentDescription);
		attachment.format(format);
		attachment.samples(attachmentDescription.getSamples().getValue());
		attachment.loadOp(attachmentDescription.getLoadOp().getValue());
		attachment.storeOp(attachmentDescription.getStoreOp().getValue());
		attachment.stencilLoadOp(attachmentDescription.getStencilLoadOp().getValue());
		attachment.stencilStoreOp(attachmentDescription.getStencilStoreOp().getValue());
		attachment.initialLayout(attachmentDescription.getInitialLayout().getValue());
		attachment.finalLayout(attachmentDescription.getFinalLayout().getValue());
	}

	private int getAttachmentFormat(final AttachmentDescription attachmentDescription)
	{
		if (attachmentDescription.isStencil())
		{
			var depthImage = context.graphicProcessPool.getDepthImage();
			var adapter = DepthImageAdapter.adapt(depthImage);
			return adapter.getDepthImageFormat();
		}
		else
		{
			return context.swapChainManager.getColorDomain().getFormat().getValue();
		}
	}

	@Override
	public void free()
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPass, null);
	}

	public long getId()
	{
		return renderPass;
	}

	@Override
	public boolean isDirty()
	{
		return context.swapChainManager.isDirty();
	}
}
