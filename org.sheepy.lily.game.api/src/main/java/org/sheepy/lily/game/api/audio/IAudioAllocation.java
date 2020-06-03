package org.sheepy.lily.game.api.audio;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IAudioAllocation extends IExtender
{
	IAudioHandle play(AudioConfiguration config);

	default IAudioHandle play()
	{
		return play(new AudioConfiguration.Builder().build());
	}
}
