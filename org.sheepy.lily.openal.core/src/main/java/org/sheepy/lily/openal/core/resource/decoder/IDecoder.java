package org.sheepy.lily.openal.core.resource.decoder;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

import java.nio.ByteBuffer;

public interface IDecoder
{
	RawAudioBuffer decode(MemoryStack stack, ByteBuffer encodedData);
}
