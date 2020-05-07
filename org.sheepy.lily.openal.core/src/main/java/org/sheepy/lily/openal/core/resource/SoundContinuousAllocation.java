package org.sheepy.lily.openal.core.resource;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.SoundContinuous;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAllocation;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.core.engine.descriptor.StreamSoundDescriptor;
import org.sheepy.lily.openal.core.engine.handle.StreamPacket;
import org.sheepy.lily.openal.core.resource.decoder.DecoderUtil;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

@ModelExtender(scope = SoundContinuous.class)
@Allocation(context = IGameAllocationContext.class)
public final class SoundContinuousAllocation implements IAudioAllocation
{
	private final RawAudioBuffer rawAudioBuffer;
	private final RawAudioBuffer attackAudio;
	private final RawAudioBuffer sustainAudio;
	private final RawAudioBuffer decayAudio;
	private final ISoundContext soundContext;

	public SoundContinuousAllocation(SoundContinuous sound, IGameAllocationContext context)
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

	@Free
	public void free()
	{
		rawAudioBuffer.free();
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
