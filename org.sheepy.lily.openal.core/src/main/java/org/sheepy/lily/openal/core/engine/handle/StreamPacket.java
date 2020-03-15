package org.sheepy.lily.openal.core.engine.handle;

import org.sheepy.lily.openal.core.resource.util.RawAudioBuffer;

public final class StreamPacket
	{
		public enum EStatus
		{
			Ready,
			Delayed,
			End
		}

		public final EStatus status;
		public final RawAudioBuffer data;

		public StreamPacket(EStatus status, RawAudioBuffer data)
		{
			this.status = status;
			this.data = data;
		}
	}