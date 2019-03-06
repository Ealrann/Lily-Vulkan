package org.sheepy.lily.vulkan.common.device;

public class DeviceExtension
{
	public final String name;
	public final boolean mandatory;

	public DeviceExtension(String name, boolean mandatory)
	{
		this.name = name;
		this.mandatory = mandatory;
	}
}
