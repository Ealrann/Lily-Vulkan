package org.sheepy.lily.openal.core.resource;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.Sound;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAllocation;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.OpenALEngineAllocation;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.core.engine.descriptor.DirectSoundDescriptor;
import org.sheepy.lily.openal.core.resource.decoder.DecoderUtil;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

@ModelExtender(scope = Sound.class)
@Allocation(context = IGameAllocationContext.class)
public final class SoundAllocation implements IAudioAllocation
{
	private final RawAudioBuffer rawAudioBuffer;
	private final ISoundContext soundContext;

	public SoundAllocation(Sound sound, IGameAllocationContext context)
	{
		final var stack = context.stack();
		final var file = sound.getFile();
		rawAudioBuffer = DecoderUtil.decode(stack, file);

		final var engine = ModelUtil.findParent(sound, OpenALEngine.class);
		final var engineAdapter = engine.adapt(OpenALEngineAllocation.class);
		soundContext = engineAdapter.getContext();
	}

	@Free
	public void free()
	{
		rawAudioBuffer.free();
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
