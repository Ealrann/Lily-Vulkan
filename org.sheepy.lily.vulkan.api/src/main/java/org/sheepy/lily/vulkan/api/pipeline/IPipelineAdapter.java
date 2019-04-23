package org.sheepy.lily.vulkan.api.pipeline;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IPipelineAdapter extends IVulkanAdapter, IRecordable
{
	default void update()
	{}

	default void prepareExecution(IExecutionContext context)
	{}

	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);

	/**
	 * @return List of IAllocables or EObjects
	 */
	default void collectResources(List<Object> collectIn) {};

	static IPipelineAdapter adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineAdapter.class);
	}
}
