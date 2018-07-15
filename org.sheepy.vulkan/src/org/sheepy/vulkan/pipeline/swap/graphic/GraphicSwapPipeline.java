package org.sheepy.vulkan.pipeline.swap.graphic;

import java.util.Collection;
import java.util.List;

import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.pipeline.swap.SwapPipeline;
import org.sheepy.vulkan.pipeline.swap.IGraphicsPipeline;
import org.sheepy.vulkan.pipeline.swap.IRenderPass;
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
