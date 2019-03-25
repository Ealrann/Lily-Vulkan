package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.VkRenderPassAllocator;

public class RenderPass implements IAllocable
{
	private long renderPass;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var renderPassInfo = graphicContext.graphicProcess.getRenderPassInfo();
		final var format = graphicContext.surfaceManager.getColorDomain().getFormat();

		final var renderPassAllocator = new VkRenderPassAllocator(graphicContext.getVkDevice(),
				format);
		renderPass = renderPassAllocator.allocate(stack, renderPassInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		vkDestroyRenderPass(graphicContext.getVkDevice(), renderPass, null);
		renderPass = -1;
	}

	public long getId()
	{
		return renderPass;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context);
	}
}
