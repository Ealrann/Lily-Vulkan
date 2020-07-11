package org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util;

import java.util.ListIterator;
import java.util.Optional;

public final class MemoryAllocator
{
	private final ListIterator<MemorySpace> listIterator;
	private final long size;

	public MemoryAllocator(ListIterator<MemorySpace> listIterator, long size)
	{
		this.listIterator = listIterator;
		this.size = size;
	}

	public Optional<MemorySpace> allocate()
	{
		return searchFreeSpace().map(this::allocate);
	}

	private MemorySpace allocate(final MemorySpace freeMemory)
	{
		if (freeMemory.size == 0)
		{
			freeMemory.used = true;
			return freeMemory;
		}
		else
		{
			final long position = freeMemory.offset;
			freeMemory.size -= size;
			freeMemory.offset += size;
			final var res = new MemorySpace(size, position, true);
			listIterator.set(res);
			listIterator.add(freeMemory);
			return res;
		}
	}

	private Optional<MemorySpace> searchFreeSpace()
	{
		while (listIterator.hasNext())
		{
			final var memory = listIterator.next();
			if (memory.used == false && memory.getSize() >= size)
			{
				return Optional.of(memory);
			}
		}
		return Optional.empty();
	}
}
