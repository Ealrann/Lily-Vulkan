package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.graphic.ClearInfo;

public interface IDepthAttachmentAdapter extends IExtraAttachmentAdapter
{
	@Override
	default ClearInfo getClearInfos()
	{
		return new ClearInfo(true, null);
	}
}