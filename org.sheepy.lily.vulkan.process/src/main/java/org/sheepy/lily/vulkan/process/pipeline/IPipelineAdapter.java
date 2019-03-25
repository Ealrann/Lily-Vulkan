package org.sheepy.lily.vulkan.process.pipeline;

import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public interface IPipelineAdapter extends IVulkanAdapter
{
	boolean isRecordNeeded();

	void setRecordNeeded(boolean value);

	default void prepare()
	{}

	void record(VkCommandBuffer commandBuffer, int bindPoint, int index);

	List<IVkDescriptorSet> getDescriptorSets();

	boolean shouldRecord(ECommandStage stage);

	/**
	 * @return IAllocable or EObject
	 */
	default List<? extends Object> getResources()
	{
		return List.of();
	}

	static IPipelineAdapter adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineAdapter.class);
	}

}
