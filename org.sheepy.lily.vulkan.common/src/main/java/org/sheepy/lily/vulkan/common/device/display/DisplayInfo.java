package org.sheepy.lily.vulkan.common.device.display;

public class DisplayInfo
{
	public final long address;
	public final String name;

	public DisplayInfo(long address, String name)
	{
		this.address = address;
		this.name = name;
	}
}
