package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;

public interface IDescriptorAdapter extends IAllocableAdapter<IExecutionContext>
{
	IVkDescriptor getVkDescriptor();
}
