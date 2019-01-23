package org.sheepy.lily.vulkan.common.ui;

import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.vulkan.api.window.Surface;

public class UIUtil
{
	public final static int computeXRelative(Surface surface, ISizedElement panel)
	{
		int width = panel.getWidth();
		return computeXRelative(surface, panel, width);
	}

	public final static int computeXRelative(Surface surface, IPositionElement panel, int width)
	{
		int x = panel.getPosition().x;
		int surfaceWidth = surface.width;

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

	public final static int computeYRelative(Surface surface, ISizedElement panel)
	{
		int height = panel.getHeight();
		return computeYRelative(surface, panel, height);
	}

	public final static int computeYRelative(Surface surface, IPositionElement panel, int height)
	{
		int y = panel.getPosition().y;
		int surfaceHeight = surface.height;

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
