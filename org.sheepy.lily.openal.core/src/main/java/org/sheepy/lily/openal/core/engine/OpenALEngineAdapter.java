package org.sheepy.lily.openal.core.engine;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

import java.util.List;

@Statefull
@Adapter(scope = OpenALEngine.class)
public final class OpenALEngineAdapter implements IEngineAdapter
{
	private final OpenALEngine engine;
	private final GenericAllocator<GameAllocationContext> resourceAllocator = new GenericAllocator<>(List.of(List.of(
			ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
			ResourcePackage.Literals.RESOURCE_PKG__RESOURCES)));
	private final IRootAllocator<GameAllocationContext> allocator;

	private ISoundContext context = null;

	private OpenALEngineAdapter(OpenALEngine engine)
	{
		this.engine = engine;
		final var allocationContext = new GameAllocationContext();
		allocator = IAllocationService.INSTANCE.createAllocator(resourceAllocator.getAllocable(), allocationContext);
	}

	@Override
	public void start()
	{
		context = ISoundContext.newContext();
		resourceAllocator.start(engine);
		allocator.allocate();
	}

	@Override
	public void stop()
	{
		allocator.free();
		resourceAllocator.stop(engine);
		context.destroy();
	}

	public ISoundContext getContext()
	{
		return context;
	}

	@Tick(frequency = 10, clock = ETickerClock.RealWorld)
	private void updateHandles()
	{
		context.updateHandles();
	}

	@Override
	public void step()
	{
		updateAllocation();
	}

	private void updateAllocation()
	{
		if (allocator.isAllocationDirty())
		{
			allocator.reloadDirtyElements();
		}
	}
}
