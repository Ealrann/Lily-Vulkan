package org.sheepy.lily.vulkan.process.graphic.execution;

import org.lwjgl.vulkan.VkClearValue;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkRenderPassBeginInfo;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.execution.AbstractProcessCommandBufferHelper;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.SubpassRecorder;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class GraphicCommandBufferHelper extends AbstractProcessCommandBufferHelper
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.PRE_RENDER,
															  ECommandStage.MAIN,
															  ECommandStage.POST_RENDER);
	private static final String FAILED_TO_RECORD_COMMAND_BUFFER = "Failed to record command buffer";
	private static final String FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER = "Failed to begin recording command buffer";

	private final VkClearValue.Buffer clearValues;
	private final VkRenderPassBeginInfo renderPassBeginInfo;
	private final VkCommandBufferBeginInfo beginInfo;
	private final int subpassCount;

	public GraphicCommandBufferHelper(final ExecutionContext context,
									  final PhysicalSurfaceAllocation surfaceAllocation,
									  final RenderPassAllocation renderPassAllocation,
									  final long framebufferPtr,
									  final int subpassCount,
									  final RecordInfo recordInfo)
	{
		super(context, stages, recordInfo);
		this.subpassCount = subpassCount;

		final var clearInfos = renderPassAllocation.getClearInfos();
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

		final var extent = surfaceAllocation.getExtent();
		renderPassBeginInfo = VkRenderPassBeginInfo.calloc();
		renderPassBeginInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO);
		renderPassBeginInfo.framebuffer(framebufferPtr);
		renderPassBeginInfo.pClearValues(clearValues);
		renderPassBeginInfo.renderPass(renderPassAllocation.getPtr());
		renderPassBeginInfo.renderArea().offset().set(0, 0);
		renderPassBeginInfo.renderArea().extent().set(extent.x(), extent.y());

		beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null);
	}

	@Override
	public void free(ExecutionContext context)
	{
		if (clearValues != null) clearValues.free();

		renderPassBeginInfo.free();
		beginInfo.free();
		super.free(context);
	}

	@Override
	protected void recordStage(List<IRecordableAdapter> recordables, final RecordContext recordContext)
	{
		final var stage = recordContext.stage;
		int current = 0;

		while (current < subpassCount)
		{
			if (stage == ECommandStage.MAIN && current != 0)
			{
				vkCmdNextSubpass(vkCommandBuffer, VK_SUBPASS_CONTENTS_INLINE);
			}

			for (int i = 0; i < recordables.size(); i++)
			{
				final var subpass = (SubpassRecorder) recordables.get(i);
				final int subpassIndex = subpass.getSubpassIndex();
				if (stage != ECommandStage.MAIN || subpassIndex == current)
				{
					subpass.record(recordContext);
				}
			}

			current++;
		}
	}

	@Override
	protected void start(ECommandStage stage)
	{
		switch (stage)
		{
			case PRE_RENDER -> Logger.check(vkBeginCommandBuffer(vkCommandBuffer, beginInfo),
											FAILED_TO_BEGIN_RECORDING_COMMAND_BUFFER);
			case MAIN -> vkCmdBeginRenderPass(vkCommandBuffer, renderPassBeginInfo, VK_SUBPASS_CONTENTS_INLINE);
		}
	}

	@Override
	protected void end(ECommandStage stage)
	{
		switch (stage)
		{
			case MAIN -> vkCmdEndRenderPass(vkCommandBuffer);
			case POST_RENDER -> Logger.check(vkEndCommandBuffer(vkCommandBuffer), FAILED_TO_RECORD_COMMAND_BUFFER);
		}
	}
}
