package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.vulkan.api.graphic.ClearInfo;

public interface IDepthAttachmentAdapter extends ISwapAttachmentAdapter
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