package org.sheepy.lily.vulkan.api.execution;

import java.util.List;

import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

public interface IExecutionRecorder extends IExecutionPlayer
{
	ICommandBuffer getCommandBuffer();

	ISubmission getSubmission();

	boolean isDirty();

	void setDirty(boolean dirty);

	void record(List<? extends IRecordable> recordables, List<ECommandStage> stages);
}
