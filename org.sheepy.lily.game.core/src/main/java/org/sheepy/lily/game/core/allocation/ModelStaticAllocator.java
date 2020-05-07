package org.sheepy.lily.game.core.allocation;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;

public final class ModelStaticAllocator implements IAllocable<IAllocationContext>
{
	private final ILilyEObject target;

	public ModelStaticAllocator(ILilyEObject target)
	{
		assert target != null;
		this.target = target;
	}

	@Override
	public void allocate(final IAllocationContext context)
	{
		update(context);
	}

	@Override
	public void free(final IAllocationContext context)
	{
		freeInternal(context);
	}

	public void update(final IAllocationContext context)
	{
		target.adapt(IAllocationManager.class).maintains(context);
	}

	private void freeInternal(final IAllocationContext context)
	{
		target.adapt(IAllocationManager.class).free(context);
	}
}
