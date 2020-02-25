package org.sheepy.lily.game.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IBufferDataProviderAdapter extends IAdapter
{
	void fill(ByteBuffer buffer);
	void fetch(ByteBuffer buffer);

	boolean hasChanged();

	default int minAlignment() { return 1; }
}
