package org.sheepy.vulkan.pipeline;

import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.vulkan.execution.graphic.RenderCommandBuffer;

@Deprecated
public abstract class PipelineId extends AbstractServiceAdapter
		implements IProcessUnitAdapter<RenderCommandBuffer>, IStatefullAdapter
{
	public final long id;

	public PipelineId(long id)
	{
		this.id = id;
	}
}