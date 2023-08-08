package org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.extra.api.rendering.IMousePickDataConsumer;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

import java.nio.ByteBuffer;

@ModelExtender(scope = StaticBuffer.class, name = "MousePickingBuffer")
@Adapter
public class MousePickDataConsumer implements IMousePickDataConsumer
{
	private int pipeline = -1;
	private RenderPointer renderPointer = null;

	@Override
	public void fetch(final ByteBuffer buffer)
	{
		pipeline = buffer.getInt();
		final int triangle = buffer.getInt();
		final int instance = buffer.getInt();
		final int drawcall = buffer.getInt();
		renderPointer = new RenderPointer(triangle, instance, drawcall);
	}

	@Override
	public int getPipeline()
	{
		return pipeline;
	}

	@Override
	public RenderPointer getRenderPointer()
	{
		return renderPointer;
	}
}
