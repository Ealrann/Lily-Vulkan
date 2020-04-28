package org.sheepy.lily.openal.core.engine;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.game.core.allocation.ModelAllocator;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

import java.util.List;

@ModelExtender(scope = OpenALEngine.class)
@Adapter
public final class OpenALEngineAdapter implements IEngineAdapter
{
	private static final List<List<EReference>> RESOURCE_FEATURES = List.of(List.of(ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
																					ResourcePackage.Literals.RESOURCE_PKG__RESOURCES));
	private final ModelAllocator resourceAllocator;

	private ISoundContext context = null;
	private final GameAllocationContext allocationContext;

	private OpenALEngineAdapter(OpenALEngine engine)
	{
		allocationContext = new GameAllocationContext();
		resourceAllocator = new ModelAllocator(engine, RESOURCE_FEATURES);
	}

	@Override
	public void start()
	{
		context = ISoundContext.newContext();
		allocationContext.beforeChildrenAllocation();
		resourceAllocator.allocate(allocationContext);
		allocationContext.afterChildrenAllocation();
	}

	@Override
	public void stop()
	{
		resourceAllocator.free(allocationContext);
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
		allocationContext.beforeChildrenAllocation();
		resourceAllocator.update(allocationContext);
		allocationContext.afterChildrenAllocation();
	}
}
