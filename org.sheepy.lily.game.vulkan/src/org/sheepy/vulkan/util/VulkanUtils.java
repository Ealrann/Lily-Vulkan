package org.sheepy.vulkan.util;

import static org.lwjgl.vulkan.EXTDebugReport.*;
import static org.lwjgl.vulkan.KHRDisplaySwapchain.VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_ERROR_NATIVE_WINDOW_IN_USE_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_ERROR_SURFACE_LOST_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.VK_ERROR_OUT_OF_DATE_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.VK_SUBOPTIMAL_KHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkLayerProperties;
import org.sheepy.vulkan.window.Window;

public class VulkanUtils
{

	public static void printAvailableExtensions(MemoryStack stack)
	{
		IntBuffer ip = stack.ints(1);
		vkEnumerateInstanceExtensionProperties((String) null, ip, null);

		if (ip.get(0) != 0)
		{
			VkExtensionProperties.Buffer instanceExtensions = VkExtensionProperties
					.mallocStack(ip.get(0), stack);
			vkEnumerateInstanceExtensionProperties((String) null, ip, instanceExtensions);

			System.out.println("System Extensions:");
			for (int i = 0; i < ip.get(0); i++)
			{
				System.out.println("\t" + instanceExtensions.get(i).extensionNameString());
			}
		}
	}

	public static void printAvailableLayers(MemoryStack stack)
	{
		IntBuffer ip = stack.ints(1);
		vkEnumerateInstanceLayerProperties(ip, null);

		if (ip.get(0) > 0)
		{
			VkLayerProperties.Buffer instanceLayers = VkLayerProperties.mallocStack(ip.get(0),
					stack);
			vkEnumerateInstanceLayerProperties(ip, instanceLayers);

			System.out.println("System Layers:");
			for (int i = 0; i < ip.get(0); i++)
			{
				System.out.println("\t" + instanceLayers.get(i).layerNameString());
			}
		}
	}

	public static long setupDebugCallback(MemoryStack stack, VkInstance vkInstance)
	{
		VkDebugReportCallbackCreateInfoEXT createInfo = VkDebugReportCallbackCreateInfoEXT
				.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
		createInfo.flags(VK_DEBUG_REPORT_ERROR_BIT_EXT | VK_DEBUG_REPORT_WARNING_BIT_EXT);
		createInfo.pfnCallback(new VkDebugReportCallbackEXT()
		{
			@Override
			public int invoke(int flags,
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

		LongBuffer pCallback = stack.callocLong(1);
		int err = vkCreateDebugReportCallbackEXT(vkInstance, createInfo, null, pCallback);
		long debugCallbackHandle = pCallback.get(0);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create VkInstance: " + translateVulkanResult(err));
		}
		return debugCallbackHandle;
	}

	public static PointerBuffer getRequiredExtensions(MemoryStack stack, Window window, boolean debug)
			throws AssertionError
	{
		/* Look for GLFW instance extensions */
		PointerBuffer glfwRequiredExtensions = window.getRequiredInstanceExtensions();
		if (glfwRequiredExtensions == null)
		{
			throw new AssertionError("Failed to find list of required Vulkan extensions");
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

	/**
	 * Translates a Vulkan {@code VkResult} value to a String describing the
	 * result.
	 * 
	 * @param result
	 *            the {@code VkResult} value
	 * 
	 * @return the result description
	 */
	public static String translateVulkanResult(int result)
	{
		switch (result)
		{
		// Success codes
		case VK_SUCCESS:
			return "Command successfully completed.";
		case VK_NOT_READY:
			return "A fence or query has not yet completed.";
		case VK_TIMEOUT:
			return "A wait operation has not completed in the specified time.";
		case VK_EVENT_SET:
			return "An event is signaled.";
		case VK_EVENT_RESET:
			return "An event is unsignaled.";
		case VK_INCOMPLETE:
			return "A return array was too small for the result.";
		case VK_SUBOPTIMAL_KHR:
			return "A swapchain no longer matches the surface properties exactly, but can still be used to present to the surface successfully.";

		// Error codes
		case VK_ERROR_OUT_OF_HOST_MEMORY:
			return "A host memory allocation has failed.";
		case VK_ERROR_OUT_OF_DEVICE_MEMORY:
			return "A device memory allocation has failed.";
		case VK_ERROR_INITIALIZATION_FAILED:
			return "Initialization of an object could not be completed for implementation-specific reasons.";
		case VK_ERROR_DEVICE_LOST:
			return "The logical or physical device has been lost.";
		case VK_ERROR_MEMORY_MAP_FAILED:
			return "Mapping of a memory object has failed.";
		case VK_ERROR_LAYER_NOT_PRESENT:
			return "A requested layer is not present or could not be loaded.";
		case VK_ERROR_EXTENSION_NOT_PRESENT:
			return "A requested extension is not supported.";
		case VK_ERROR_FEATURE_NOT_PRESENT:
			return "A requested feature is not supported.";
		case VK_ERROR_INCOMPATIBLE_DRIVER:
			return "The requested version of Vulkan is not supported by the driver or is otherwise incompatible for implementation-specific reasons.";
		case VK_ERROR_TOO_MANY_OBJECTS:
			return "Too many objects of the type have already been created.";
		case VK_ERROR_FORMAT_NOT_SUPPORTED:
			return "A requested format is not supported on this device.";
		case VK_ERROR_SURFACE_LOST_KHR:
			return "A surface is no longer available.";
		case VK_ERROR_NATIVE_WINDOW_IN_USE_KHR:
			return "The requested window is already connected to a VkSurfaceKHR, or to some other non-Vulkan API.";
		case VK_ERROR_OUT_OF_DATE_KHR:
			return "A surface has changed in such a way that it is no longer compatible with the swapchain, and further presentation requests using the "
					+ "swapchain will fail. Applications must query the new surface properties and recreate their swapchain if they wish to continue"
					+ "presenting to the surface.";
		case VK_ERROR_INCOMPATIBLE_DISPLAY_KHR:
			return "The display used by a swapchain does not use the same presentable image layout, or is incompatible in a way that prevents sharing an"
					+ " image.";
		case VK_ERROR_VALIDATION_FAILED_EXT:
			return "A validation layer found an error.";
		default:
			return String.format("%s [%d]", "Unknown", Integer.valueOf(result));
		}
	}
}
