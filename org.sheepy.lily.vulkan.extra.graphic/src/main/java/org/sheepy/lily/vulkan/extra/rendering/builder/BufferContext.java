package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public final class BufferContext
{
	public final RenderPipelineContext pipelineContext;
	public final CompositeBuffer buffer;
	public final int part;

	public BufferContext(RenderPipelineContext pipelineContext, CompositeBuffer buffer, int part)
	{
		this.pipelineContext = pipelineContext;
		this.buffer = buffer;
		this.part = part;
	}
}