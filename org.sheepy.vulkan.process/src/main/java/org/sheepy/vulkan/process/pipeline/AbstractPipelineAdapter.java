package org.sheepy.vulkan.process.pipeline;

import java.util.List;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.resource.descriptor.AbstractDescriptorSetAdapter;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		extends IPipelineAdapter<T>
{
	@Override
	protected AbstractConstants getConstants()
	{
		return ((AbstractPipeline) pipeline).getConstants();
	}

	@Override
	protected List<IVkDescriptorSet> getDescriptorSets()
	{
		var descriptorSet = ((AbstractPipeline) pipeline).getDescriptorSet();
		var adapter = AbstractDescriptorSetAdapter.adapt(descriptorSet);

		return List.of(adapter);
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(AbstractPipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
