package org.sheepy.vulkan.extension;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceExtensionProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.window.Window;

public class EngineExtensionRequirement
{
	private final List<EInstanceExtension> requiredInstanceExtensions;
	private final List<String> availableInstanceExtensions;
	private final List<EDeviceExtension> requiredDeviceExtensions;

	public EngineExtensionRequirement(MemoryStack stack, boolean debug)
	{
		requiredDeviceExtensions = List.copyOf(gatherDeviceExtensions());
		availableInstanceExtensions = List.copyOf(gatherAvailableInstanceExtensions(stack, debug));
		requiredInstanceExtensions = List.copyOf(gatherInstanceExtensions(debug));
	}

	public PointerBuffer getRequiredInstanceExtensions(MemoryStack stack)
	{
		/* Look for GLFW instance extensions */
		final PointerBuffer glfwRequiredExtensions = Window.getRequiredInstanceExtensions();
		if (glfwRequiredExtensions == null)
		{
			Logger.log("Failed to find list of required Vulkan extensions");
		}

		var res = glfwRequiredExtensions;

		if (requiredInstanceExtensions.isEmpty() == false)
		{
			res = stack.mallocPointer(
					glfwRequiredExtensions.capacity() + requiredInstanceExtensions.size());

			for (int i = 0; i < glfwRequiredExtensions.capacity(); i++)
			{
				res.put(glfwRequiredExtensions.get(i));
			}

			for (final EInstanceExtension extension : requiredInstanceExtensions)
			{
				res.put(stack.UTF8Safe(extension.name));
			}

			res.flip();
		}

		return res;
	}

	public static List<String> gatherAvailableInstanceExtensions(MemoryStack stack, boolean debug)
	{
		final List<String> extensions = new ArrayList<>();

		final int[] ip = new int[1];
		vkEnumerateInstanceExtensionProperties((String) null, ip, null);
		final int count = ip[0];

		if (count != 0)
		{
			final var instanceExtensions = VkExtensionProperties.mallocStack(count, stack);
			vkEnumerateInstanceExtensionProperties((String) null, ip, instanceExtensions);

			if (debug)
			{
				System.out.println("Available Instance Extensions:");
			}

			for (int i = 0; i < count; i++)
			{
				final String extensionName = instanceExtensions.get(i).extensionNameString();
				extensions.add(extensionName);

				if (debug)
				{
					System.out.println("\t" + extensionName);
				}
			}
		}

		return extensions;
	}

	private static List<EDeviceExtension> gatherDeviceExtensions()
	{
		final List<EDeviceExtension> requiredExtensions = new ArrayList<>();

		requiredExtensions.add(EDeviceExtension.VK_KHR_swapchain);

		return requiredExtensions;
	}

	private List<EInstanceExtension> gatherInstanceExtensions(boolean debug)
	{
		final List<EInstanceExtension> requiredExtensions = new ArrayList<>();

		if (debug)
		{
			requiredExtensions.add(EInstanceExtension.VK_EXT_debug_report);
		}

		for (final Iterator<EInstanceExtension> iterator = requiredExtensions.iterator(); iterator
				.hasNext();)
		{
			final EInstanceExtension extension = iterator.next();

			if (availableInstanceExtensions.contains(extension.name) == false)
			{
				iterator.remove();
				System.err.println("Unsupported extension:" + extension.name);
			}
		}

		return requiredExtensions;
	}

	public List<EDeviceExtension> getRequiredDeviceExtensions()
	{
		return requiredDeviceExtensions;
	}

	public List<EInstanceExtension> getRequiredInstanceExtensions()
	{
		return requiredInstanceExtensions;
	}
}
