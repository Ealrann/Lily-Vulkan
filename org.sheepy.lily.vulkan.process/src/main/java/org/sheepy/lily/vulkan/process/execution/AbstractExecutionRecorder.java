package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.lily.vulkan.core.execution.ISubmission;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.core.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExecutionRecorder<T extends IProcessContext> implements IExecutionRecorder<T>,
																					  IAllocable<T>
{
	protected final ICommandBuffer<? super T> commandBuffer;
	protected final ISubmission<? super T> submission;
	private final List<IAllocable<? super T>> allocationList;

	protected final int index;

	private boolean dirty = true;
	private T context;

	public AbstractExecutionRecorder(ICommandBuffer<? super T> commandBuffer,
									 ISubmission<? super T> submission,
									 int index)
	{
		this.commandBuffer = commandBuffer;
		this.submission = submission;
		this.index = index;

		allocationList = List.of(commandBuffer, submission);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, T context)
	{
		config.addChildren(allocationList);
	}

	@Override
	public void allocate(T context)
	{
		this.context = context;
	}

	@Override
	public void free(T context)
	{
		this.context = null;
	}

	@Override
	public final void record(List<ECommandStage> stages)
	{
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
	public ICommandBuffer<? super T> getCommandBuffer()
	{
		return commandBuffer;
	}

	@Override
	public ISubmission<? super T> getSubmission()
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

	protected abstract void recordCommand(T processContext, RecordContext recordContext);

}
