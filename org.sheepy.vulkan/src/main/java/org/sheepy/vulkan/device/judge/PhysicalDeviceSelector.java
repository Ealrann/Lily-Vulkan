package org.sheepy.vulkan.device.judge;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.window.Surface;

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

	private final VkInstance vkInstance;
	private final List<PhysicalDeviceWrapper> devices = new ArrayList<>();
	private final String[] requiredExtensions;
	private final Surface surface;

	private IntBuffer pPhysicalDeviceCount;

	private PointerBuffer pPhysicalDevices;

	public PhysicalDeviceSelector(	VkInstance vkInstance,
									String[] requiredExtensions,
									Surface surface)
	{
		this.vkInstance = vkInstance;
		this.requiredExtensions = requiredExtensions;
		this.surface = surface;
	}

	public PhysicalDevice findBestPhysicalDevice(MemoryStack stack)
	{
		load(stack);
		gatherDevices(stack);
		Collections.sort(devices, DEVICE_COMPARATOR);

		final PhysicalDevice res = devices.get(0).physicalDevice;
		res.allocate(stack);

		return res;
	}

	private void load(MemoryStack stack) throws AssertionError
	{
		pPhysicalDeviceCount = stack.mallocInt(1);
		int err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, null);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get number of physical devices: "
					+ VulkanUtils.translateVulkanResult(err));
		}
		pPhysicalDevices = stack.mallocPointer(pPhysicalDeviceCount.get(0));
		err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, pPhysicalDevices);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to get physical devices: " + VulkanUtils.translateVulkanResult(err));
		}
	}

	private void gatherDevices(MemoryStack stack)
	{
		final PhysicalDeviceJudge judge = new PhysicalDeviceJudge(stack, requiredExtensions);
		for (int i = 0; i < pPhysicalDeviceCount.get(0); i++)
		{
			final var vkPhysicalDevice = new VkPhysicalDevice(pPhysicalDevices.get(i), vkInstance);
			final var physicalDevice = new PhysicalDevice(vkPhysicalDevice, vkInstance);

			final int deviceScore = judge.rateDeviceSuitability(physicalDevice, surface);
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
