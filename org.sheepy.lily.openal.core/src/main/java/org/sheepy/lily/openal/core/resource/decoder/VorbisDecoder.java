package org.sheepy.lily.openal.core.resource.decoder;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.stb.STBVorbis.stb_vorbis_decode_memory;

public final class VorbisDecoder implements IDecoder
{
	@Override
	public RawAudioBuffer decode(MemoryStack stack, ByteBuffer encodedData)
	{
		final IntBuffer channelsBuffer = stack.mallocInt(1);
		final IntBuffer sampleRateBuffer = stack.mallocInt(1);

		final var rawAudioBuffer = stb_vorbis_decode_memory(encodedData, channelsBuffer, sampleRateBuffer);
		final int channels = channelsBuffer.get();
		final int sampleRate = sampleRateBuffer.get();

		return new RawAudioBuffer(rawAudioBuffer, channels, sampleRate);
	}
}
