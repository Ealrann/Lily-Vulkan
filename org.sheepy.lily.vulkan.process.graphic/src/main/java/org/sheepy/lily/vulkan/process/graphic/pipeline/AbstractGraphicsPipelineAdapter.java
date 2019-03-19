package org.sheepy.lily.vulkan.process.graphic.pipeline;

import java.util.List;

import org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.resource.Shader;

public abstract class AbstractGraphicsPipelineAdapter extends IGraphicsPipelineAdapter
{
	public AbstractGraphicsPipelineAdapter(AbstractGraphicsPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	protected List<Shader> getShaders()
	{
		return ((AbstractGraphicsPipeline) pipeline).getShaders();
	}

	@Override
	protected ViewportState getViewportState()
	{
		return ((AbstractGraphicsPipeline) pipeline).getViewportState();
	}

	@Override
	protected Rasterizer getRasterizer()
	{
		return ((AbstractGraphicsPipeline) pipeline).getRasterizer();
	}

	@Override
	protected ColorBlend getColorBlend()
	{
		return ((AbstractGraphicsPipeline) pipeline).getColorBlend();
	}

	@Override
	protected DynamicState getDynamicState()
	{
		return ((AbstractGraphicsPipeline) pipeline).getDynamicState();
	}
}
