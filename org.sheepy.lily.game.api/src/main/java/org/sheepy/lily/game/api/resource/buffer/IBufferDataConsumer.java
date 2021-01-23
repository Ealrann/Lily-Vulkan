package org.sheepy.lily.game.api.resource.buffer;

import org.logoce.extender.api.IAdapter;

import java.nio.ByteBuffer;

public interface IBufferDataConsumer extends IAdapter
{
	void fetch(ByteBuffer buffer);
}
