package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public final class BufferContext
{
	public final GraphicsPipeline pipeline;
	public final CompositeBuffer buffer;
	public final int part;

	public BufferContext(GraphicsPipeline pipeline, CompositeBuffer buffer, int part)
	{
		this.pipeline = pipeline;
		this.buffer = buffer;
		this.part = part;
	}
}
