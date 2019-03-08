package org.sheepy.lily.vulkan.common.device;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkDeviceCreateInfo;
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.queue.QueueManager;

public class LogicalDevice
{
	public final PhysicalDevice physicalDevice;
	public final VkSurface dummySurface;

	private final QueueManager queueManager;

	private VkDevice vkDevice;
	private VulkanQueue previousPresentQueue;

	public final static LogicalDevice alloc(MemoryStack stack,
											PhysicalDevice physicalDevice,
											VkSurface dummySurface,
											boolean needComputeCapability)
	{
		final LogicalDevice res = new LogicalDevice(physicalDevice, dummySurface,
				needComputeCapability);

		res.load(stack);
		return res;
	}

	private LogicalDevice(	PhysicalDevice physicalDevice,
							VkSurface dummySurface,
							boolean needComputeCapability)
	{
		this.physicalDevice = physicalDevice;
		this.dummySurface = dummySurface;

		queueManager = new QueueManager(physicalDevice.vkPhysicalDevice, needComputeCapability);
		queueManager.load(dummySurface);
	}

	public void load(MemoryStack stack)
	{
		final var uniqueQueueIndexes = new HashSet<>(queueManager.getQueueIndexes());
		final var size = uniqueQueueIndexes.size();
		final var queueCreateInfos = VkDeviceQueueCreateInfo.callocStack(size, stack);

		for (final int queueIndex : uniqueQueueIndexes)
		{
			final var queuePriority = memAllocFloat(1).put(1f);
			queuePriority.flip();

			final var queueCreateInfo = queueCreateInfos.get();
			queueCreateInfo.sType(VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO);
			queueCreateInfo.queueFamilyIndex(queueIndex);
			queueCreateInfo.pQueuePriorities(queuePriority);
			queueCreateInfo.pNext(NULL);

			memFree(queuePriority);
		}
		queueCreateInfos.flip();

		List<EDeviceExtension> extensions = physicalDevice.getRetainedExtensions();

		// Logical Device
		final PointerBuffer extensionsBuffer = stack.callocPointer(extensions.size());
		for (final EDeviceExtension requiredExtension : extensions)
		{
			extensionsBuffer.put(stack.UTF8(requiredExtension.name));
		}
		extensionsBuffer.flip();
		final VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.callocStack(stack);
		deviceFeatures.samplerAnisotropy(true);

		final VkDeviceCreateInfo createInfo = VkDeviceCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO);
		createInfo.pNext(NULL);
		createInfo.pQueueCreateInfos(queueCreateInfos);
		createInfo.pEnabledFeatures(deviceFeatures);
		createInfo.ppEnabledExtensionNames(extensionsBuffer);
		final PointerBuffer pDevice = stack.callocPointer(1);

		Logger.check("Failed to create logical device",
				() -> vkCreateDevice(physicalDevice.vkPhysicalDevice, createInfo, null, pDevice));

		final long deviceId = pDevice.get(0);
		vkDevice = new VkDevice(deviceId, physicalDevice.vkPhysicalDevice, createInfo);
	}

	public void free()
	{
		vkDestroyDevice(vkDevice, null);
		vkDevice = null;
	}

	public void waitIdle()
	{
		int res = vkDeviceWaitIdle(vkDevice);
		Logger.check(res, "Wait idle failed");
	}

	public VkDevice getVkDevice()
	{
		return vkDevice;
	}

	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return physicalDevice.vkPhysicalDevice;
	}

	public VulkanQueue createGraphicQueue()
	{
		return queueManager.createGraphicQueue(vkDevice);
	}

	public VulkanQueue createComputeQueue()
	{
		return queueManager.createComputeQueue(vkDevice);
	}

	public VulkanQueue createPresentQueue(VkSurface surface)
	{
		if (previousPresentQueue != null)
		{
			previousPresentQueue.waitIdle();
		}

		VulkanQueue presentQueue = queueManager.createPresentQueue(vkDevice, surface);
		previousPresentQueue = presentQueue;
		return presentQueue;
	}

	public boolean isQueueExclusive()
	{
		return queueManager.isExclusive();
	}

	public IntBuffer allocQueueIndices()
	{
		return queueManager.allocIndices();
	}
}
