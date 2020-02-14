package org.sheepy.lily.vulkan.core.device.data;

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
		final Object[] NO_ARGS = new Object[0];

		for (final Method method : VkPhysicalDeviceLimits.class.getDeclaredMethods())
		{
			if (method.getParameterCount() == 0 && method.canAccess(limits))
			{
				try
				{
					final Object objectValue = method.invoke(limits, NO_ARGS);
					final String value;
					if (objectValue instanceof IntBuffer)
					{
						final IntBuffer buffer = (IntBuffer) objectValue;
						value = bufferToString(buffer, ", ");
					}
					else if (objectValue instanceof FloatBuffer)
					{
						final FloatBuffer buffer = (FloatBuffer) objectValue;
						value = bufferToString(buffer, ", ");
					}
					else
					{
						value = String.valueOf(objectValue);
					}

					System.out.println(String.format("\t%-48s: %-10s", method.getName(), value));
				} catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static final String bufferToString(IntBuffer buffer, String delimiter)
	{
		final String[] values = new String[buffer.limit()];
		for (int i = 0; i < buffer.limit(); i++)
		{
			values[i] = String.valueOf(buffer.get(i));
		}

		return String.join(delimiter, values);
	}

	public static final String bufferToString(FloatBuffer buffer, String delimiter)
	{
		final String[] values = new String[buffer.limit()];
		for (int i = 0; i < buffer.limit(); i++)
		{
			values[i] = String.valueOf(buffer.get(i));
		}

		return String.join(delimiter, values);
	}
}
