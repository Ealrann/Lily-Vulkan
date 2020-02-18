package org.sheepy.lily.game.api.resource.image;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IImageAdapter extends IAdapter
{
	Vector2ic getSize();
}
