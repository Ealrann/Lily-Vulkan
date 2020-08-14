package org.sheepy.lily.openal.core.engine;

import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.model.openal.OpenALEngine;
import org.sheepy.lily.openal.model.openal.OpenalPackage;

@ModelExtender(scope = OpenALEngine.class)
@Allocation
//@AllocationChild(features = {OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
public final class OpenALEngineAdapter implements IEngineAdapter
{
	private final ISoundContext context;
	private final GameAllocationContext allocationContext;
	private final OpenALEngine engine;
//	private final IAllocationInstance<IEngineAdapter> engineAllocation;

	private OpenALEngineAdapter(OpenALEngine engine)
	{
		this.engine = engine;
		allocationContext = new GameAllocationContext();
		context = ISoundContext.newContext();
//		engineAllocation = IAllocationService.INSTANCE.allocate(engine, allocationContext, IEngineAdapter.class);
	}

	@ProvideContext
	private GameAllocationContext provideContext()
	{
		return allocationContext;
	}

	@Tick(frequency = 10, clock = ETickerClock.RealWorld)
	private void updateHandles()
	{
		context.updateHandles();
	}

	@Free
	public void stop()
	{
//		engineAllocation.free(allocationContext);
		context.destroy();
	}

	@Override
	public void step()
	{
		IAllocationService.INSTANCE.updateAllocation(engine, allocationContext, IEngineAdapter.class);
	}

	@Override
	public void waitIdle()
	{
	}

	public ISoundContext getContext()
	{
		return context;
	}
}
