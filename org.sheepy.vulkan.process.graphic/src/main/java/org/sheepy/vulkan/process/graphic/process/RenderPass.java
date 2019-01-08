package org.sheepy.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.nativehelper.VkRenderPassAllocator;

public class RenderPass implements IBasicAllocable
{
	private final GraphicContext context;

	private long renderPass;

	public RenderPass(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		var renderPassInfo = context.graphicProcess.getRenderPassInfo();
		var format = context.swapChainManager.getColorDomain().getFormat();

		var renderPassAllocator = new VkRenderPassAllocator(context.getVkDevice(), format);
		renderPass = renderPassAllocator.allocate(stack, renderPassInfo);
	}

	@Override
	public void free()
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPass, null);
		renderPass = -1;
	}

	public long getId()
	{
		return renderPass;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return context.swapChainManager.isAllocationDirty();
	}
}
