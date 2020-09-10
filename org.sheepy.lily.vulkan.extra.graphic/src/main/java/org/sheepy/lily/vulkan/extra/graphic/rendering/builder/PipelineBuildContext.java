package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;

import java.util.List;

public record PipelineBuildContext<T extends Structure>(T structure,
														GraphicsPipeline pipeline,
														int part,
														int drawCallOffset,
														List<BufferMemory> bufferMemories,
														List<DescriptorSet> dynamicBindings,
														DescriptorSet staticBindings)
{
}
