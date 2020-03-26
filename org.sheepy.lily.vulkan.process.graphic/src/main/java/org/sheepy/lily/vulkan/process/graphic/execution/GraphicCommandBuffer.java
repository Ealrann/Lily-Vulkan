package org.sheepy.lily.vulkan.process.graphic.execution;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.*;

public class GraphicCommandBuffer extends AbstractCommandBuffer<IGraphicContext>
{
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";

	public final int index;

	private VkClearValue.Buffer clearValues;
	private VkRenderPassBeginInfo renderPassInfo;
	private VkCommandBufferBeginInfo beginInfo;

	public GraphicCommandBuffer(int index)
	{
		this.index = index;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addDependency(context.getFramebufferManager());
		config.addDependency(context.getRenderPass());
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var extent = context.getSurfaceManager().getExtent();
		final var framebufferManager = context.getFramebufferManager();
		final var renderPass = context.getRenderPass();
		final var framebufferId = framebufferManager.getFramebufferAddresses().get(index);
		final var clearInfos = renderPass.getClearInfos();
		final int clearCount = clearInfos.size();

		clearValues = VkClearValue.malloc(clearCount);

		for (final var clearInfo : clearInfos)
		{
			final VkClearValue clearValue = clearValues.get();
			if (clearInfo.isdepthStencil == false)
			{
				clearValue.color().float32(0, clearInfo.color.x());
				clearValue.color().float32(1, clearInfo.color.y());
				clearValue.color().float32(2, clearInfo.color.z());
				clearValue.color().float32(3, clearInfo.color.w());
			}
			else
			{
				clearValue.depthStencil().set(1.0f, 0);
			}
		}
		clearValues.flip();

		renderPassInfo = VkRenderPassBeginInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassInfo.renderPass(context.getRenderPass().getPtr());
		renderPassInfo.framebuffer(framebufferId);
		renderPassInfo.renderArea().offset().set(0, 0);
		renderPassInfo.renderArea().extent().set(extent.x(), extent.y());
		renderPassInfo.pClearValues(clearValues);

		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);

		super.allocate(context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		if (clearValues != null)
		{
			clearValues.free();
			clearValues = null;
		}

		renderPassInfo.free();
		renderPassInfo = null;

		beginInfo.free();
		beginInfo = null;

		super.free(context);
	}

	@Override
	public void start(ECommandStage stage)
	{
		switch (stage)
		{
			case TRANSFER -> Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo),
										  FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
			case RENDER -> vkCmdBeginRenderPass(vkCommandBuffer, renderPassInfo, VK_SUBPASS_CONTENTS_INLINE);
		}
	}

	@Override
	public void end(ECommandStage stage)
	{
		switch (stage)
		{
			case RENDER -> vkCmdEndRenderPass(vkCommandBuffer);
			case POST_RENDER -> Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
		}
	}
}
