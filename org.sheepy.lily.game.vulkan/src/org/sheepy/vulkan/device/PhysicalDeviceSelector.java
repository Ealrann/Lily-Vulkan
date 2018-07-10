package org.sheepy.vulkan.device;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;
import static org.lwjgl.vulkan.VK10.vkEnumeratePhysicalDevices;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.util.VulkanUtils;

public class PhysicalDeviceSelector
{
	private static final Comparator<PhysicalDeviceWrapper> DEVICE_COMPARATOR = new Comparator<PhysicalDeviceWrapper>()
	{
		@Override
		public int compare(PhysicalDeviceWrapper o1, PhysicalDeviceWrapper o2)
		{
			return Integer.compare(o1.getRate(), o2.getRate());
		}
	};

	private VkInstance vkInstance;
	private List<PhysicalDeviceWrapper> devices = new ArrayList<>();
	private String[] requiredExtensions;
	private long desiredSurface;

	public PhysicalDeviceSelector(VkInstance vkInstance, String[] requiredExtensions,
			long desiredSurface)
	{
		this.vkInstance = vkInstance;
		this.requiredExtensions = requiredExtensions;
		this.desiredSurface = desiredSurface;
		this.desiredSurface = desiredSurface;

		load();
	}

	private void load()
	{
		IntBuffer pPhysicalDeviceCount = memAllocInt(1);
		int err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, null);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get number of physical devices: "
					+ VulkanUtils.translateVulkanResult(err));
		}
		PointerBuffer pPhysicalDevices = memAllocPointer(pPhysicalDeviceCount.get(0));
		err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, pPhysicalDevices);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to get physical devices: " + VulkanUtils.translateVulkanResult(err));
		}
		for (int i = 0; i < pPhysicalDeviceCount.get(0); i++)
		{
			VkPhysicalDevice device = new VkPhysicalDevice(pPhysicalDevices.get(i), vkInstance);
			devices.add(new PhysicalDeviceWrapper(device, vkInstance, desiredSurface,
					requiredExtensions));
		}
		Collections.sort(devices, DEVICE_COMPARATOR);
		memFree(pPhysicalDeviceCount);
		memFree(pPhysicalDevices);
	}

	public PhysicalDeviceWrapper getBestPhysicalDevice()
	{
		return devices.get(0);
	}

}
