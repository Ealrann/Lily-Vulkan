package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IRenderPass;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

@ModelExtender(scope = RenderPass.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.RENDER_PASS__ATTACHMENTS, type = IExtraAttachmentAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(features = GraphicPackage.RENDER_PASS__ATTACHMENTS, type = IExtraAttachmentAllocation.class)
public final class RenderPassAllocation implements IRenderPass, IAllocation
{
	private final List<IExtraAttachmentAllocation> extraAttachments;
	private final long renderPassPtr;
	private final List<ClearInfo> clearInfos;

	private RenderPassAllocation(RenderPass renderPass,
								 ProcessContext context,
								 @InjectDependency(type = PhysicalSurfaceAllocation.class) PhysicalSurfaceAllocation surfaceAllocation,
								 @InjectDependency(type = IExtraAttachmentAllocation.class) List<IExtraAttachmentAllocation> attachmentAllocations)
	{
		final var stack = context.stack();
		final var format = surfaceAllocation.getColorDomain().format;
		final var process = (GraphicProcess) renderPass.eContainer().eContainer();
		final var swapConfig = process.getConfiguration().getSwapchainConfiguration();
		clearInfos = computeClearInfos(attachmentAllocations, swapConfig);
		extraAttachments = List.copyOf(attachmentAllocations);
		final var renderPassAllocator = new VkRenderPassAllocator(context.getVkDevice(), renderPass, format);
		renderPassPtr = renderPassAllocator.allocate(stack, process);
	}

	@Free
	private void free(ProcessContext context)
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPassPtr, null);
	}

	@Override
	public long getPtr()
	{
		return renderPassPtr;
	}

	@Override
	public List<ClearInfo> getClearInfos()
	{
		return clearInfos;
	}

	public List<IExtraAttachmentAllocation> getUsedExtraAttachments()
	{
		return extraAttachments;
	}

	private static List<ClearInfo> computeClearInfos(List<IExtraAttachmentAllocation> attachmentAllocations,
													 SwapchainConfiguration swapConfig)
	{
		final List<ClearInfo> clearInfos = new ArrayList<>();
		clearInfos.add(new ClearInfo(false, swapConfig.getColorAttachment().getClearValue()));
		for (final var attachment : attachmentAllocations)
		{
			clearInfos.add(attachment.getClearInfos());
		}
		return List.copyOf(clearInfos);
	}
}
