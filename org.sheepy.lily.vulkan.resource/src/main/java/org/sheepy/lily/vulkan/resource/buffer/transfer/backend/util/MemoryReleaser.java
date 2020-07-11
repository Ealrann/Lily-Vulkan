package org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util;

import java.util.ListIterator;

public final class MemoryReleaser
{
	private final MemorySpace spaceToRelease;

	public MemoryReleaser(MemorySpace spaceToRelease)
	{
		this.spaceToRelease = spaceToRelease;
	}

	public void release(ListIterator<MemorySpace> listIterator)
	{
		final var previousSpace = findPrevious(listIterator);
		final var nextSpace = findNext(listIterator);

		listIterator.remove();

		final boolean previousNotUsed = previousSpace != null && previousSpace.used == false;
		final boolean nextNotUsed = nextSpace != null && nextSpace.used == false;
		final long sizeToRelease = spaceToRelease.getSize();

		if (previousNotUsed && nextNotUsed)
		{
			previousSpace.size += nextSpace.getSize() + sizeToRelease;
			listIterator.next();
			listIterator.remove();
		}
		else if (previousNotUsed)
		{
			previousSpace.size += sizeToRelease;
		}
		else if (nextNotUsed)
		{
			nextSpace.size += sizeToRelease;
			nextSpace.offset -= sizeToRelease;
		}
		else
		{
			listIterator.add(new MemorySpace(sizeToRelease, spaceToRelease.getOffset(), false));
		}
	}

	private static MemorySpace findPrevious(final ListIterator<MemorySpace> listIterator)
	{
		final MemorySpace res;
		if (listIterator.hasPrevious())
		{
			res = listIterator.previous();
			listIterator.next();
		}
		else
		{
			res = null;
		}
		return res;
	}

	private static MemorySpace findNext(final ListIterator<MemorySpace> listIterator)
	{
		final MemorySpace res;
		if (listIterator.hasNext())
		{
			res = listIterator.next();
			listIterator.previous();
		}
		else
		{
			res = null;
		}
		return res;
	}
}
