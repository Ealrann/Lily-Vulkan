package org.sheepy.lily.vulkan.api.util;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

public final class UIUtil
{
	private UIUtil()
	{
	}

	public static int computeXRelative(final Vector2ic size, final ISizedElement panel)
	{
		final int width = panel.width();
		return computeXRelative(size, panel, width);
	}

	public static int computeXRelative(final Vector2ic size, final IPositionElement panel, final int width)
	{
		return computeXRelative(panel.horizontalRelative(), size.x(), panel.position().x(), width);
	}

	public static int computeXRelative(final EHorizontalRelative relative,
									   final int areaWidth,
									   final int x,
									   final int width)
	{
		return switch (relative)
				{
					case RIGHT -> areaWidth - width - x - 1;
					case MIDDLE -> (areaWidth / 2) - (width / 2) + x;
					default -> x;
				};
	}

	public static int computeYRelative(final Vector2ic size, final ISizedElement panel)
	{
		final int height = panel.height();
		return computeYRelative(size, panel, height);
	}

	public static int computeYRelative(final Vector2ic size, final IPositionElement panel, final int height)
	{
		return computeYRelative(panel.verticalRelative(), size.y(), panel.position().y(), height);
	}

	public static int computeYRelative(final EVerticalRelative relative,
									   final int areaHeight,
									   final int y,
									   final int height)
	{
		return switch (relative)
				{
					case BOTTOM -> areaHeight - height - y - 1;
					case MIDDLE -> (areaHeight / 2) - (height / 2) + y;
					default -> y;
				};
	}
}
