package org.sheepy.lily.game.api.audio;

public interface IAudioHandle
{
	enum EStatus
	{
		Initialized,
		Playing,
		Paused,
		Stopped
	}

	EStatus getStatus();
	void setPause(boolean pause);
	AudioConfiguration getConfiguration();
	void setConfiguration(AudioConfiguration config);

	// Request the sound to end (if applicable, the sound will decay).
	void end();

	// Stop now
	void stop();

	default void setRepeat(boolean repeat)
	{
		final var newConfig = getConfiguration().builder().repeat(repeat).build();
		setConfiguration(newConfig);
	}
}
