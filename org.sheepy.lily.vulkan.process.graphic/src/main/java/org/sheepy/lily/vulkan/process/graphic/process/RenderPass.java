package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.nativehelper.VkRenderPassAllocator;

public class RenderPass implements IAllocable
{
	private long renderPass;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		var renderPassInfo = graphicContext.graphicProcess.getRenderPassInfo();
		var format = graphicContext.surfaceManager.getColorDomain().getFormat();

		var renderPassAllocator = new VkRenderPassAllocator(graphicContext.getVkDevice(), format);
		renderPass = renderPassAllocator.allocate(stack, renderPassInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
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
		var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context);
	}
}
