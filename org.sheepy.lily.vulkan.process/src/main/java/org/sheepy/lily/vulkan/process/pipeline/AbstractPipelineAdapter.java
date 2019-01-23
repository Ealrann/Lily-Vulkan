package org.sheepy.lily.vulkan.process.pipeline;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		extends IPipelineAdapter<T>
{
	@Override
	protected AbstractConstants getConstants()
	{
		return ((AbstractPipeline) pipeline).getConstants();
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		var descriptorSet = ((AbstractPipeline) pipeline).getDescriptorSet();
		var adapter = IDescriptorSetAdapter.adapt(descriptorSet);

		return List.of(adapter);
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(AbstractPipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
