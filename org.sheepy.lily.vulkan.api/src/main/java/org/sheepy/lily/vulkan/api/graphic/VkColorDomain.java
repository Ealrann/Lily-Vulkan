package org.sheepy.lily.vulkan.api.graphic;

public final class VkColorDomain
{
	public final int format;
	public final int colorSpace;

	public VkColorDomain(int format, int colorSpace)
	{
		this.format = format;
		this.colorSpace = colorSpace;
	}
}
