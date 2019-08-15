package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IRenderPass;
import org.sheepy.lily.vulkan.process.graphic.renderpass.VkRenderPassAllocator;

public class RenderPass implements IRenderPass
{
	private long renderPass;

	@Override
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();

		config.addDependencies(List.of(swapChainManager));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var stack = context.stack();
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
}
