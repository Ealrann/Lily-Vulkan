package org.sheepy.lily.game.api.resource.buffer;

import org.logoce.lmf.core.api.extender.IAdapter;

import java.nio.ByteBuffer;

public interface IBufferDataConsumer extends IAdapter
{
	void fetch(ByteBuffer buffer);
}
