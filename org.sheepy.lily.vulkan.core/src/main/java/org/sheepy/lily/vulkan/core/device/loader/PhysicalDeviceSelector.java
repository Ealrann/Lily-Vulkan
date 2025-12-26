package org.sheepy.lily.vulkan.core.device.loader;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.engine.extension.EDeviceExtension;
import org.sheepy.lily.vulkan.core.instance.VulkanInstance;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;

import java.nio.IntBuffer;
import java.util.*;

import static org.lwjgl.vulkan.VK10.vkEnumeratePhysicalDevices;

public class PhysicalDeviceSelector
{
	private final VulkanInstance vulkanInstance;
	private final Set<EDeviceExtension> requiredDeviceExtensions;
	private final VkSurface surface;

	private IntBuffer pPhysicalDeviceCount;

	private PointerBuffer pPhysicalDevices;

	public PhysicalDeviceSelector(VulkanInstance vulkanInstance,
								  Set<EDeviceExtension> requiredDeviceExtensions,
								  VkSurface surface)
	{
		this.vulkanInstance = vulkanInstance;
		this.requiredDeviceExtensions = requiredDeviceExtensions;
		this.surface = surface;
	}

	public PhysicalDevice findBestPhysicalDevice(MemoryStack stack)
	{
		load(stack);
		final var bestDevice = gatherDevices(stack).stream()
												   .max(Comparator.comparing(DeviceScore::score))
												   .orElseThrow(NoSuchElementException::new);
		final var winner = bestDevice.deviceBuilder;
		if (DebugUtil.DEBUG_ENABLED) winner.printInfo(DebugUtil.DEBUG_VERBOSE_ENABLED);
		return winner.build(surface);
	}

	private void load(MemoryStack stack) throws AssertionError
	{
		final var vkInstance = vulkanInstance.getVkInstance();
		pPhysicalDeviceCount = stack.mallocInt(1);
		int err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, null);
		Logger.check(err, "Failed to get count of physical devices");

		pPhysicalDevices = stack.mallocPointer(pPhysicalDeviceCount.get(0));
		err = vkEnumeratePhysicalDevices(vkInstance, pPhysicalDeviceCount, pPhysicalDevices);
		Logger.check(err, "Failed to get physical devices");
	}

	private List<DeviceScore> gatherDevices(MemoryStack stack)
	{
		final List<DeviceScore> res = new ArrayList<>();
		final var vkInstance = vulkanInstance.getVkInstance();
		final var judge = new PhysicalDeviceJudge(surface);

		for (int i = 0; i < pPhysicalDeviceCount.get(0); i++)
		{
			final var vkPhysicalDevice = new VkPhysicalDevice(pPhysicalDevices.get(i), vkInstance);
			final var deviceBuilder = new PhysicalDevice.Builder(vkPhysicalDevice, requiredDeviceExtensions, stack);
			final int deviceScore = judge.rateDeviceSuitability(deviceBuilder);
			if (DebugUtil.DEBUG_ENABLED)
			{
				System.out.printf("[%s (%d)]: %d points", deviceBuilder.name, deviceBuilder.driverVersion, deviceScore);
			}

			res.add(new DeviceScore(deviceBuilder, deviceScore));
		}

		return res;
	}

	private record DeviceScore(PhysicalDevice.Builder deviceBuilder, int score)
	{
	}
}
