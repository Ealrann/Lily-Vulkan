package org.sheepy.lily.openal.core.engine.handle;

import org.sheepy.lily.game.api.audio.AudioConfiguration;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;
import org.sheepy.lily.openal.core.resource.util.ALSource;
import org.sheepy.lily.openal.core.resource.util.AudioBufferData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class StreamSoundHandle implements IOpenALAudioHandle
{
	private final StreamSource mainSource;
	private final StreamSource finalSource;
	private final Runnable onDispose;

	private StreamSource currentSource;
	private AudioConfiguration config;
	private boolean finalize = false;

	public StreamSoundHandle(AudioConfiguration config,
							 IntFunction<StreamPacket> audioSupplier,
							 IntFunction<StreamPacket> finalizeAudioSupplier)
	{
		this(config, audioSupplier, finalizeAudioSupplier, null);
	}

	public StreamSoundHandle(AudioConfiguration config,
							 IntFunction<StreamPacket> audioSupplier,
							 IntFunction<StreamPacket> finalizeAudioSupplier,
							 Runnable onDispose)
	{
		this.config = config;
		this.mainSource = new StreamSource(config, audioSupplier);
		this.finalSource = finalizeAudioSupplier != null ? new StreamSource(config, finalizeAudioSupplier) : null;
		this.onDispose = onDispose;

		currentSource = mainSource;
	}

	@Override
	public void play()
	{
		mainSource.play();
	}

	@Override
	public void update()
	{
		if (finalize && currentSource == mainSource && finalSource != null)
		{
			currentSource = finalSource;
			finalSource.play();
			mainSource.stop();
		}
		else if (!currentSource.end)
		{
			currentSource.update();
		}
	}

	@Override
	public void setConfiguration(AudioConfiguration newConfig)
	{
		this.config = newConfig;
	}

	@Override
	public void end()
	{
		finalize = true;
	}

	@Override
	public void free()
	{
		if (onDispose != null) onDispose.run();
		mainSource.free();
		if (finalSource != null) finalSource.free();
	}

	@Override
	public EStatus getStatus()
	{
		return currentSource.source.getStatus();
	}

	@Override
	public void setPause(boolean pause)
	{
		assert getStatus() != EStatus.Stopped;
		currentSource.source.setPause(pause);
	}

	@Override
	public AudioConfiguration getConfiguration()
	{
		return config;
	}

	@Override
	public void stop()
	{
		currentSource.stop();
	}

	private static final class StreamSource
	{
		private final IntFunction<StreamPacket> audioSupplier;
		private final ALSource source;
		private final List<AudioBufferData> queue = new ArrayList<>();

		private boolean end = false;
		private int queueDurationMs = 0;
		private int index = 0;
		private long playDateMs = 0;
		private boolean playRequest = false;

		public StreamSource(AudioConfiguration config, IntFunction<StreamPacket> audioSupplier)
		{
			source = new ALSource(config);
			this.audioSupplier = audioSupplier;
			gatherData();
		}

		public void play()
		{
			if (queueDurationMs > 0)
			{
				source.play();
				playDateMs = System.currentTimeMillis();
				playRequest = false;
			}
			else
			{
				playRequest = true;
			}
		}

		public void update()
		{
			final int playedMs = playDateMs == 0 ? 0 : (int) (System.currentTimeMillis() - playDateMs);
			final int remainMs = queueDurationMs - playedMs;
			if (remainMs < 200)
			{
				gatherData();

				if (playRequest && queueDurationMs > 0)
				{
					play();
				}
			}
		}

		private void gatherData()
		{
			final var nextPacket = audioSupplier.apply(index);
			if (nextPacket.status == StreamPacket.EStatus.End)
			{
				end = true;
			}
			else if (nextPacket.status == StreamPacket.EStatus.Ready)
			{
				final var nextBuffer = nextPacket.data;
				final var audioData = AudioBufferData.allocate(nextBuffer);
				source.queueBuffer(audioData);
				queue.add(audioData);
				queueDurationMs += nextBuffer.lengthMs();
				index++;
			}
		}

		public void stop()
		{
			source.stop();
		}

		public void free()
		{
			source.free();
			for (var audioData : queue)
			{
				audioData.free();
			}
		}
	}
}
