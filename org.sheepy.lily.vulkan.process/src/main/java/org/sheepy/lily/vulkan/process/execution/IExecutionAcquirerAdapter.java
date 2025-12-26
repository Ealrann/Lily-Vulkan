package org.sheepy.lily.vulkan.process.execution;

import org.logoce.lmf.core.api.extender.IAdapter;

import java.util.stream.Stream;

public interface IExecutionAcquirerAdapter extends IAdapter
{
	AcquisitionInfo acquire();

	Stream<WaitData> streamAcquireSemaphores();

	record AcquisitionInfo(int executionID, int recordIndex)
	{
	}
}

