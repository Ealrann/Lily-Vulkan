package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class GraphicExecutionRecorder extends AbstractExecutionRecorder<IGraphicContext>
{
	private final GraphicProcess process;
	private final PresentSubmission presentSubmission;
	private final VkSemaphore presentSemaphore;
	private final INotificationListener subpassListener = this::subpassChanged;

	private int subpassCount = 0;

	public GraphicExecutionRecorder(GraphicProcess process,
									GraphicCommandBuffer commandBuffer,
									Submission<IGraphicContext> submission,
									PresentSubmission presentSubmission,
									VkSemaphore presentSemaphore,
									int index)
	{
		super(commandBuffer, submission, index);
		this.process = process;
		this.presentSubmission = presentSubmission;
		this.presentSemaphore = presentSemaphore;
		subpassCount = countSubpasses(process);
	}

	private void subpassChanged(Notification notification)
	{
		subpassCount = countSubpasses(process);
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		super.allocate(context);
		process.addListener(subpassListener, GraphicPackage.GRAPHIC_PROCESS__SUBPASSES);
	}

	@Override
	public void free(IGraphicContext context)
	{
		process.removeListener(subpassListener, GraphicPackage.GRAPHIC_PROCESS__SUBPASSES);
		super.free(context);
	}

	@Override
	public final void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addChildren(List.of(presentSemaphore));
		super.configureAllocation(config, context);
		config.addChildren(List.of(presentSubmission));
	}

	@Override
	protected void recordCommand(IGraphicContext graphicContext, RecordContext recordContext)
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

	private static void record(Subpass subpass, RecordContext recordContext)
	{
		final var pipelinePkg = subpass.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (final var pipeline : pipelinePkg.getPipelines())
			{
				final var adapter = pipeline.adapt(IPipelineAdapter.class);
				if (adapter != null)
				{
					adapter.record(recordContext);
				}
			}
		}
	}

	private static int countSubpasses(GraphicProcess process)
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
		return res;
	}
}
