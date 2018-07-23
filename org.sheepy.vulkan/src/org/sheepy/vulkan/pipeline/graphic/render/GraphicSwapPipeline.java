package org.sheepy.vulkan.pipeline.graphic.render;

import java.util.Collection;
import java.util.List;

import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.pipeline.graphic.IGraphicsPipeline;
import org.sheepy.vulkan.pipeline.graphic.IRenderPass;
import org.sheepy.vulkan.pipeline.graphic.SwapPipeline;
import org.sheepy.vulkan.shader.Shader;

public abstract class GraphicSwapPipeline extends SwapPipeline
{

	public GraphicSwapPipeline(GraphicSwapConfiguration configuration,
			Collection<ISignalEmitter> waitForSignals)
	{
		super(configuration, waitForSignals);

		subAllocates.add(configuration.graphicsPipeline);
	}

	public IGraphicsPipeline getGraphicPipeline()
	{
		return ((GraphicSwapConfiguration) configuration).graphicsPipeline;
	}

	public IRenderPass getRenderPass()
	{
		return ((GraphicSwapConfiguration) configuration).renderPass;
	}

	public List<Shader> getShaders()
	{
		return ((GraphicSwapConfiguration)configuration).shaders;
	}

	public DescriptorPool getDescriptorPool()
	{
		return ((GraphicSwapConfiguration)configuration).descriptorPool;
	}
}
