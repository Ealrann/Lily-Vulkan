package org.sheepy.vulkan.pipeline;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.AbstractCompositePipeline;
import org.sheepy.vulkan.model.process.AbstractPipeline;

@Deprecated
public abstract class AbstractCompositePipelineAdapter<T extends AbstractCommandBuffer>
		extends AbstractPipelineAdapter<T>
{
	private boolean enabled = true;
	protected boolean dirty = false;

	@Override
	public void record(T commandBuffer, int bindPoint)
	{
		final AbstractCompositePipeline compositePipeline = (AbstractCompositePipeline) target;
		if (compositePipeline.isEnabled())
		{
			for (final AbstractPipeline pipeline : compositePipeline.getPipelines())
			{
				final var adapter = AbstractPipelineAdapter.adapt(pipeline);
				adapter.record(commandBuffer, bindPoint);
			}
			dirty = false;
		}
	}

	public void setEnabled(boolean enabled)
	{
		if (this.enabled != enabled)
		{
			this.enabled = enabled;
			dirty = true;
		}
	}

	@Override
	public boolean isDirty()
	{
		return dirty;
	}

	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractCompositePipelineAdapter<T> adapt(AbstractCompositePipeline object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object,
				AbstractCompositePipelineAdapter.class);
	}
}
