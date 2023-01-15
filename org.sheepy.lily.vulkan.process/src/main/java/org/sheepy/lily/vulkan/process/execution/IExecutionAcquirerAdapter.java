package org.sheepy.lily.vulkan.process.execution;

import org.logoce.extender.api.IAdapter;

import java.util.stream.Stream;

public interface IExecutionAcquirerAdapter extends IAdapter
{
	AcquisitionInfo acquire();

	Stream<WaitData> streamAcquireSemaphores();

	record AcquisitionInfo(int executionID, int recordIndex)
	{
	}
}
