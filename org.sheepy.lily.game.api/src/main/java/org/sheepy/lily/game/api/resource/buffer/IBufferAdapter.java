package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;

import java.nio.ByteBuffer;
import java.util.function.LongConsumer;

public interface IBufferAdapter extends INotifierAdapter<IBufferAdapter.Features>
{
	enum Features implements IFeature<LongConsumer, Features>
	{
		Size,
		Offset,
		Ptr
	}

	long getPtr();
	long getMemoryPtr();

	long getBindSize();
	long getBindOffset();

	long mapMemory();
	void unmapMemory();

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void flush();

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void invalidate();

	@Deprecated
	void pushData(ByteBuffer data);
}
