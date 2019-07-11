package org.sheepy.vulkan.resource.staging.memory;

import java.util.LinkedList;
import java.util.List;

public class MemorySpaceManager
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

	public MemorySpace reserveMemory(long size)
	{
		MemorySpace res = null;

		if (size <= capacity)
		{
			MemorySpace foundMemory = null;
			int foundIndex = -1;
			long position = 0;
			int index = 0;
			for (final var memory : memoryMap)
			{
				if (memory.used == false && memory.getSize() >= size)
				{
					foundMemory = memory;
					foundIndex = index;
					break;
				}
				else
				{
					index++;
					position += memory.getSize();
				}
			}

			if (foundMemory != null)
			{

				foundMemory.size -= size;
				foundMemory.offset += size;

				if (foundMemory.size == 0)
				{
					memoryMap.remove(foundMemory);
				}

				res = new MemorySpace(size, position, true);

				memoryMap.add(foundIndex, res);
			}
		}

		return res;
	}

	public void releaseMemory(MemorySpace space)
	{
		MemorySpace prev = null;
		MemorySpace next = null;

		final int index = memoryMap.indexOf(space);

		if (index > 0)
		{
			prev = memoryMap.get(index - 1);
		}
		else if (index < memoryMap.size() - 1)
		{
			next = memoryMap.get(index + 1);
		}

		memoryMap.remove(space);

		if (prev != null && prev.used == false && next != null && next.used == false)
		{
			prev.size += next.getSize() + space.getSize();
			memoryMap.remove(next);
		}
		else if (prev != null && prev.used == false)
		{
			prev.size += space.getSize();
		}
		else if (next != null && next.used == false)
		{
			next.size += space.getSize();
			next.offset -= space.getSize();
		}
		else
		{
			memoryMap.add(index, new MemorySpace(space.getSize(), space.getOffset(), false));
		}
	}

	public static final class MemorySpace
	{
		private final boolean used;

		private long size = 0;
		private long offset = 0;

		private MemorySpace(long size, long offset, boolean used)
		{
			this.used = used;
			this.offset = offset;
			this.size = size;
		}

		public long getSize()
		{
			return size;
		}

		public long getOffset()
		{
			return offset;
		}
	}
}
