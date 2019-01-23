package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;

public interface IBufferBackend
{
	void allocate(MemoryStack stack);
	void free();

	long getId();
	long getMemoryId();

	public long mapMemory();
	public void unmapMemory();

	void pushData(ExecutionManager executionManager, ByteBuffer data);
}
