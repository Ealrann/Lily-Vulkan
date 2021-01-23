package org.sheepy.lily.vulkan.core.descriptor;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

public interface IDescriptorSetAllocation extends IAdapter
{
	long getPtr();
	void attach(IRecordContext recordContext);
}
