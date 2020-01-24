package org.sheepy.lily.vulkan.common.device.capabilities;

public class VkColorDomain
{
	public final int format;
	public final int colorSpace;
	
	public VkColorDomain(int format, int colorSpace)
	{
		this.format = format;
		this.colorSpace = colorSpace;
	}
}
