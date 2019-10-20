package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

public final class RenderPipelineContext
{
	public final GraphicsPipeline pipeline;
	public final ConstantBuffer constantBuffer;
	public final PushBuffer pushBuffer;

	public RenderPipelineContext(	GraphicsPipeline pipeline,
									ConstantBuffer constantBuffer,
									PushBuffer pushBuffer)
	{
		this.pipeline = pipeline;
		this.constantBuffer = constantBuffer;
		this.pushBuffer = pushBuffer;
	}
}