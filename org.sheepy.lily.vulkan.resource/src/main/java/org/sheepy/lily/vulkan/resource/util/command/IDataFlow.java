package org.sheepy.lily.vulkan.resource.util.command;

import org.sheepy.lily.vulkan.core.execution.RecordContext;

public sealed interface IDataFlow permits FetchBufferData, PushBufferData, PushImageData
{
	EFlowType getFlowType();
	void record(RecordContext recordContext);
}
