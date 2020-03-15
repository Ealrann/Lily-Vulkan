package org.sheepy.lily.openal.core.engine.context;

import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;

public interface ISoundContext
{
	static ISoundContext newContext()
	{
		return SoundContext.allocate().orElseGet(FakeContext::new);
	}

	IOpenALAudioHandle newHandle(IOpenALAudioHandle.ISoundDescriptor descriptor);
	void updateHandles();
	void destroy();
}
