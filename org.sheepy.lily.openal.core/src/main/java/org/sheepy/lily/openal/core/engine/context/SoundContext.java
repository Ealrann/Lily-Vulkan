package org.sheepy.lily.openal.core.engine.context;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.sheepy.lily.game.api.audio.IAudioHandle;
import org.sheepy.lily.openal.core.engine.IOpenALAudioHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.lwjgl.openal.ALC10.*;

public final class SoundContext implements ISoundContext
{
	private final long device;
	private final long context;
	private ALCCapabilities alcCapabilities;
	private ALCapabilities alCapabilities;

	private final List<IOpenALAudioHandle> handles = new ArrayList<>();

	public static Optional<ISoundContext> allocate()
	{
		try
		{
			final int[] attributes = {0};
			final String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
			final long device = alcOpenDevice(defaultDeviceName);
			final long context = alcCreateContext(device, attributes);
			alcMakeContextCurrent(context);
			final var alcCapabilities = ALC.createCapabilities(device);
			final var alCapabilities = AL.createCapabilities(alcCapabilities);
			return Optional.of(new SoundContext(device, context, alcCapabilities, alCapabilities));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Optional.empty();
		}
	}

	private SoundContext(long device,
						 long context,
						 final ALCCapabilities alcCapabilities,
						 final ALCapabilities alCapabilities)
	{
		this.device = device;
		this.context = context;
		this.alcCapabilities = alcCapabilities;
		this.alCapabilities = alCapabilities;
	}

	@Override
	public IOpenALAudioHandle newHandle(final IOpenALAudioHandle.ISoundDescriptor descriptor)
	{
		final IOpenALAudioHandle handle = descriptor.build();
		handles.add(handle);
		return handle;
	}

	@Override
	public void destroy()
	{
		alcDestroyContext(context);
		alcCloseDevice(device);
	}

	@Override
	public void updateHandles()
	{
		final var it = handles.iterator();
		while (it.hasNext())
		{
			final var handle = it.next();
			handle.update();

			if (handle.getStatus() == IAudioHandle.EStatus.Stopped)
			{
				handle.free();
				it.remove();
			}
		}
	}
}