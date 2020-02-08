package org.sheepy.lily.game.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;

public interface IBufferAdapter extends INotifierAdapter
{
	static enum Features
	{
		Size,
		Offset,
		Ptr
	};

	long getPtr();
	long getMemoryPtr();

	long getBindSize();
	long getBindOffset();

	public long mapMemory();
	public void unmapMemory();

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @note Only required for host visible, non-coherent memory
	 *
	 */
	public void flush();

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @note Only required for host visible, non-coherent memory
	 */
	public void invalidate();

	@Deprecated
	void pushData(ByteBuffer data);
}
