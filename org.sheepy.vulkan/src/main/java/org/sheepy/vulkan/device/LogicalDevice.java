package org.sheepy.vulkan.device;

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
import org.sheepy.vulkan.extension.EDeviceExtension;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.QueueManager;
import org.sheepy.vulkan.queue.VulkanQueue;
import org.sheepy.vulkan.surface.VkSurface;

public class LogicalDevice
{
	public final PhysicalDevice physicalDevice;
	public final VkSurface dummySurface;

	private final List<EPhysicalFeature> features;
	private final QueueManager queueManager;

	private VkDevice vkDevice;

	public LogicalDevice(	PhysicalDevice physicalDevice,
							VkSurface dummySurface,
							List<EPhysicalFeature> features,
							boolean needComputeCapability)
	{
		this.physicalDevice = physicalDevice;
		this.dummySurface = dummySurface;
		this.features = List.copyOf(features);

		queueManager = new QueueManager(physicalDevice.vkPhysicalDevice, needComputeCapability);
		queueManager.load(dummySurface);
	}

	public void allocate(MemoryStack stack)
	{
		final var uniqueQueueIndexes = new HashSet<>(queueManager.getQueueIndexes());
		final var size = uniqueQueueIndexes.size();
		final var queueCreateInfos = VkDeviceQueueCreateInfo.callocStack(size, stack);

		for (final int queueIndex : uniqueQueueIndexes)
		{
			final var queuePriority = stack.mallocFloat(1).put(1f);
			queuePriority.flip();

			final var queueCreateInfo = queueCreateInfos.get();
			queueCreateInfo.sType(VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO);
			queueCreateInfo.queueFamilyIndex(queueIndex);
			queueCreateInfo.pQueuePriorities(queuePriority);
			queueCreateInfo.pNext(VK_NULL_HANDLE);
		}
		queueCreateInfos.flip();

		final List<EDeviceExtension> extensions = physicalDevice.getRetainedExtensions();

		// Logical Device
		final PointerBuffer extensionsBuffer = stack.callocPointer(extensions.size());
		for (final EDeviceExtension requiredExtension : extensions)
		{
			extensionsBuffer.put(stack.UTF8(requiredExtension.name));
		}
		extensionsBuffer.flip();

		final VkPhysicalDeviceFeatures deviceFeatures = allocPhysicalFeatures(stack);

		final VkDeviceCreateInfo createInfo = VkDeviceCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO);
		createInfo.pNext(VK_NULL_HANDLE);
		createInfo.pQueueCreateInfos(queueCreateInfos);
		createInfo.pEnabledFeatures(deviceFeatures);
		createInfo.ppEnabledExtensionNames(extensionsBuffer);
		final PointerBuffer pDevice = stack.callocPointer(1);

		Logger.check("Failed to create logical device",
				() -> vkCreateDevice(physicalDevice.vkPhysicalDevice, createInfo, null, pDevice));

		final long deviceId = pDevice.get(0);
		vkDevice = new VkDevice(deviceId, physicalDevice.vkPhysicalDevice, createInfo);
	}

	private VkPhysicalDeviceFeatures allocPhysicalFeatures(MemoryStack stack)
	{
		final VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.callocStack(stack);
		deviceFeatures.samplerAnisotropy(true);

		final boolean fillModeNonSolid = features.contains(EPhysicalFeature.FILL_MODE_NON_SOLID);
		final var fragmentStoresAndAtomics = features
				.contains(EPhysicalFeature.FRAGMENT_STORES_AND_ATOMICS);
		final boolean wideLines = features.contains(EPhysicalFeature.WIDE_LINES);
		final boolean geometryShader = features.contains(EPhysicalFeature.GEOMETRY_SHADER);

		deviceFeatures.geometryShader(geometryShader);
		deviceFeatures.fillModeNonSolid(fillModeNonSolid);
		deviceFeatures.fragmentStoresAndAtomics(fragmentStoresAndAtomics);
		deviceFeatures.wideLines(wideLines);

		return deviceFeatures;
	}

	public void free()
	{
		vkDestroyDevice(vkDevice, null);
		vkDevice = null;
	}

	public void waitIdle()
	{
		final int res = vkDeviceWaitIdle(vkDevice);
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

	public PhysicalDevice getPhysicalDevice()
	{
		return physicalDevice;
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
		return queueManager.createPresentQueue(vkDevice, surface);
	}

	public boolean isQueueExclusive()
	{
		return queueManager.isExclusive();
	}

	public IntBuffer allocQueueIndices()
	{
		return queueManager.allocIndices();
	}

	public int getQueueIndex(EQueueType queueType)
	{
		return queueManager.getQueueIndex(queueType);
	}
}
