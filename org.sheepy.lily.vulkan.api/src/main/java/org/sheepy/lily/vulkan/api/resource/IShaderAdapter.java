package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.pipeline.VkShaderStage;

public interface IShaderAdapter extends IResourceAdapter
{
	long getShaderModule();
	
	VkShaderStage getVkShaderStage();

	public static IShaderAdapter adapt(Shader shader)
	{
		return IAdapterFactoryService.INSTANCE.adapt(shader, IShaderAdapter.class);
	}
}