package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.graphic.ClearInfo;

public interface IDepthAttachmentAllocation extends IExtraAttachmentAllocation
{
	@Override
	default ClearInfo getClearInfos()
	{
		return new ClearInfo(true, null);
	}
}
