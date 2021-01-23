package org.sheepy.lily.game.api.audio;

import org.logoce.extender.api.IAdapter;

public interface IAudioAllocation extends IAdapter
{
	IAudioHandle play(AudioConfiguration config);

	default IAudioHandle play()
	{
		return play(new AudioConfiguration.Builder().build());
	}
}
