package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.IProcessUnit;

public interface IProcessUnitAdapter<T extends AbstractCommandBuffer> extends IVulkanAdapter
{
	boolean isRecordNeeded();
	void setRecordNeeded(boolean value);

	default void prepare()
	{}

	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IProcessUnitAdapter<T> adapt(IProcessUnit object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IProcessUnitAdapter.class);
	}
}
