package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.execution.*;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExecutionRecorder implements IExecutionRecorder
{
	protected final AbstractCommandBuffer commandBuffer;
	protected final Submission submission;
	protected final int index;
	private final ProcessContext context;

	private boolean dirty = true;

	public AbstractExecutionRecorder(AbstractCommandBuffer commandBuffer,
									 final ProcessContext context,
									 Submission submission,
									 int index)
	{
		this.commandBuffer = commandBuffer;
		this.context = context;
		this.submission = submission;
		this.index = index;
	}

	public void free(ExecutionContext context)
	{
		commandBuffer.free(context);
		submission.free();
	}

	@Override
	public final void record(List<ECommandStage> stages)
	{
		//TODO remove this wait...
		waitIdle();

		final List<IExecutionIdleListener> listeners = new ArrayList<>();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		try (final var stack = MemoryStack.stackPush())
		{
			for (int i = 0; i < stages.size(); i++)
			{
				final var stage = stages.get(i);
				final var context = new RecordContext(vkCommandBuffer, stage, index, stack);

				commandBuffer.start(stage);
				recordCommand(this.context, context);
				commandBuffer.end(stage);
				listeners.addAll(context.getExecutionIdleListeners());
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		submission.setExecutionIdleListeners(listeners);

		setDirty(false);
	}

	protected static void record(RecordContext recordContext, final AbstractPipeline pipeline)
	{
		if (pipeline instanceof CompositePipeline)
		{
			final var compositePipeline = (CompositePipeline) pipeline;
			final int repeat = compositePipeline.getRepeat();
			for (int i = 0; i < repeat; i++)
			{
				for (final var subPipeline : compositePipeline.getPipelines())
				{
					record(recordContext, subPipeline);
				}
			}
		}
		else
		{
			final var adapter = pipeline.adapt(IPipelineAdapter.class);
			if (adapter != null)
			{
				adapter.record(recordContext);
			}
		}
	}

	public boolean isBusy()
	{
		return submission.isBusy();
	}

	@Override
	public void checkFence()
	{
		submission.checkFence();
	}

	@Override
	public void waitIdle()
	{
		submission.waitIdle();
	}

	@Override
	public IFenceView play()
	{
		return submission.submit();
	}

	@Override
	public ICommandBuffer getCommandBuffer()
	{
		return commandBuffer;
	}

	@Override
	public ISubmission getSubmission()
	{
		return submission;
	}

	@Override
	public boolean isDirty()
	{
		return dirty;
	}

	@Override
	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	protected abstract void recordCommand(ProcessContext processContext, RecordContext recordContext);

}
