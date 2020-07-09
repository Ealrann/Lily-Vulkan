package org.sheepy.lily.vulkan.core.descriptor;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.game.api.execution.IRecordContext;

public interface IDescriptorSetAllocation extends IExtender
{
	long getPtr();
	void attach(IRecordContext recordContext);
}
