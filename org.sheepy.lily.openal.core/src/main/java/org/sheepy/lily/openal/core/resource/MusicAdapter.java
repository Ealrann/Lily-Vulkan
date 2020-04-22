package org.sheepy.lily.openal.core.resource;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocable;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.game.api.audio.IAudioAdapter;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.engine.OpenALEngineAdapter;
import org.sheepy.lily.openal.core.engine.context.ISoundContext;
import org.sheepy.lily.openal.core.engine.descriptor.StreamSoundDescriptor;
import org.sheepy.lily.openal.core.engine.handle.StreamPacket;
import org.sheepy.lily.openal.core.resource.decoder.EAudioFormat;
import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;
import org.sheepy.lily.openal.model.openal.OpenALEngine;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntFunction;

@Statefull
@Adapter(scope = Music.class)
@Allocable(context = IGameAllocationContext.class)
public final class MusicAdapter implements IAudioAdapter
{
	private final ByteBuffer encodedBuffer;
	private final EAudioFormat format;
	private final ISoundContext soundContext;

	public MusicAdapter(Music music)
	{
		final var file = music.getFile();
		final var fileAdapter = file.adaptNotNull(IFileResourceAdapter.class);
		encodedBuffer = fileAdapter.allocByteBuffer(file);
		format = EAudioFormat.fromFileName(file.getPath());

		final var engine = ModelUtil.findParent(music, OpenALEngine.class);
		final var engineAdapter = engine.adapt(OpenALEngineAdapter.class);
		soundContext = engineAdapter.getContext();
	}

	@Free
	public void free()
	{
		MemoryUtil.memFree(encodedBuffer);
	}

	@Override
	public IOpenALAudioHandle play(AudioConfiguration config)
	{
		final var supplier = new DecodedAudioSupplier(format, encodedBuffer);
		final var descriptor = new StreamSoundDescriptor(config, supplier, null, supplier::free);
		final var handle = soundContext.newHandle(descriptor);

		handle.play();

		return handle;
	}

	private static final class DecodedAudioSupplier implements IntFunction<StreamPacket>
	{
		private final ExecutorService executor = Executors.newFixedThreadPool(1);
		private final Future<RawAudioBuffer> future;

		private RawAudioBuffer rawAudioBuffer = null;

		public DecodedAudioSupplier(EAudioFormat format, ByteBuffer encodedBuffer)
		{
			future = executor.submit(() -> {
				try (final var stack = MemoryStack.stackPush())
				{
					return format.decoder.decode(stack, encodedBuffer);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return null;
				}
			});
		}

		@Override
		public StreamPacket apply(int index)
		{
			final var done = future.isDone();
			final var status = index ==
							   0 ? (done ? StreamPacket.EStatus.Ready : StreamPacket.EStatus.Delayed) : StreamPacket.EStatus.End;

			if (done && rawAudioBuffer == null)
			{
				try
				{
					rawAudioBuffer = future.get();
				}
				catch (InterruptedException | ExecutionException e)
				{
					e.printStackTrace();
				}
			}

			return new StreamPacket(status, rawAudioBuffer);
		}

		public void free()
		{
			if (executor.isTerminated() == false)
				executor.shutdownNow();
			if (rawAudioBuffer != null)
				rawAudioBuffer.free();
		}
	}
}
