package org.sheepy.lily.vulkan.process.graphic.pipeline.viewport;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.graphic.IViewportAdapter;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

@ModelExtender(scope = Viewport.class)
@Adapter
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
		final var viewportExtent = viewport.extent();
		final var extent = viewportExtent != null ? viewportExtent : screenSize;
		return new ViewportInfo(viewport.offsetX(),
								viewport.offsetY(),
								extent.x(),
								extent.y(),
								viewport.minDepth(),
								viewport.maxDepth());
	}
}
