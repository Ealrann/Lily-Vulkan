package org.sheepy.vulkan.common.util;

import static org.lwjgl.vulkan.EXTDebugReport.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkLayerProperties;
import org.sheepy.vulkan.common.window.Window;

public class VulkanUtils
{

	public static void printAvailableExtensions(MemoryStack stack)
	{
		final int[] ip = new int[1];
		vkEnumerateInstanceExtensionProperties((String) null, ip, null);
		final int count = ip[0];

		if (count != 0)
		{
			final var instanceExtensions = VkExtensionProperties.mallocStack(count, stack);
			vkEnumerateInstanceExtensionProperties((String) null, ip, instanceExtensions);

			System.out.println("System Extensions:");
			for (int i = 0; i < count; i++)
			{
				System.out.println("\t" + instanceExtensions.get(i).extensionNameString());
			}
		}
	}

	public static void printAvailableLayers(MemoryStack stack)
	{
		final int[] ip = new int[1];
		vkEnumerateInstanceLayerProperties(ip, null);
		final int count = ip[0];

		if (count > 0)
		{
			final var instanceLayers = VkLayerProperties.mallocStack(count, stack);
			vkEnumerateInstanceLayerProperties(ip, instanceLayers);

			System.out.println("System Layers:");
			for (int i = 0; i < count; i++)
			{
				System.out.println("\t" + instanceLayers.get(i).layerNameString());
			}
		}
	}

	public static long setupDebugCallback(MemoryStack stack, VkInstance vkInstance)
	{
		final VkDebugReportCallbackCreateInfoEXT createInfo = VkDebugReportCallbackCreateInfoEXT
				.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
		createInfo.flags(VK_DEBUG_REPORT_ERROR_BIT_EXT | VK_DEBUG_REPORT_WARNING_BIT_EXT);
		createInfo.pfnCallback(new VkDebugReportCallbackEXT()
		{
			@Override
			public int invoke(	int flags,
								int objectType,
								long object,
								long location,
								int messageCode,
								long pLayerPrefix,
								long pMessage,
								long pUserData)
			{
				System.err
						.println("ERROR OCCURED: " + VkDebugReportCallbackEXT.getString(pMessage));
				return 0;
			}
		});

		final LongBuffer pCallback = stack.callocLong(1);

		Logger.check("Can't create the Debug Report Callback",
				() -> vkCreateDebugReportCallbackEXT(vkInstance, createInfo, null, pCallback));

		return pCallback.get(0);
	}

	public static PointerBuffer getRequiredExtensions(MemoryStack stack, boolean debug)
	{
		/* Look for GLFW instance extensions */
		final PointerBuffer glfwRequiredExtensions = Window.getRequiredInstanceExtensions();
		if (glfwRequiredExtensions == null)
		{
			Logger.log("Failed to find list of required Vulkan extensions");
		}

		PointerBuffer requiredExtensions = glfwRequiredExtensions;

		if (debug)
		{
			requiredExtensions = stack.mallocPointer(glfwRequiredExtensions.capacity() + 1);

			for (int i = 0; i < glfwRequiredExtensions.capacity(); i++)
			{
				requiredExtensions.put(glfwRequiredExtensions.get(i));
			}
			requiredExtensions.put(stack.UTF8Safe(VK_EXT_DEBUG_REPORT_EXTENSION_NAME));
			requiredExtensions.flip();
		}

		return requiredExtensions;
	}
}
