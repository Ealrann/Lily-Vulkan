package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.pipeline.IShaderStageFiller;

public interface IShaderAdapter extends IResourceAdapter, IShaderStageFiller
{
	long getShaderModule();

	public static IShaderAdapter adapt(Shader shader)
	{
		return IAdapterFactoryService.INSTANCE.adapt(shader, IShaderAdapter.class);
	}
}