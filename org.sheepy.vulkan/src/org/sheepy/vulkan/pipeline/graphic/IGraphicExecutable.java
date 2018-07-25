package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.pipeline.IProcessUnit;

public interface IGraphicExecutable extends IProcessUnit
{
	void execute(RenderCommandBuffer commandBuffer);
}
