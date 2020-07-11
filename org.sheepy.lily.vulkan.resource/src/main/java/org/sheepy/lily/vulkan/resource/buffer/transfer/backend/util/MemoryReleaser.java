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
		final boolean previousNotUsed = previousSpace != null && previousSpace.used == false;
		final boolean nextNotUsed = nextSpace != null && nextSpace.used == false;
		final long sizeToRelease = spaceToRelease.getSize();

		if (previousNotUsed && nextNotUsed)
		{
			listIterator.remove();
			previousSpace.size += nextSpace.getSize() + sizeToRelease;
			listIterator.next();
			listIterator.remove();
		}
		else if (previousNotUsed)
		{
			listIterator.remove();
			previousSpace.size += sizeToRelease;
		}
		else if (nextNotUsed)
		{
			listIterator.remove();
			nextSpace.size += sizeToRelease;
			nextSpace.offset -= sizeToRelease;
		}
		else
		{
			spaceToRelease.used = false;
		}
	}

	private MemorySpace findPrevious(final ListIterator<MemorySpace> listIterator)
	{
		if (listIterator.hasPrevious())
		{
			final var res = listIterator.previous();
			//noinspection StatementWithEmptyBody
			while (listIterator.next() != spaceToRelease) ; // go back to initial position
			return res;
		}
		else
		{
			return null;
		}
	}

	private MemorySpace findNext(final ListIterator<MemorySpace> listIterator)
	{
		if (listIterator.hasNext())
		{
			final var res = listIterator.next();
			//noinspection StatementWithEmptyBody
			while (listIterator.previous() != spaceToRelease) ; // go back to initial position
			return res;
		}
		else
		{
			return null;
		}
	}
}
