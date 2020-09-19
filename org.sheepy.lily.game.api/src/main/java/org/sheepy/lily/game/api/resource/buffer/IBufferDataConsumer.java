package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;

import java.nio.ByteBuffer;

public interface IBufferDataConsumer extends IExtender
{
	void fetch(ByteBuffer buffer);
}
