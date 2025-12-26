package org.sheepy.lily.openal.core.resource.util;

import org.lwjgl.system.libc.LibCStdlib;

import java.nio.ShortBuffer;

public final class RawAudioBuffer
{
	public final ShortBuffer buffer;
	public final int channels;
	public final int sampleRate;

	public RawAudioBuffer(ShortBuffer buffer, int channels, int sampleRate)
	{
		this.buffer = buffer;
		this.channels = channels;
		this.sampleRate = sampleRate;
	}

	public RawAudioBuffer slice(int startMs, int endMs)
	{
		assert endMs <= lengthMs();

		final int frameStart = frame(startMs);
		final int frameEnd = frame(endMs);
		final int initialPosition = buffer.position();
		final int initialLimit = buffer.limit();

		buffer.position(frameStart);
		buffer.limit(frameEnd);
		final var subBuffer = buffer.slice();
		buffer.position(initialPosition);
		buffer.limit(initialLimit);

		return new RawAudioBuffer(subBuffer, channels, sampleRate);
	}

	public int lengthMs()
	{
		final int frameCount = buffer.limit();
		final int frameCountPerChannel = frameCount / channels;
		final int lengthMs = (int) (frameCountPerChannel * 1000L / sampleRate);

		return lengthMs;
	}

	public int frame(int positionMs)
	{
		return (int) ((positionMs * sampleRate * channels) / 1000f);
	}

	public void free()
	{
		LibCStdlib.free(buffer);
	}
}
