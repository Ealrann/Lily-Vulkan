package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.DescriptorPool;

public interface IProcessContext extends IExecutionContext
{
	DescriptorPool getDescriptorPool();
}
