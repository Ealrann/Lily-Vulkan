package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.graphic.ClearInfo;

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