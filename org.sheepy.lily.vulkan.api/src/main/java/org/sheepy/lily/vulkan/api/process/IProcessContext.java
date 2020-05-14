package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

public interface IProcessContext extends IExecutionContext
{
	AbstractProcess getProcess();
}
