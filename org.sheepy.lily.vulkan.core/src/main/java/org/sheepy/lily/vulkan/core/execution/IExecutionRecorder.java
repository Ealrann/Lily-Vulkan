package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

public interface IExecutionRecorder<T extends ExecutionContext> extends IExecutionPlayer, IAllocable<T>
{
	ICommandBuffer<? super T> getCommandBuffer();

	ISubmission<? super T> getSubmission();

	boolean isDirty();

	void setDirty(boolean dirty);

	void record(List<ECommandStage> stages);
}
