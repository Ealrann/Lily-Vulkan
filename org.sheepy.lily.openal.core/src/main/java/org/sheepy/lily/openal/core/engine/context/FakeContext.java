package org.sheepy.lily.openal.core.engine.context;

import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.handle.FakeHandle;

class FakeContext implements ISoundContext
{
	@Override
	public IOpenALAudioHandle newHandle(final IOpenALAudioHandle.ISoundDescriptor descriptor)
	{
		return new FakeHandle(descriptor.getConfiguration());
	}

	@Override
	public void updateHandles()
	{
	}

	@Override
	public void destroy()
	{
	}
}
