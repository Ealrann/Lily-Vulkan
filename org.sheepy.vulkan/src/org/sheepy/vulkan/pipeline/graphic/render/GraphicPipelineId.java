package org.sheepy.vulkan.pipeline.graphic.render;

import org.sheepy.vulkan.pipeline.PipelineId;
import org.sheepy.vulkan.pipeline.graphic.IGraphicExecutable;

public abstract class GraphicPipelineId extends PipelineId implements IGraphicExecutable
{
	public GraphicPipelineId(long id)
	{
		super(id);
	}
}