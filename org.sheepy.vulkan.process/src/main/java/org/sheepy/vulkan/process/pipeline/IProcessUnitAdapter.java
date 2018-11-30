package org.sheepy.vulkan.process.pipeline;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.IProcessUnit;

public interface IProcessUnitAdapter<T extends AbstractCommandBuffer>
		extends IVulkanAdapter
{
	boolean isRecordNeeded();
	
	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IProcessUnitAdapter<T> adapt(IProcessUnit object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IProcessUnitAdapter.class);
	}

}
