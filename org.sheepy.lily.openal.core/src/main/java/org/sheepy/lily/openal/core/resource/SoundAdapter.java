package org.sheepy.lily.openal.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.Sound;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAdapter;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.core.engine.descriptor.DirectSoundDescriptor;
import org.sheepy.lily.openal.core.resource.decoder.DecoderUtil;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

@Statefull
@Adapter(scope = Sound.class)
public final class SoundAdapter implements IAudioAdapter, IAllocableAdapter<IGameAllocationContext>
{
	private final Sound sound;

	private RawAudioBuffer rawAudioBuffer;
	private ISoundContext soundContext;

	private SoundAdapter(Sound sound)
	{
		this.sound = sound;
	}

	@Override
	public void allocate(IGameAllocationContext context)
	{
		final var stack = context.stack();
		final var file = sound.getFile();
		rawAudioBuffer = DecoderUtil.decode(stack, file);

		final var engine = ModelUtil.findParent(sound, OpenALEngine.class);
		final var engineAdapter = engine.adapt(OpenALEngineAdapter.class);
		soundContext = engineAdapter.getContext();
	}

	@Override
	public void free(IGameAllocationContext context)
	{
		rawAudioBuffer.free();
		rawAudioBuffer = null;
		soundContext = null;
	}

	@Override
	public IOpenALAudioHandle play(AudioConfiguration config)
	{
		final var descriptor = new DirectSoundDescriptor(config, rawAudioBuffer);
		final var handle = soundContext.newHandle(descriptor);
		handle.play();
		return handle;
	}
}
