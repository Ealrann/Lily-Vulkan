package org.sheepy.lily.vulkan.api.util;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

public class UIUtil
{
	public final static int computeXRelative(Vector2ic size, ISizedElement panel)
	{
		final int width = panel.getWidth();
		return computeXRelative(size, panel, width);
	}

	public final static int computeXRelative(Vector2ic size, IPositionElement panel, int width)
	{
		return computeXRelative(panel.getHorizontalRelative(), size.x(), panel.getPosition().x(), width);
	}

	public final static int computeXRelative(EHorizontalRelative relative, int areaWidth, int x, int width)
	{
		switch (relative)
		{
			case RIGHT:
				return areaWidth - width - x - 1;
			case MIDDLE:
				return (areaWidth / 2) - (width / 2) + x;
			default:
				return x;
		}
	}

	public final static int computeYRelative(Vector2ic size, ISizedElement panel)
	{
		final int height = panel.getHeight();
		return computeYRelative(size, panel, height);
	}

	public final static int computeYRelative(Vector2ic size, IPositionElement panel, int height)
	{
		return computeYRelative(panel.getVerticalRelative(), size.y(), panel.getPosition().y(), height);
	}

	public final static int computeYRelative(EVerticalRelative relative, int areaHeight, int y, int height)
	{
		switch (relative)
		{
			case BOTTOM:
				return areaHeight - height - y - 1;
			case MIDDLE:
				return (areaHeight / 2) - (height / 2) + y;
			default:
				return y;
		}
	}
}
