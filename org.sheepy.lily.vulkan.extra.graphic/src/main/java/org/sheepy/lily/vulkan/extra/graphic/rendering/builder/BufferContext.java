package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;

public final class BufferContext
{
	public final GraphicsPipeline pipeline;
	public final BufferMemory bufferMemory;
	public final int drawCall;

	public BufferContext(GraphicsPipeline pipeline, BufferMemory bufferMemory, int drawCall)
	{
		this.pipeline = pipeline;
		this.bufferMemory = bufferMemory;
		this.drawCall = drawCall;
	}
}
