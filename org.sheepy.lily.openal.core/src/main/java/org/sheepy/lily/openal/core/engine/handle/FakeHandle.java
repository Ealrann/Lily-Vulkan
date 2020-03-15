package org.sheepy.lily.openal.core.engine.handle;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;

public final class FakeHandle implements IOpenALAudioHandle
{
	private final AudioConfiguration config;

	public FakeHandle(AudioConfiguration config)
	{
		this.config = config;
	}

	@Override
	public void play()
	{
	}

	@Override
	public void update()
	{
	}

	@Override
	public void free()
	{
	}

	@Override
	public EStatus getStatus()
	{
		return EStatus.Stopped;
	}

	@Override
	public void setPause(final boolean pause)
	{
	}

	@Override
	public AudioConfiguration getConfiguration()
	{
		return config;
	}

	@Override
	public void setConfiguration(final AudioConfiguration config)
	{
	}

	@Override
	public void end()
	{
	}

	@Override
	public void stop()
	{
	}
}
