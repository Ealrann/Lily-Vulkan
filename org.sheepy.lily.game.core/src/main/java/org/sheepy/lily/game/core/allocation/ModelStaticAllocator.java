package org.sheepy.lily.game.core.allocation;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;

public final class ModelStaticAllocator
{
	private final ILilyEObject target;

	public ModelStaticAllocator(ILilyEObject target)
	{
		assert target != null;
		this.target = target;
	}

	public void allocate(final IAllocationContext context)
	{
		update(context);
	}

	public void free(final IAllocationContext context)
	{
		freeInternal(context);
	}

	public void update(final IAllocationContext context)
	{
		final var manager = IAllocationManager.INSTANCE;
		manager.ensureAllocation(target, context);
		manager.cleanup(target, context);
	}

	private void freeInternal(final IAllocationContext context)
	{
		IAllocationManager.INSTANCE.free(target, context);
	}
}
