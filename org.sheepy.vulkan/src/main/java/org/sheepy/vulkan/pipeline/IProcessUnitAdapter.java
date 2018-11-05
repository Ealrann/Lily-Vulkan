package org.sheepy.vulkan.pipeline;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.IProcessUnit;

public interface IProcessUnitAdapter<T extends AbstractCommandBuffer>
		extends IVulkanAdapter
{
	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IProcessUnitAdapter<T> adapt(IProcessUnit object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IProcessUnitAdapter.class);
	}
}
