package org.sheepy.lily.openal.core.engine;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.game.core.allocation.ModelAllocator;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

import java.util.List;

@Statefull
@Adapter(scope = OpenALEngine.class)
public final class OpenALEngineAdapter implements IEngineAdapter
{
	private final OpenALEngine engine;
	private final ModelAllocator resourceAllocator = new ModelAllocator(List.of(List.of(ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
																						ResourcePackage.Literals.RESOURCE_PKG__RESOURCES)));

	private ISoundContext context = null;
	private final GameAllocationContext allocationContext;

	private OpenALEngineAdapter(OpenALEngine engine)
	{
		this.engine = engine;
		allocationContext = new GameAllocationContext();
	}

	@Override
	public void start()
	{
		context = ISoundContext.newContext();
		resourceAllocator.start(engine, allocationContext);
	}

	@Override
	public void stop()
	{
		resourceAllocator.stop(engine, allocationContext);
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
		resourceAllocator.update(allocationContext);
	}
}
