package org.sheepy.lily.openal.core.resource.decoder;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

public final class DecoderUtil
{
	public static RawAudioBuffer decode(MemoryStack stack, FileResource file)
	{
		final var fileAdapter = file.adaptNotNull(IFileResourceAdapter.class);
		final var byteBuffer = fileAdapter.allocByteBuffer(file);
		final var format = EAudioFormat.fromFileName(file.getPath());
		final var res = format.decoder.decode(stack, byteBuffer);
		MemoryUtil.memFree(byteBuffer);
		return res;
	}
}
