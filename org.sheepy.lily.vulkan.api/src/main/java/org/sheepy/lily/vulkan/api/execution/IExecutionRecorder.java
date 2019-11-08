package org.sheepy.lily.vulkan.api.execution;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.execution.IRecordable;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IExecutionRecorder<T extends IProcessContext>
		extends IExecutionPlayer, IAllocable<T>
{
	ICommandBuffer<? super T> getCommandBuffer();

	ISubmission<? super T> getSubmission();

	boolean isDirty();

	void setDirty(boolean dirty);

	void record(List<? extends IRecordable> recordables, List<ECommandStage> stages);
}
