package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.nativehelper.ClearInfo;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;

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

	static IDepthAttachmentAdapter adapt(DepthAttachment image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, IDepthAttachmentAdapter.class);
	}
}