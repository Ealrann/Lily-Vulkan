package org.sheepy.lily.game.api.audio;

import org.sheepy.lily.core.api.allocation.IAllocation;

public interface IAudioAllocation extends IAllocation
{
	IAudioHandle play(AudioConfiguration config);

	default IAudioHandle play()
	{
		return play(new AudioConfiguration.Builder().build());
	}
}
