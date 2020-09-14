package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;

import java.nio.ByteBuffer;

public interface IBufferFetchAdapter extends IExtender
{
	void fetch(ByteBuffer buffer);
}
