package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

public interface IExecutionRecorder extends IExecutionPlayer
{
	ICommandBuffer getCommandBuffer();
	ISubmission getSubmission();

	boolean isDirty();
	void setDirty(boolean dirty);
	void record(List<ECommandStage> stages);
}
