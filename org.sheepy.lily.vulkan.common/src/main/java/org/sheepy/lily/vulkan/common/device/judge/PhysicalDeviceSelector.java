package org.sheepy.lily.vulkan.common.device.judge;

import static org.lwjgl.vulkan.VK10.vkEnumeratePhysicalDevices;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.VulkanInstance;
import org.sheepy.lily.vulkan.common.engine.EngineExtensionRequirement;

public class PhysicalDeviceSelector
{
	private static final Comparator<PhysicalDeviceWrapper> DEVICE_COMPARATOR = new Comparator<>()
	{
		@Override
		public int compare(PhysicalDeviceWrapper o1, PhysicalDeviceWrapper o2)
		{
			return Integer.compare(o1.score, o2.score);
		}
	};

	private final VulkanInstance vkInstance;
	private final List<PhysicalDeviceWrapper> devices = new ArrayList<>();
	private final EngineExtensionRequirement extensionRequirement;
	private final VkSurface surface;
	private final boolean debug;

	private IntBuffer pPhysicalDeviceCount;

	private PointerBuffer pPhysicalDevices;

	public PhysicalDeviceSelector(	VulkanInstance vkInstance,
									EngineExtensionRequirement extensionRequirement,
									VkSurface surface,
									boolean debug)
	{
		this.vkInstance = vkInstance;
		this.extensionRequirement = extensionRequirement;
		this.surface = surface;
		this.debug = debug;
	}

	public PhysicalDevice findBestPhysicalDevice(MemoryStack stack)
	{
		load(stack);
		gatherDevices();
		Collections.sort(devices, DEVICE_COMPARATOR);

		final PhysicalDevice res = devices.get(0).physicalDevice;
		res.allocate(stack);

		return res;
	}

	private void load(MemoryStack stack) throws AssertionError
	{
		var vulkanInstance = vkInstance.getVkInstance();
		pPhysicalDeviceCount = stack.mallocInt(1);
		int err = vkEnumeratePhysicalDevices(vulkanInstance, pPhysicalDeviceCount, null);
		Logger.check(err, "Failed to get count of physical devices");

		pPhysicalDevices = stack.mallocPointer(pPhysicalDeviceCount.get(0));
		err = vkEnumeratePhysicalDevices(vulkanInstance, pPhysicalDeviceCount, pPhysicalDevices);
		Logger.check(err, "Failed to get physical devices");
	}

	private void gatherDevices()
	{
		final PhysicalDeviceJudge judge = new PhysicalDeviceJudge();
		var vulkanInstance = vkInstance.getVkInstance();
		for (int i = 0; i < pPhysicalDeviceCount.get(0); i++)
		{
			final var vkPhysicalDevice = new VkPhysicalDevice(pPhysicalDevices.get(i),
					vulkanInstance);
			final var physicalDevice = new PhysicalDevice(vkPhysicalDevice, vkInstance,
					extensionRequirement);

			final int deviceScore = judge.rateDeviceSuitability(physicalDevice, surface);

			if (debug)
			{
				System.out.println(String.format("[%s (%d)]: %d points", physicalDevice.getName(),
						physicalDevice.getDriverVersion(), deviceScore));
				physicalDevice.printAvailableExtensions();
			}

			devices.add(new PhysicalDeviceWrapper(physicalDevice, deviceScore));
		}
	}

	public class PhysicalDeviceWrapper
	{
		public final PhysicalDevice physicalDevice;
		public final int score;

		PhysicalDeviceWrapper(PhysicalDevice physicalDevice, int score)
		{
			this.physicalDevice = physicalDevice;
			this.score = score;
		}
	}
}
