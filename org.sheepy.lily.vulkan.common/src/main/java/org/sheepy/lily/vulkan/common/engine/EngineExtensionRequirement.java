package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceExtensionProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.device.EDeviceExtension;
import org.sheepy.lily.vulkan.common.device.EInstanceExtension;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public class EngineExtensionRequirement
{
	private final VulkanEngine engine;
	private final boolean vsync;

	private final List<EInstanceExtension> requiredInstanceExtensions;
	private final List<String> availableInstanceExtensions;

	private final List<EDeviceExtension> requiredDeviceExtensions;

	public EngineExtensionRequirement(VulkanEngine engine, MemoryStack stack, boolean debug)
	{
		this.engine = engine;

		vsync = isVSyncRequired();

		requiredDeviceExtensions = List.copyOf(gatherDeviceExtensions());

		availableInstanceExtensions = List.copyOf(gatherAvailableInstanceExtensions(stack, debug));
		requiredInstanceExtensions = List.copyOf(gatherInstanceExtensions(debug));
	}

	private boolean isVSyncRequired()
	{
		for (IProcess process : engine.getProcesses())
		{
			if (process instanceof GraphicProcess)
			{
				var graphicProcess = (GraphicProcess) process;
				var configuration = graphicProcess.getConfiguration();
				if (configuration != null)
				{
					return configuration.isVSyncEnabled();
				}
			}
		}
		return false;
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

			for (EInstanceExtension extension : requiredInstanceExtensions)
			{
				res.put(stack.UTF8Safe(extension.name));
			}

			res.flip();
		}

		return res;
	}

	public static List<String> gatherAvailableInstanceExtensions(MemoryStack stack, boolean debug)
	{
		List<String> extensions = new ArrayList<>();

		final int[] ip = new int[1];
		vkEnumerateInstanceExtensionProperties((String) null, ip, null);
		final int count = ip[0];

		if (count != 0)
		{
			final var instanceExtensions = VkExtensionProperties.mallocStack(count, stack);
			vkEnumerateInstanceExtensionProperties((String) null, ip, instanceExtensions);

			if (debug)
			{
				System.out.println("System Extensions:");
			}

			for (int i = 0; i < count; i++)
			{
				String extensionName = instanceExtensions.get(i).extensionNameString();
				extensions.add(extensionName);

				if (debug)
				{
					System.out.println("\t" + extensionName);
				}
			}
		}

		return extensions;
	}

	private List<EDeviceExtension> gatherDeviceExtensions()
	{
		List<EDeviceExtension> requiredExtensions = new ArrayList<>();

		requiredExtensions.add(EDeviceExtension.VK_KHR_swapchain);

		if (vsync)
		{
			requiredExtensions.add(EDeviceExtension.VK_EXT_display_control);
		}

		return requiredExtensions;
	}

	private List<EInstanceExtension> gatherInstanceExtensions(boolean debug)
	{
		List<EInstanceExtension> requiredExtensions = new ArrayList<>();

		if (debug)
		{
			requiredExtensions.add(EInstanceExtension.VK_EXT_debug_report);
		}

		if (vsync)
		{
			requiredExtensions.add(EInstanceExtension.VK_KHR_display);
			requiredExtensions.add(EInstanceExtension.VK_EXT_display_surface_counter);
		}

		for (Iterator<EInstanceExtension> iterator = requiredExtensions.iterator(); iterator
				.hasNext();)
		{
			EInstanceExtension extension = iterator.next();

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
