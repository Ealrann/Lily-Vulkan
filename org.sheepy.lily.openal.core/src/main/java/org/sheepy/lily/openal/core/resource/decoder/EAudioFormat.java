package org.sheepy.lily.openal.core.resource.decoder;

public enum EAudioFormat
{
	Vorbis("ogg", new VorbisDecoder());

	public final String extension;
	public final IDecoder decoder;

	EAudioFormat(String extension, IDecoder decoder)
	{
		this.extension = extension;
		this.decoder = decoder;
	}

	public static EAudioFormat fromFileName(String fileName)
	{
		for (var format : values())
		{
			if (fileName.endsWith(format.extension))
			{
				return format;
			}
		}
		return null;
	}
}
