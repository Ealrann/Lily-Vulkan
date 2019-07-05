package org.sheepy.lily.vulkan.common.util;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;

public class UIUtil
{
	public final static int computeXRelative(Vector2ic size, ISizedElement panel)
	{
		final int width = panel.getWidth();
		return computeXRelative(size, panel, width);
	}

	public final static int computeXRelative(Vector2ic size, IPositionElement panel, int width)
	{
		int x = panel.getPosition().x();
		final int surfaceWidth = size.x();

		switch (panel.getHorizontalRelative())
		{
		case RIGHT:
			x = surfaceWidth - width - x - 1;
			break;
		case MIDDLE:
			x = (surfaceWidth / 2) - (width / 2) + x;
			break;
		default:
		}

		return x;
	}

	public final static int computeYRelative(Vector2ic size, ISizedElement panel)
	{
		final int height = panel.getHeight();
		return computeYRelative(size, panel, height);
	}

	public final static int computeYRelative(Vector2ic size, IPositionElement panel, int height)
	{
		int y = panel.getPosition().y();
		final int surfaceHeight = size.y();

		switch (panel.getVerticalRelative())
		{
		case BOTTOM:
			y = surfaceHeight - height - y - 1;
			break;
		case MIDDLE:
			y = (surfaceHeight / 2) - (height / 2) + y;
			break;
		default:
		}
		return y;
	}
}
