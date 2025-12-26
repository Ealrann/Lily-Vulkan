package org.sheepy.lily.vulkan.core.engine.extension;

import static org.lwjgl.vulkan.EXTDebugReport.VK_EXT_DEBUG_REPORT_EXTENSION_NAME;
import static org.lwjgl.vulkan.EXTDisplaySurfaceCounter.VK_EXT_DISPLAY_SURFACE_COUNTER_EXTENSION_NAME;
import static org.lwjgl.vulkan.KHRDisplay.VK_KHR_DISPLAY_EXTENSION_NAME;

public enum EInstanceExtension
{
	VK_KHR_display(VK_KHR_DISPLAY_EXTENSION_NAME),
	VK_EXT_debug_report(VK_EXT_DEBUG_REPORT_EXTENSION_NAME),
	VK_EXT_display_surface_counter(VK_EXT_DISPLAY_SURFACE_COUNTER_EXTENSION_NAME)

	;

	public final String name;

	EInstanceExtension(String name)
	{
		this.name = name;
	}

	public static EInstanceExtension findByName(String extensionName)
	{
		for (EInstanceExtension extension : values())
		{
			if (extension.name.equals(extensionName))
			{
				return extension;
			}
		}
		return null;
	}
}
