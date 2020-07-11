package org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class MemorySpaceManager
{
	private final List<MemorySpace> memoryMap = new LinkedList<>();
	private final long capacity;

	public MemorySpaceManager(long capacity)
	{
		this.capacity = capacity;

		init();
	}

	private void init()
	{
		memoryMap.add(new MemorySpace(capacity, 0, false));
	}

	public void clear()
	{
		memoryMap.clear();
		init();
	}

	public Optional<MemorySpace> reserveMemory(long size)
	{
		if (size <= capacity)
		{
			final var listIterator = memoryMap.listIterator();
			final var allocator = new MemoryAllocator(listIterator, size);
			return allocator.allocate();
		}
		else
		{
			return Optional.empty();
		}
	}

	public void releaseMemory(MemorySpace space)
	{
		assert memoryMap.contains(space);

		final var releaser = new MemoryReleaser(space);
		final var listIterator = memoryMap.listIterator(memoryMap.indexOf(space));
		releaser.release(listIterator);
	}
}
