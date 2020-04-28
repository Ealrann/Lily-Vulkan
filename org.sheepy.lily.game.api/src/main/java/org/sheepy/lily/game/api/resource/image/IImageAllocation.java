package org.sheepy.lily.game.api.resource.image;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.IAllocation;

public interface IImageAllocation extends IAllocation
{
	Vector2ic getSize();
}
