package org.sheepy.lily.vulkan.process.graphic.pipeline.viewport;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.game.api.graphic.IViewportAdapter;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

@Statefull
@Adapter(scope = Viewport.class)
public class ViewportAdapter implements IViewportAdapter
{
	private final Viewport viewport;

	public ViewportAdapter(Viewport viewport)
	{
		this.viewport = viewport;
	}

	@Override
	public ViewportInfo getInfo(final Vector2ic screenSize)
	{
		final var viewportExtent = viewport.getExtent();
		final var extent = viewportExtent != null ? viewportExtent : screenSize;
		return new ViewportInfo(viewport.getOffsetX(),
								viewport.getOffsetY(),
								extent.x(),
								extent.y(),
								viewport.getMinDepth(),
								viewport.getMaxDepth());
	}
}
