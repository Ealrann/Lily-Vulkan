package org.sheepy.lily.openal.core;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.resource.MusicAdapter;
import org.sheepy.lily.openal.core.resource.SoundAdapter;
import org.sheepy.lily.openal.core.resource.SoundContinuousAdapter;

import java.util.List;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(OpenALEngineAdapter.class, SoundAdapter.class, SoundContinuousAdapter.class, MusicAdapter.class);
	}
}
