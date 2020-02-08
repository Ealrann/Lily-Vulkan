package org.sheepy.lily.openal.core.resource;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.resource.IResourceAdapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.Sound;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAdapter;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.resource.decoder.DecoderUtil;
import org.sheepy.lily.openal.core.resource.handle.DirectSoundHandle;
import org.sheepy.lily.openal.core.resource.handle.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

@Statefull
@Adapter(scope = Sound.class)
public final class SoundAdapter implements IAudioAdapter, IResourceAdapter<IGameAllocationContext>
{
	private final Sound sound;
	private final OpenALEngine engine;

	private RawAudioBuffer rawAudioBuffer;

	private SoundAdapter(Sound sound)
	{
		this.sound = sound;
		engine = ModelUtil.findParent(sound, OpenALEngine.class);
	}

	@Override
	public void allocate(IGameAllocationContext context)
	{
		final var stack = context.stack();
		final var file = sound.getFile();
		rawAudioBuffer = DecoderUtil.decode(stack, file);
	}

	@Override
	public void free(IGameAllocationContext context)
	{
		rawAudioBuffer.free();
		rawAudioBuffer = null;
	}

	@Override
	public IOpenALAudioHandle play(AudioConfiguration config)
	{
		final var handle = new DirectSoundHandle(config, rawAudioBuffer);
		engine.adapt(OpenALEngineAdapter.class).registerHandle(handle);
		handle.play();
		return handle;
	}
}
