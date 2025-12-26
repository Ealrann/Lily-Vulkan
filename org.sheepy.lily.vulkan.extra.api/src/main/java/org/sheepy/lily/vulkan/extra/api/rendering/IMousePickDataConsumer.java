package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.game.api.resource.buffer.IBufferDataConsumer;

public interface IMousePickDataConsumer extends IBufferDataConsumer
{
	int getPipeline();

	RenderPointer getRenderPointer();
}
