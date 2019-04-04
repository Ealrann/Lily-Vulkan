package org.sheepy.lily.vulkan.api.resource;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Shader;

public interface IShaderAdapter extends IResourceAdapter
{
	/**
	 * You will be responsible to free this object.
	 *
	 * @return
	 */
	void fillInfo(VkPipelineShaderStageCreateInfo info);

	long getShaderModule();

	public static IShaderAdapter adapt(Shader shader)
	{
		return IAdapterFactoryService.INSTANCE.adapt(shader, IShaderAdapter.class);
	}
}