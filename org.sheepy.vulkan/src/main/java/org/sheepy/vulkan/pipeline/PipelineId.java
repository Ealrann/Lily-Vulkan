package org.sheepy.vulkan.pipeline;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.execution.graphic.RenderCommandBuffer;

@Deprecated
public abstract class PipelineId extends AbstractSheepyAdapter
		implements IProcessUnitAdapter<RenderCommandBuffer>
{
	public final long id;

	public PipelineId(long id)
	{
		this.id = id;
	}
}