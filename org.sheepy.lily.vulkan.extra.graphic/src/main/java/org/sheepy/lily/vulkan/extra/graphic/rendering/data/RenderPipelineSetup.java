package org.sheepy.lily.vulkan.extra.graphic.rendering.data;

import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;

import java.util.List;

public record RenderPipelineSetup(GraphicsPipeline pipeline,
								  List<BufferDataProvider> dataProviders,
								  Structure structure)
{
}
