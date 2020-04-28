package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;

public interface IDepthAttachmentAllocation<T extends ExecutionContext> extends IExtraAttachmentAllocation<T>
{
	@Override
	default ClearInfo getClearInfos()
	{
		return new ClearInfo(true, null);
	}
}
