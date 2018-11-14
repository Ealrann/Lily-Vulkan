package org.sheepy.vulkan.process.graphic.pipeline;

import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.common.api.adapter.impl.AbstractAdapter;
import org.sheepy.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;

@Deprecated
public abstract class PipelineId extends AbstractAdapter
		implements IProcessUnitAdapter<RenderCommandBuffer>, IStatefullAdapter
{
	public final long id;

	public PipelineId(long id)
	{
		this.id = id;
	}
}