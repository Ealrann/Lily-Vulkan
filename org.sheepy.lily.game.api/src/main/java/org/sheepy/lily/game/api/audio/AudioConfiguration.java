package org.sheepy.lily.game.api.audio;

public final class AudioConfiguration
{
	public final boolean repeat;
	public final float gain;
	public final float pitch;

	public AudioConfiguration(boolean repeat, float gain, float pitch)
	{
		this.repeat = repeat;
		this.gain = gain;
		this.pitch = pitch;
	}

	public Builder builder()
	{
		return new Builder(this);
	}

	public static final class Builder
	{
		private boolean repeat = false;
		private float gain = 1f;
		private float pitch = 1f;

		public Builder()
		{
		}

		public Builder(AudioConfiguration audioConfiguration)
		{
			this.repeat = audioConfiguration.repeat;
			this.gain = audioConfiguration.gain;
			this.pitch = audioConfiguration.pitch;
		}

		public boolean repeat()
		{
			return repeat;
		}

		public Builder repeat(boolean repeat)
		{
			this.repeat = repeat;
			return this;
		}

		public float gain()
		{
			return gain;
		}

		public Builder gain(float gain)
		{
			this.gain = gain;
			return this;
		}

		public float pitch()
		{
			return pitch;
		}

		public Builder pitch(float pitch)
		{
			this.pitch = pitch;
			return this;
		}

		public AudioConfiguration build()
		{
			return new AudioConfiguration(repeat, gain, pitch);
		}
	}
}
