package org.sheepy.vulkan.common.device;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.util.HashSet;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkDeviceCreateInfo;
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.vulkan.common.device.data.Capabilities;
import org.sheepy.vulkan.common.device.data.ColorDomains;
import org.sheepy.vulkan.common.queue.QueueManager;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.common.window.Surface;
import org.sheepy.vulkan.common.window.Window;
import org.sheepy.vulkan.model.ColorDomain;
import org.sheepy.vulkan.model.enumeration.EFormat;

public class LogicalDevice
{
	public final PhysicalDevice physicalDevice;
	public final Window window;
	public final QueueManager queueManager;

	private final boolean needComputeCapability;

	private VkDevice vkDevice;

	public final static LogicalDevice alloc(MemoryStack stack,
											PhysicalDevice physicalDevice,
											Window window,
											String[] requiredExtensions,
											PointerBuffer ppEnabledLayerNames)
	{
		return alloc(stack, physicalDevice, window, requiredExtensions, ppEnabledLayerNames, false);
	}

	public final static LogicalDevice alloc(MemoryStack stack,
											PhysicalDevice physicalDevice,
											Window window,
											String[] requiredExtensions,
											PointerBuffer ppEnabledLayerNames,
											boolean needComputeCapability)
	{
		final LogicalDevice res = new LogicalDevice(physicalDevice, window, needComputeCapability);

		res.load(stack, requiredExtensions, ppEnabledLayerNames);
		return res;
	}

	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private LogicalDevice(	PhysicalDevice physicalDevice,
							Window window,
							boolean needComputeCapability)
	{
		this.physicalDevice = physicalDevice;
		this.needComputeCapability = needComputeCapability;
		this.window = window;

		queueManager = new QueueManager();
		queueManager.load(physicalDevice.vkPhysicalDevice, window.getSurface(),
				needComputeCapability);
	}

	public void load(	MemoryStack stack,
						String[] requiredExtensions,
						PointerBuffer ppEnabledLayerNames)
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
		}
		queueCreateInfos.flip();

		// Logical Device
		final PointerBuffer extensionsBuffer = stack.callocPointer(requiredExtensions.length);
		for (final String requiredExtension : requiredExtensions)
		{
			extensionsBuffer.put(stack.UTF8(requiredExtension));
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
		createInfo.ppEnabledLayerNames(ppEnabledLayerNames);
		final PointerBuffer pDevice = stack.callocPointer(1);

		Logger.check("Failed to create logical device",
				() -> vkCreateDevice(physicalDevice.vkPhysicalDevice, createInfo, null, pDevice));

		final long deviceId = pDevice.get(0);
		vkDevice = new VkDevice(deviceId, physicalDevice.vkPhysicalDevice, createInfo);

		queueManager.loadVkQueues(vkDevice);

		final Surface surface = window.getSurface();
		capabilities = new Capabilities(physicalDevice.vkPhysicalDevice, surface);
		colorDomains = new ColorDomains(stack, physicalDevice.vkPhysicalDevice, surface);
	}

	public void recreateQueues(Surface surface)
	{
		waitIdle();

		queueManager.load(physicalDevice.vkPhysicalDevice, surface, needComputeCapability);
		queueManager.loadVkQueues(vkDevice);

		capabilities.free();

		capabilities = new Capabilities(physicalDevice.vkPhysicalDevice, surface);
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			colorDomains = new ColorDomains(stack, physicalDevice.vkPhysicalDevice, surface);
		}
	}

	public void free()
	{
		capabilities.free();
		vkDestroyDevice(vkDevice, null);
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

	public VkSurfaceCapabilitiesKHR getCapabilities()
	{
		return capabilities.vkCapabilities;
	}

	public boolean isColorDomainAvaillable(ColorDomain colorDomain)
	{
		// Best case : the graphic card has no preferences
		if (colorDomains.size() == 1 && colorDomains.get(0).getFormat() == EFormat.UNDEFINED)
		{
			return true;
		}
		else if (colorDomains.contains(colorDomain))
		{
			return true;
		}

		return false;
	}
}
