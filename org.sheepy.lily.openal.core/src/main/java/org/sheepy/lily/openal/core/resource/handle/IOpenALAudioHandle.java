package org.sheepy.lily.openal.core.resource.handle;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioHandle;

public interface IOpenALAudioHandle extends IAudioHandle
{
	void play();
	void update();
	void free();
}
