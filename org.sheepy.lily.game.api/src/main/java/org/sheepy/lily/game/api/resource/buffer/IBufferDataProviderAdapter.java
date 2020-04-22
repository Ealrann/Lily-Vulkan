package org.sheepy.lily.game.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IBufferDataProviderAdapter extends IExtender
{
	void fill(ByteBuffer buffer);
	void fetch(ByteBuffer buffer);

	boolean hasChanged();

	default int minAlignment() { return 1; }
}
