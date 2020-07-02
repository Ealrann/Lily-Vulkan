package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class GenericExecutionRecorder
{
	private final AbstractCommandBuffer commandBuffer;
	private final Submission submission;
	private final int index;
	private final int indexCount;
	private final Consumer<RecordContext> doRecord;

	public GenericExecutionRecorder(AbstractCommandBuffer commandBuffer,
									Submission submission,
									int index,
									int indexCount,
									Consumer<RecordContext> doRecord)
	{
		this.commandBuffer = commandBuffer;
		this.submission = submission;
		this.index = index;
		this.indexCount = indexCount;
		this.doRecord = doRecord;
	}

	public void record(List<ECommandStage> stages)
	{
		final List<VkFence.IFenceListener> listeners = new ArrayList<>();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		try (final var stack = MemoryStack.stackPush())
		{
			for (int i = 0; i < stages.size(); i++)
			{
				final var stage = stages.get(i);
				final var context = new RecordContext(vkCommandBuffer, stage, index,indexCount, stack);

				commandBuffer.start(stage);
				doRecord.accept(context);
				commandBuffer.end(stage);
				listeners.addAll(context.getExecutionListeners());
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		if (listeners.isEmpty() == false) submission.setNextExecutionListeners(listeners);
	}
}
