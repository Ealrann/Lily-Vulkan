package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

public final class PipelineContext
{
	public final GraphicsPipeline pipeline;
	public final PushBuffer pushBuffer;

	public PipelineContext(GraphicsPipeline pipeline, PushBuffer pushBuffer)
	{
		this.pipeline = pipeline;
		this.pushBuffer = pushBuffer;
	}
}