package org.sheepy.lily.vulkan.process.graphic.execution;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_SUBPASS_CONTENTS_INLINE;
import static org.lwjgl.vulkan.VK10.vkCmdNextSubpass;

public final class GraphicExecutionRecorder extends AbstractExecutionRecorder<GraphicContext>
{
	private final GraphicProcess process;
	private final PresentSubmission presentSubmission;
	private final VkSemaphore presentSemaphore;
	private final Runnable subpassListener = this::countSubpasses;

	private int subpassCount;

	public GraphicExecutionRecorder(GraphicProcess process,
									GraphicCommandBuffer commandBuffer,
									Submission<GraphicContext> submission,
									PresentSubmission presentSubmission,
									VkSemaphore presentSemaphore,
									int index)
	{
		super(commandBuffer, submission, index);
		this.process = process;
		this.presentSubmission = presentSubmission;
		this.presentSemaphore = presentSemaphore;
		countSubpasses();
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		config.addChildren(List.of(presentSemaphore));
		super.configureAllocation(config, context);
		config.addChildren(List.of(presentSubmission));
	}

	@Override
	public void allocate(GraphicContext context)
	{
		super.allocate(context);
		process.listenNoParam(subpassListener, GraphicPackage.GRAPHIC_PROCESS__SUBPASSES);
	}

	@Override
	public void free(GraphicContext context)
	{
		process.sulkNoParam(subpassListener, GraphicPackage.GRAPHIC_PROCESS__SUBPASSES);
		super.free(context);
	}

	@Override
	protected void recordCommand(GraphicContext graphicContext, RecordContext recordContext)
	{
		final var graphicProcess = (GraphicProcess) graphicContext.getProcess();
		final var subpasses = graphicProcess.getSubpasses();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var stage = recordContext.stage;
		int current = 0;

		while (current < subpassCount)
		{
			if (stage == ECommandStage.RENDER && current != 0)
			{
				vkCmdNextSubpass(vkCommandBuffer, VK_SUBPASS_CONTENTS_INLINE);
			}

			for (int i = 0; i < subpasses.size(); i++)
			{
				final var subpass = subpasses.get(i);
				final int subpassIndex = subpass.getSubpassIndex();

				if (subpassIndex == current)
				{
					record(subpass, recordContext);
				}
			}

			current++;
		}
	}

	@Override
	public IFenceView play()
	{
		final var res = super.play();
		presentSubmission.submit();
		return res;
	}

	private void countSubpasses()
	{
		int res = 0;
		for (final var subpass : process.getSubpasses())
		{
			final int subpassIndex = subpass.getSubpassIndex() + 1;
			if (subpassIndex > res)
			{
				res = subpassIndex;
			}
		}
		subpassCount = res;
	}

	private static void record(Subpass subpass, RecordContext recordContext)
	{
		final var pipelinePkg = subpass.getPipelinePkg();
		if (pipelinePkg != null)
		{
			final var pipelines = pipelinePkg.getPipelines();
			for (int i = 0; i < pipelines.size(); i++)
			{
				final var pipeline = pipelines.get(i);
				record(recordContext, pipeline);
			}
		}
	}
}
