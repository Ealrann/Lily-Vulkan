package org.sheepy.lily.openal.core.engine.descriptor;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.handle.StreamPacket;
import org.sheepy.lily.openal.core.engine.handle.StreamSoundHandle;

import java.util.function.IntFunction;

public final class StreamSoundDescriptor implements IOpenALAudioHandle.ISoundDescriptor
{
	private final AudioConfiguration config;
	private final IntFunction<StreamPacket> audioSupplier;
	private final IntFunction<StreamPacket> finalizeAudioSupplier;
	private final Runnable onDispose;

	public StreamSoundDescriptor(AudioConfiguration config,
								 IntFunction<StreamPacket> audioSupplier,
								 IntFunction<StreamPacket> finalizeAudioSupplier)
	{
		this(config, audioSupplier, finalizeAudioSupplier, null);
	}

	public StreamSoundDescriptor(AudioConfiguration config,
								 IntFunction<StreamPacket> audioSupplier,
								 IntFunction<StreamPacket> finalizeAudioSupplier,
								 Runnable onDispose)
	{
		this.config = config;
		this.audioSupplier = audioSupplier;
		this.finalizeAudioSupplier = finalizeAudioSupplier;
		this.onDispose = onDispose;
	}

	@Override
	public IOpenALAudioHandle build()
	{
		return new StreamSoundHandle(config, audioSupplier, finalizeAudioSupplier, onDispose);
	}

	@Override
	public AudioConfiguration getConfiguration()
	{
		return config;
	}
}
