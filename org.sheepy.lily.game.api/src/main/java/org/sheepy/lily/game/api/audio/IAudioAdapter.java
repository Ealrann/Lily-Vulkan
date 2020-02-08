package org.sheepy.lily.game.api.audio;

import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IAudioAdapter extends IAdapter
{
	IAudioHandle play(AudioConfiguration config);

	default IAudioHandle play()
	{
		return play(new AudioConfiguration.Builder().build());
	}
}
