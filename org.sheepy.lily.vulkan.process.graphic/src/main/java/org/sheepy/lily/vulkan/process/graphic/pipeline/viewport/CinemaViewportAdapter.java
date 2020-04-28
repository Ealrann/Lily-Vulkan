package org.sheepy.lily.vulkan.process.graphic.pipeline.viewport;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.graphic.IViewportAdapter;
import org.sheepy.vulkan.model.graphicpipeline.CinemaViewport;

@ModelExtender(scope = CinemaViewport.class)
@Adapter
public class CinemaViewportAdapter implements IViewportAdapter
{
	private final CinemaViewport viewport;

	public CinemaViewportAdapter(CinemaViewport viewport)
	{
		this.viewport = viewport;
	}

	@Override
	public ViewportInfo getInfo(final Vector2ic screenSize)
	{
		final float needAspect = viewport.getAspectRatio();
		final int screenWidth = screenSize.x();
		final int screenHeight = screenSize.y();
		final float screenAspect = (float) screenWidth / screenHeight;
		final float factor = screenAspect / needAspect;
		final boolean horizontal = needAspect > screenAspect;
		final int width = horizontal ? screenWidth : Math.round(screenWidth / factor);
		final int height = horizontal ? Math.round(screenHeight * factor) : screenHeight;
		final int xOffset = horizontal ? 0 : Math.round((screenWidth - width) / 2f);
		final int yOffset = horizontal ? Math.round((screenHeight - height) / 2f) : 0;

		return new ViewportInfo(xOffset, yOffset, width, height, viewport.getMinDepth(), viewport.getMaxDepth());
	}
}
