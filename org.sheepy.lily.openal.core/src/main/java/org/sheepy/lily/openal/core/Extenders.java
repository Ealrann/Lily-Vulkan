package org.sheepy.lily.openal.core;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.openal.core.engine.OpenALEngineAllocation;
import org.sheepy.lily.openal.core.resource.MusicAllocation;
import org.sheepy.lily.openal.core.resource.SoundAllocation;
import org.sheepy.lily.openal.core.resource.SoundContinuousAllocation;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(OpenALEngineAllocation.class,
					   SoundAllocation.class,
					   SoundContinuousAllocation.class,
					   MusicAllocation.class);
	}
}
