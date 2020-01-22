package org.sheepy.lily.vulkan.common.resource.attachment;

import org.sheepy.lily.vulkan.common.graphic.ClearInfo;

public interface IDepthAttachmentAdapter extends IExtraAttachmentAdapter
{
	@Override
	default boolean isDepthAttachment()
	{
		return true;
	}

	@Override
	default ClearInfo getClearInfos()
	{
		return new ClearInfo(true, null);
	}
}