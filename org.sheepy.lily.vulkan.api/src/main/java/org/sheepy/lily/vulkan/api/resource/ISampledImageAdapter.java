package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.SampledImage;

public interface ISampledImageAdapter extends ISamplerAdapter, IImageAdapter
{
	public static ISampledImageAdapter adapt(SampledImage resource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(resource, ISampledImageAdapter.class);
	}
}
