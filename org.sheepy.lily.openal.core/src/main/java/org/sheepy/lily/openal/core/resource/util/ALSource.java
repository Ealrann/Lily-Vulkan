package org.sheepy.lily.openal.core.resource.util;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioHandle;

import static org.lwjgl.openal.AL10.*;

public class ALSource
{
	public final int ptr;

	private AudioConfiguration config;

	public ALSource(AudioConfiguration config)
	{
		ptr = alGenSources();

		this.config = config;
		setGain(config.gain);
		setPitch(config.pitch);
		setLooping(config.repeat);
	}

	public void updateConfig(AudioConfiguration newConfig)
	{
		final var oldConfig = config;

		if (newConfig.repeat != oldConfig.repeat) setLooping(newConfig.repeat);
		if (newConfig.gain != oldConfig.gain) setGain(newConfig.gain);

		this.config = config;
	}

	public void play()
	{
		alSourcePlay(ptr);
	}

	public void setPause(boolean pause)
	{
		if (pause)
		{
			alSourcePause(ptr);
		}
		else
		{
			play();
		}
	}

	public void stop()
	{
		alSourceStop(ptr);
	}

	public void attachBuffer(AudioBufferData data)
	{
		alSourcei(ptr, AL_BUFFER, data.ptr);
	}

	public void queueBuffer(AudioBufferData data)
	{
		alSourceQueueBuffers(ptr, data.ptr);
	}

	public void setLooping(boolean loop)
	{
		final int alLoop = loop ? AL_TRUE : AL_FALSE;
		alSourcei(ptr, AL_LOOPING, alLoop);
	}

	public void setGain(float gain)
	{
		alSourcef(ptr, AL_GAIN, gain);
	}

	public void setPitch(float pitch)
	{
		alSourcef(ptr, AL_PITCH, pitch);
	}

	public IAudioHandle.EStatus getStatus()
	{
		final int state = alGetSourcei(ptr, AL_SOURCE_STATE);
		switch (state)
		{
			case AL_PLAYING:
				return IAudioHandle.EStatus.Playing;
			case AL_PAUSED:
				return IAudioHandle.EStatus.Paused;
			case AL_STOPPED:
				return IAudioHandle.EStatus.Stopped;
			case AL_INITIAL:
			default:
				return IAudioHandle.EStatus.Initialized;
		}
	}

	public void free()
	{
		alDeleteSources(ptr);
	}

	public AudioConfiguration getConfiguration()
	{
		return config;
	}
}
