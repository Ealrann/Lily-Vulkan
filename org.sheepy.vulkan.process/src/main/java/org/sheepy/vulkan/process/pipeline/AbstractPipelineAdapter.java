package org.sheepy.vulkan.process.pipeline;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.model.resource.DescriptorSet;

public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		extends IPipelineAdapter<T>
{
	@Override
	protected AbstractConstants getConstants()
	{
		return ((AbstractPipeline) pipeline).getConstants();
	}

	@Override
	protected DescriptorSet getDescriptorSet()
	{
		return ((AbstractPipeline) pipeline).getDescriptorSet();
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(AbstractPipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
