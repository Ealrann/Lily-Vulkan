package org.sheepy.lily.vulkan.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;

public interface IBufferAdapter extends IDescriptedResourceAdapter, IResourceAdapter
{
	long getPtr();
	long getMemoryPtr();

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
