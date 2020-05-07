package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFramebufferCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.graphic.IFramebufferManager;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAllocation;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = FramebufferConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, type = ImageViewAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, type = RenderPassAllocation.class)
public final class FramebufferAllocation implements IFramebufferManager, IAllocation
{
	private static final String FAILED_TO_CREATE_FRAMEBUFFER = "Failed to create framebuffer";

	private final List<Long> framebuffersPtrs;

	private FramebufferAllocation(ProcessContext context,
								  @InjectDependency(type = PhysicalSurfaceAllocation.class) PhysicalSurfaceAllocation surfaceAllocation,
								  @InjectDependency(type = ImageViewAllocation.class) ImageViewAllocation imageViewsAllocation,
								  @InjectDependency(type = RenderPassAllocation.class) RenderPassAllocation renderPassAllocation)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		final var vkImageViews = imageViewsAllocation.getImageViews();
		final var aFramebufferId = new long[1];
		final var attachments = renderPassAllocation.getUsedExtraAttachments();

		final List<Long> framebuffersIdsTmp = new ArrayList<>(vkImageViews.size());
		for (final var imageView : vkImageViews)
		{
			final var attachmentsBuffer = allocAttachments(stack, attachments, imageView.getPtr());
			final var createInfo = allocCreateInfo(stack, surfaceAllocation, renderPassAllocation, attachmentsBuffer);
			Logger.check(vkCreateFramebuffer(vkDevice, createInfo, null, aFramebufferId), FAILED_TO_CREATE_FRAMEBUFFER);
			framebuffersIdsTmp.add(aFramebufferId[0]);
		}

		framebuffersPtrs = List.copyOf(framebuffersIdsTmp);
	}

	private static LongBuffer allocAttachments(MemoryStack stack,
											   List<IExtraAttachmentAllocation> attachments,
											   long imageViewId)
	{
		final var attachmentsBuffer = stack.mallocLong(attachments.size() + 1);
		attachmentsBuffer.put(imageViewId);

		for (final var attachment : attachments)
		{
			attachmentsBuffer.put(attachment.getViewPtr());
		}

		attachmentsBuffer.flip();
		return attachmentsBuffer;
	}

	private static VkFramebufferCreateInfo allocCreateInfo(MemoryStack stack,
														   PhysicalSurfaceAllocation surfaceAllocation,
														   RenderPassAllocation renderPassAllocation,
														   LongBuffer attachments)
	{
		final var extent = surfaceAllocation.getExtent();
		final var createInfo = VkFramebufferCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO);
		createInfo.renderPass(renderPassAllocation.getPtr());
		createInfo.width(extent.x());
		createInfo.height(extent.y());
		createInfo.layers(1);
		createInfo.pAttachments(attachments);
		return createInfo;
	}

	@Free
	private void free(ProcessContext context)
	{
		for (final long framebuffer : framebuffersPtrs)
		{
			vkDestroyFramebuffer(context.getVkDevice(), framebuffer, null);
		}
	}

	@Override
	public List<Long> getFramebufferAddresses()
	{
		return framebuffersPtrs;
	}

	public int size()
	{
		return framebuffersPtrs != null ? framebuffersPtrs.size() : 0;
	}
}
