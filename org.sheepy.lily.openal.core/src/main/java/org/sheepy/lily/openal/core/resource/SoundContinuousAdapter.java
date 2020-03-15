package org.sheepy.lily.openal.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.SoundContinuous;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAdapter;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.core.engine.descriptor.StreamSoundDescriptor;
import org.sheepy.lily.openal.core.engine.handle.StreamPacket;
import org.sheepy.lily.openal.core.resource.decoder.DecoderUtil;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

@Statefull
@Adapter(scope = SoundContinuous.class)
public final class SoundContinuousAdapter implements IAudioAdapter, IAllocableAdapter<IGameAllocationContext>
{
	private final SoundContinuous sound;

	private RawAudioBuffer rawAudioBuffer;
	private RawAudioBuffer attackAudio;
	private RawAudioBuffer sustainAudio;
	private RawAudioBuffer decayAudio;
	private ISoundContext soundContext;

	private SoundContinuousAdapter(SoundContinuous sound)
	{
		this.sound = sound;
	}

	@Override
	public void allocate(IGameAllocationContext context)
	{
		final var stack = context.stack();
		final var file = sound.getFile();
		rawAudioBuffer = DecoderUtil.decode(stack, file);
		final int attackMs = sound.getAttackMs();
		final int decayMs = sound.getDecayMs();
		final int totalMs = rawAudioBuffer.lengthMs();
		attackAudio = rawAudioBuffer.slice(0, attackMs);
		sustainAudio = rawAudioBuffer.slice(attackMs, decayMs);
		decayAudio = rawAudioBuffer.slice(decayMs, totalMs);

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
		final var descriptor = new StreamSoundDescriptor(config, this::getAudioPacket, this::getFinalAudioPacket);
		final var handle = soundContext.newHandle(descriptor);
		handle.play();
		return handle;
	}

	private StreamPacket getAudioPacket(int index)
	{
		final var status = StreamPacket.EStatus.Ready;
		final var data = index == 0 ? attackAudio : sustainAudio;
		return new StreamPacket(status, data);
	}

	private StreamPacket getFinalAudioPacket(int index)
	{
		final var status = index == 0 ? StreamPacket.EStatus.Ready : StreamPacket.EStatus.End;
		final var data = index == 0 ? decayAudio : null;
		return new StreamPacket(status, data);
	}
}
