package org.sheepy.lily.openal.core;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.openal.core.engine.OpenALEngineAllocation;
import org.sheepy.lily.openal.core.resource.MusicAllocation;
import org.sheepy.lily.openal.core.resource.SoundAllocation;
import org.sheepy.lily.openal.core.resource.SoundContinuousAllocation;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(OpenALEngineAllocation.class,
					   SoundAllocation.class,
					   SoundContinuousAllocation.class,
					   MusicAllocation.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
