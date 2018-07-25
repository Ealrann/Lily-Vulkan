package org.sheepy.vulkan.descriptor;

import java.util.List;

public interface IDescriptorSetContext
{
	List<IDescriptor> getDescriptors();
	long getLayoutId();
}
