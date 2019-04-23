package org.sheepy.vulkan.device.loader;

import static org.lwjgl.vulkan.KHRDisplay.vkGetPhysicalDeviceDisplayPropertiesKHR;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDisplayPropertiesKHR;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.device.data.DisplayInfo;

public class DisplayInformationLoader
{
	public static final List<DisplayInfo> getDisplayInfos(	MemoryStack stack,
															VkPhysicalDevice device)
	{
		List<DisplayInfo> res = new ArrayList<>();
		IntBuffer countBuffer = stack.callocInt(1);
		vkGetPhysicalDeviceDisplayPropertiesKHR(device, countBuffer, null);

		int count = countBuffer.get(0);
		if (count > 0)
		{
			VkDisplayPropertiesKHR.Buffer properties = VkDisplayPropertiesKHR.callocStack(count,
					stack);

			vkGetPhysicalDeviceDisplayPropertiesKHR(device, countBuffer, properties);

			for (int i = 0; i < count; i++)
			{
				VkDisplayPropertiesKHR displayProperties = properties.get(i);

				var displayAddress = displayProperties.display();
				var displayName = displayProperties.displayNameString();

				res.add(new DisplayInfo(displayAddress, displayName));
			}
		}

		return List.copyOf(res);
	}
}
