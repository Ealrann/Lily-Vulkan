package org.sheepy.lily.vulkan.core.descriptor;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

public interface IDescriptorAllocation extends IAdapter
{
	IVkDescriptor getVkDescriptor();
	void attach(IRecordContext recordContext);
}
