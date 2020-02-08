package org.sheepy.lily.openal.core.engine;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.game.api.audio.IAudioHandle;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.openal.core.resource.handle.IOpenALAudioHandle;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.openal.ALC10.*;

@Statefull
@Adapter(scope = OpenALEngine.class)
public final class OpenALEngineAdapter implements IEngineAdapter
{
	private final OpenALEngine engine;
	private final GenericAllocator<GameAllocationContext> resourceAllocator = new GenericAllocator<>(List.of(List.of(
			ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
			ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES)));
	private final IRootAllocator<GameAllocationContext> allocator;
	private final List<IOpenALAudioHandle> handles = new ArrayList<>();

	private long device;
	private long context;
	private ALCCapabilities alcCapabilities;
	private ALCapabilities alCapabilities;

	private OpenALEngineAdapter(OpenALEngine engine)
	{
		this.engine = engine;
		final var allocationContext = new GameAllocationContext();
		allocator = IAllocationService.INSTANCE.createAllocator(resourceAllocator.getAllocable(), allocationContext);
	}

	@Override
	public void start()
	{
		final String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
		final int[] attributes = {0};

		device = alcOpenDevice(defaultDeviceName);
		context = alcCreateContext(device, attributes);
		alcMakeContextCurrent(context);
		alcCapabilities = ALC.createCapabilities(device);
		alCapabilities = AL.createCapabilities(alcCapabilities);

		resourceAllocator.start(engine);
		allocator.allocate();
	}

	@Override
	public void stop()
	{
		allocator.free();
		resourceAllocator.stop(engine);
		alcDestroyContext(context);
		alcCloseDevice(device);
	}

	public void registerHandle(IOpenALAudioHandle handle)
	{
		handles.add(handle);
	}

	@Tick(frequency = 10, clock = ETickerClock.RealWorld)
	private void updateHandles()
	{
		final var it = handles.iterator();
		while (it.hasNext())
		{
			final var handle = it.next();
			handle.update();

			if (handle.getStatus() == IAudioHandle.EStatus.Stopped)
			{
				handle.free();
				it.remove();
			}
		}
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
