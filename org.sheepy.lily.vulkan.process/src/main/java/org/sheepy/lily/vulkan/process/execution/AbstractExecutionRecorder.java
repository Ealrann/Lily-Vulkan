package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.execution.ISubmission;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public abstract class AbstractExecutionRecorder<T extends IProcessContext>
		implements IExecutionRecorder<T>, IAllocable<T>
{
	protected final ICommandBuffer<? super T> commandBuffer;
	protected final ISubmission<? super T> submission;
	private final List<IAllocable<? super T>> allocationList;

	protected final int index;

	private boolean dirty = true;
	private T context;

	public AbstractExecutionRecorder(	ICommandBuffer<? super T> commandBuffer,
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

		try (MemoryStack stack = MemoryStack.stackPush())
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
		} catch (final Exception e)
		{
			e.printStackTrace();
		}

		submission.setExecutionIdleListeners(listeners);

		setDirty(false);
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
