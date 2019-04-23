package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IRenderPass;
import org.sheepy.lily.vulkan.process.graphic.renderpass.VkRenderPassAllocator;
import org.sheepy.vulkan.allocation.IAllocationContext;

public class RenderPass implements IRenderPass
{
	private long renderPass;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var renderPassInfo = graphicContext.getGraphicProcess().getRenderPassInfo();
		final var format = graphicContext.getSurfaceManager().getColorDomain().getFormat();

		final var renderPassAllocator = new VkRenderPassAllocator(graphicContext.getVkDevice(),
				format);
		renderPass = renderPassAllocator.allocate(stack, renderPassInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		vkDestroyRenderPass(graphicContext.getVkDevice(), renderPass, null);
		renderPass = -1;
	}

	@Override
	public long getAddress()
	{
		return renderPass;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		return graphicContext.getSwapChainManager().isAllocationDirty(context);
	}
}
