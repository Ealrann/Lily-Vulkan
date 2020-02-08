package org.sheepy.lily.openal.core.resource.util;

import static org.lwjgl.openal.AL10.*;

public final class AudioBufferData
{
	public final int ptr;

	public static AudioBufferData allocate(RawAudioBuffer rawAudioBuffer)
	{
		final int format = findFormat(rawAudioBuffer.channels);
		final var dataPtr = alGenBuffers();
		alBufferData(dataPtr, format, rawAudioBuffer.buffer, rawAudioBuffer.sampleRate);
		return new AudioBufferData(dataPtr);
	}

	private AudioBufferData(int dataPtr)
	{
		this.ptr = dataPtr;
	}

	public void free()
	{
		alDeleteBuffers(ptr);
	}

	private static int findFormat(int channels)
	{
		switch (channels)
		{
			case 1:
				return AL_FORMAT_MONO16;
			case 2:
				return AL_FORMAT_STEREO16;
			default:
				return -1;
		}
	}
}
