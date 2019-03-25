package org.sheepy.lily.vulkan.process.pipeline;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;

public interface IPipelineUnitAdapter extends IVulkanAdapter
{
	void record(IPipelineUnit unit, VkCommandBuffer commandBuffer, int bindPoint);

	static IPipelineUnitAdapter adapt(IPipelineUnit object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineUnitAdapter.class);
	}
}
