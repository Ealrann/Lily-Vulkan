package org.sheepy.lily.vulkan.api.process;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IProcessPartAdapter extends IVulkanAdapter, IRecordable
{
	default void update()
	{}

	default void prepareExecution(IExecutionContext context)
	{}

	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
	/**
	 * @return List of IAllocables or EObjects
	 */
	default void collectResources(List<IAllocable<? super IExecutionContext>> collectIn)
	{};

	static IProcessPartAdapter adapt(IProcessPart object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IProcessPartAdapter.class);
	}
}
