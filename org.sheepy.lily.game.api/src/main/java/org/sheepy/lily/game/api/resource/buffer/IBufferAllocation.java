package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.game.api.execution.IRecordContext;

import java.nio.ByteBuffer;

public interface IBufferAllocation extends IExtender
{
	long getPtr();
	long getMemoryPtr();

	long getBindSize();
	long getBindOffset();

	long mapMemory();
	void unmapMemory();

	void attach(IRecordContext recordContext);

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
