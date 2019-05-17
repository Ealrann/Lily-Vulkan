package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IRenderPass;
import org.sheepy.lily.vulkan.process.graphic.renderpass.VkRenderPassAllocator;

public class RenderPass implements IRenderPass
{
	private long renderPass;

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		final var renderPassInfo = context.getGraphicProcess().getRenderPassInfo();
		final var format = context.getSurfaceManager().getColorDomain().getFormat();

		final var renderPassAllocator = new VkRenderPassAllocator(context.getVkDevice(), format);
		renderPass = renderPassAllocator.allocate(stack, renderPassInfo);
	}

	@Override
	public void free(IGraphicContext context)
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPass, null);
		renderPass = -1;
	}

	@Override
	public long getAddress()
	{
		return renderPass;
	}

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getSwapChainManager().isAllocationDirty(context);
	}
}
