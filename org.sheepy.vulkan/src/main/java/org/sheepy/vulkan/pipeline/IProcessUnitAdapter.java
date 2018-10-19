package org.sheepy.vulkan.pipeline;

import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.IProcessUnit;

public interface IProcessUnitAdapter<T extends AbstractCommandBuffer>
		extends IVulkanAdapter
{
	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IProcessUnitAdapter<T> adapt(IProcessUnit object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IProcessUnitAdapter.class);
	}
}
