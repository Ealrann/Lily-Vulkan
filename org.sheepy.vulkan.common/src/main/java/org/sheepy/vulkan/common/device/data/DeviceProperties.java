package org.sheepy.vulkan.common.device.data;

import static org.lwjgl.vulkan.VK10.vkGetPhysicalDeviceProperties;

import java.lang.reflect.Method;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceLimits;
import org.lwjgl.vulkan.VkPhysicalDeviceProperties;

public class DeviceProperties
{
	public final VkPhysicalDeviceProperties vkDeviceProperties = VkPhysicalDeviceProperties
			.create();

	public DeviceProperties(VkPhysicalDevice vkPhysicalDevice)
	{
		vkGetPhysicalDeviceProperties(vkPhysicalDevice, vkDeviceProperties);
	}

	public void print()
	{
		final VkPhysicalDeviceLimits limits = vkDeviceProperties.limits();
		Object[] NO_ARGS = new Object[0];

		for (Method method : VkPhysicalDeviceLimits.class.getDeclaredMethods())
		{
			if (method.getParameterCount() == 0 && method.canAccess(limits))
			{
				try
				{
					Object objectValue = method.invoke(limits, NO_ARGS);
					String value = "";
					if (objectValue instanceof IntBuffer)
					{
						IntBuffer buffer = (IntBuffer) objectValue;
						value = bufferToString(buffer, ", ");
					}
					else if (objectValue instanceof FloatBuffer)
					{
						FloatBuffer buffer = (FloatBuffer) objectValue;
						value = bufferToString(buffer, ", ");
					}
					else
					{
						value = String.valueOf(objectValue);
					}

					System.out.println(String.format("\t%s:\t\t%s", method.getName(), value));
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static final String bufferToString(IntBuffer buffer, String delimiter)
	{
		String value;
		String[] values = new String[buffer.limit()];
		for (int i = 0; i < buffer.limit(); i++)
		{
			values[i] = String.valueOf(buffer.get(i));
		}

		value = String.join(delimiter, values);
		return value;
	}

	public static final String bufferToString(FloatBuffer buffer, String delimiter)
	{
		String value;
		String[] values = new String[buffer.limit()];
		for (int i = 0; i < buffer.limit(); i++)
		{
			values[i] = String.valueOf(buffer.get(i));
		}

		value = String.join(delimiter, values);
		return value;
	}
}
