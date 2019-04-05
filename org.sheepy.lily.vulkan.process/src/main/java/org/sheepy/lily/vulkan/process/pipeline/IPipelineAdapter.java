package org.sheepy.lily.vulkan.process.pipeline;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;
import org.sheepy.lily.vulkan.model.process.IPipeline;

public interface IPipelineAdapter extends IVulkanAdapter, IRecordable
{
	default void prepareRecord()
	{}

	default void prepareExecution(IExecutionContext context)
	{}

	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);

	/**
	 * @return IAllocable or EObject
	 */
	default void collectResources(List<Object> collectIn) {};

	static IPipelineAdapter adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineAdapter.class);
	}
}
