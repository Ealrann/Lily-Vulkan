package org.sheepy.vulkan.device.capabilities;

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
