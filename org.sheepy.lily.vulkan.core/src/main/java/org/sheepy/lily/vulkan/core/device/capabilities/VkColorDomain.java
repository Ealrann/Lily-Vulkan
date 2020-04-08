package org.sheepy.lily.vulkan.core.device.capabilities;

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
