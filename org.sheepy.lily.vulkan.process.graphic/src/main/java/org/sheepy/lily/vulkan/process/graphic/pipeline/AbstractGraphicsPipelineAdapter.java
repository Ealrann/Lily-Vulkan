package org.sheepy.vulkan.process.graphic.pipeline;

import java.util.List;

import org.sheepy.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.vulkan.model.process.graphic.DynamicState;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.vulkan.model.process.graphic.ViewportState;
import org.sheepy.vulkan.model.resource.Shader;

public abstract class AbstractGraphicsPipelineAdapter extends IGraphicsPipelineAdapter
{
	@Override
	protected List<Shader> getShaders()
	{
		return ((GraphicsPipeline) pipeline).getShaders();
	}

	@Override
	protected ViewportState getViewportState()
	{
		return ((GraphicsPipeline) pipeline).getViewportState();
	}

	@Override
	protected Rasterizer getRasterizer()
	{
		return ((GraphicsPipeline) pipeline).getRasterizer();
	}

	@Override
	protected ColorBlend getColorBlend()
	{
		return ((GraphicsPipeline) pipeline).getColorBlend();
	}

	@Override
	protected DynamicState getDynamicState()
	{
		return ((GraphicsPipeline) pipeline).getDynamicState();
	}
}
