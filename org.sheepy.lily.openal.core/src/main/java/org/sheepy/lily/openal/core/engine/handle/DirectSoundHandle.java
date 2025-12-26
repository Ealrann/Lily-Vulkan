package org.sheepy.lily.openal.core.engine.handle;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.resource.util.ALSource;
import org.sheepy.lily.openal.core.resource.util.AudioBufferData;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

public final class DirectSoundHandle implements IOpenALAudioHandle
{
	private final AudioBufferData audioData;
	private final ALSource source;

	public DirectSoundHandle(AudioConfiguration config, RawAudioBuffer rawAudioBuffer)
	{
		source = new ALSource(config);
		audioData = AudioBufferData.allocate(rawAudioBuffer);
		source.attachBuffer(audioData);
	}

	@Override
	public void play()
	{
		source.play();
	}

	@Override
	public void update()
	{
	}

	@Override
	public void setConfiguration(AudioConfiguration newConfig)
	{
		source.updateConfig(newConfig);
	}

	@Override
	public void end()
	{
		stop();
	}

	@Override
	public void free()
	{
		source.free();
		audioData.free();
	}

	@Override
	public EStatus getStatus()
	{
		return source.getStatus();
	}

	@Override
	public void setPause(boolean pause)
	{
		assert getStatus() != EStatus.Stopped;
		source.setPause(pause);
	}

	@Override
	public AudioConfiguration getConfiguration()
	{
		return source.getConfiguration();
	}

	@Override
	public void stop()
	{
		source.stop();
	}
}
