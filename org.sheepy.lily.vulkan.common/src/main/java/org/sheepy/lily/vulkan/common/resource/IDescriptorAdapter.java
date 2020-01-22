package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IDescriptorAdapter extends IAllocableAdapter<IExecutionContext>
{
	IVkDescriptor getVkDescriptor();
}
