package org.sheepy.lily.vulkan.core.descriptor;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

public interface IDescriptorSetAllocation extends IExtender
{
	long getPtr();
	void attach(IRecordContext recordContext);
}
