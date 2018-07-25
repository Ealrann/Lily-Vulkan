package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.pipeline.IProcessUnit;

public interface IGraphicProcessUnit extends IProcessUnit, IDescriptorSetConfiguration
{
	void bindContext(DescriptorPool descriptorPool, GraphicContext context);
	void executePreRender(RenderCommandBuffer commandBuffer);
	void execute(RenderCommandBuffer commandBuffer);
	void executePostRender(RenderCommandBuffer commandBuffer);
}
