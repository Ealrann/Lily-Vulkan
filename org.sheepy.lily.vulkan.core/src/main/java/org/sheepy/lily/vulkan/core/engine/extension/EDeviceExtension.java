package org.sheepy.lily.vulkan.core.engine.extension;

import static org.lwjgl.vulkan.EXTDisplayControl.VK_EXT_DISPLAY_CONTROL_EXTENSION_NAME;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;

public enum EDeviceExtension
{
	VK_KHR_swapchain(VK_KHR_SWAPCHAIN_EXTENSION_NAME, true),
	VK_EXT_display_control(VK_EXT_DISPLAY_CONTROL_EXTENSION_NAME, false)

	;

	public final String name;
	public final boolean mandatory;

	EDeviceExtension(String name, boolean mandatory)
	{
		this.name = name;
		this.mandatory = mandatory;
	}

	public static EDeviceExtension findByName(String extensionName)
	{
		for (EDeviceExtension extension : values())
		{
			if (extension.name.equals(extensionName))
			{
				return extension;
			}
		}
		return null;
	}
}
