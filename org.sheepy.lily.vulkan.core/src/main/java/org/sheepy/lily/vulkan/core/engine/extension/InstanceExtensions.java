package org.sheepy.lily.vulkan.core.engine.extension;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.sheepy.lily.vulkan.core.window.Window;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceExtensionProperties;

public final class InstanceExtensions
{
	public final List<String> extensions;

	public InstanceExtensions(List<String> extensions)
	{
		this.extensions = List.copyOf(extensions);
	}

	public PointerBuffer allocBuffer(MemoryStack stack)
	{
		final var res = stack.mallocPointer(extensions.size());
		for (int i = 0; i < extensions.size(); i++)
		{
			final var name = extensions.get(i);
			final var strBuffer = stack.UTF8Safe(name);
			if (strBuffer != null) res.put(strBuffer);
			else res.get();
		}
		res.flip();
		return res;
	}

	public boolean supportDebug()
	{
		return extensions.contains(EInstanceExtension.VK_EXT_debug_report.name);
	}

	public static final class Builder
	{
		private final List<String> requiredExtensions = new ArrayList<>();
		private final List<String> availableExtensions;

		public Builder(MemoryStack stack)
		{
			availableExtensions = gatherAvailableInstanceExtensions(stack);
		}

		public Builder requiresWindow()
		{
			final var glfwRequiredExtensions = Window.getRequiredInstanceExtensions();
			if (glfwRequiredExtensions != null)
			{
				for (int i = 0; i < glfwRequiredExtensions.capacity(); i++)
				{
					final long extNamePtr = glfwRequiredExtensions.get(i);
					final String name = MemoryUtil.memUTF8(extNamePtr);

					if (availableExtensions.contains(name) == false)
					{
						throw new IllegalArgumentException("The extension " + name + " (required by GLFW) is not " + "available.");
					}

					requiredExtensions.add(name);
				}
			}
			return this;
		}

		public Builder requires(String extension)
		{
			if (availableExtensions.contains(extension) == false)
			{
				throw new IllegalArgumentException("The extension " + extension + " is not available.");
			}
			requiredExtensions.add(extension);
			return this;
		}

		public void log(final boolean verbose)
		{
			System.out.println("\nRetained Instance Extensions:");
			for (final var extension : requiredExtensions)
			{
				System.out.println("\t- " + extension);
			}
			if (verbose)
			{
				System.out.println("Available Instance Extensions:");
				for (final var extension : availableExtensions)
				{
					System.out.println("\t- " + extension);
				}
			}
		}

		public InstanceExtensions build()
		{
			return new InstanceExtensions(requiredExtensions);
		}

		private static List<String> gatherAvailableInstanceExtensions(MemoryStack stack)
		{
			final List<String> extensions = new ArrayList<>();

			final int[] ip = new int[1];
			vkEnumerateInstanceExtensionProperties((String) null, ip, null);
			final int count = ip[0];

			if (count != 0)
			{
				final var instanceExtensions = VkExtensionProperties.malloc(count, stack);
				vkEnumerateInstanceExtensionProperties((String) null, ip, instanceExtensions);

				for (int i = 0; i < count; i++)
				{
					final String extensionName = instanceExtensions.get(i).extensionNameString();
					extensions.add(extensionName);
				}
			}

			return extensions;
		}
	}
}
