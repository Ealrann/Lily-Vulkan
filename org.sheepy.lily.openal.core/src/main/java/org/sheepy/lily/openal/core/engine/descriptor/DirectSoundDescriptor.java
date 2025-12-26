package org.sheepy.lily.openal.core.engine.descriptor;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.handle.DirectSoundHandle;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

public final class DirectSoundDescriptor implements IOpenALAudioHandle.ISoundDescriptor
{
	private final AudioConfiguration config;
	private final RawAudioBuffer rawAudioBuffer;

	public DirectSoundDescriptor(AudioConfiguration config, RawAudioBuffer rawAudioBuffer)
	{
		this.config = config;
		this.rawAudioBuffer = rawAudioBuffer;
	}

	@Override
	public IOpenALAudioHandle build()
	{
		return new DirectSoundHandle(config, rawAudioBuffer);
	}

	@Override
	public AudioConfiguration getConfiguration()
	{
		return config;
	}
}
