package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IPipelineTaskRecorder extends IRecordableExtender
{
	default ECommandStage getStage()
	{
		return ECommandStage.INHERITED;
	}
}
