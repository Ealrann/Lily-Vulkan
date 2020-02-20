package org.sheepy.lily.game.api.graphic;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IViewportAdapter extends IAdapter
{
	ViewportInfo getInfo(Vector2ic screenSize);

	final class ViewportInfo
	{
		public final int xOffset;
		public final int yOffset;
		public final int width;
		public final int height;
		public final float minDepth;
		public final float maxDepth;

		public ViewportInfo(final int xOffset,
							final int yOffset,
							final int width,
							final int height,
							final float minDepth,
							final float maxDepth)
		{
			this.xOffset = xOffset;
			this.yOffset = yOffset;
			this.width = width;
			this.height = height;
			this.minDepth = minDepth;
			this.maxDepth = maxDepth;
		}

		@Override
		public String toString()
		{
			return "ViewportInfo{" + "xOffset=" + xOffset + ", yOffset=" + yOffset + ", width=" + width + ", height=" + height + ", minDepth=" + minDepth + ", maxDepth=" + maxDepth + '}';
		}
	}
}
