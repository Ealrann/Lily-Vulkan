package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IPipelineRecordable extends IRecordableExtender
{
	boolean shouldRecord(ECommandStage stage);
	@Override
	boolean isActive();
}
