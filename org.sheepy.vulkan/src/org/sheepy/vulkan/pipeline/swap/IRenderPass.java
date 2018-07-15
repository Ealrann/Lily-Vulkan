package org.sheepy.vulkan.pipeline.swap;

import java.util.List;

import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.common.IAllocable;

public interface IRenderPass extends IAllocable
{
	long getId();

	void buildRenderPass(List<RenderCommandBuffer> commandBuffers);
}
