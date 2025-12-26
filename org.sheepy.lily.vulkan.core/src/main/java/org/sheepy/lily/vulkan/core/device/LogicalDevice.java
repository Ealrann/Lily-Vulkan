package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkDeviceCreateInfo;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.vulkan.api.device.EPhysicalFeature;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.execution.queue.QueueManager;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class LogicalDevice implements ILogicalDevice
{
	private static final String FAILED_TO_CREATE_LOGICAL_DEVICE = "Failed to create logical device";
	private static final String WAIT_IDLE_FAILED = "Wait idle failed";
	public final PhysicalDevice physicalDevice;

	private final List<EPhysicalFeature> features;
	private final QueueManager queueManager;

	private VkDevice vkDevice;

	public LogicalDevice(PhysicalDevice physicalDevice, QueueManager queueManager, List<EPhysicalFeature> features)
	{
		this.physicalDevice = physicalDevice;
		this.features = List.copyOf(features);
		this.queueManager = queueManager;
	}

	public void allocate(MemoryStack stack)
	{
		final var queueCreateInfos = queueManager.allocQueueInfos(stack);
		final var extensionsBuffer = physicalDevice.deviceExtensions.callocBuffer();
		final var deviceFeatures = allocPhysicalFeatures(stack);
		final var createInfo = VkDeviceCreateInfo.malloc(stack)
												 .set(VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO,
													  VK_NULL_HANDLE,
													  0,
													  queueCreateInfos,
													  null,
													  extensionsBuffer,
													  deviceFeatures);

		final var pDevice = stack.callocPointer(1);
		Logger.check(FAILED_TO_CREATE_LOGICAL_DEVICE,
					 () -> vkCreateDevice(physicalDevice.vkPhysicalDevice, createInfo, null, pDevice));

		final long deviceId = pDevice.get(0);
		vkDevice = new VkDevice(deviceId, physicalDevice.vkPhysicalDevice, createInfo);

		extensionsBuffer.free();

		queueManager.allocate(stack, vkDevice);
	}

	private VkPhysicalDeviceFeatures allocPhysicalFeatures(MemoryStack stack)
	{
		final var deviceFeatures = VkPhysicalDeviceFeatures.calloc(stack);
		deviceFeatures.samplerAnisotropy(true);

		final boolean fillModeNonSolid = features.contains(EPhysicalFeature.FILL_MODE_NON_SOLID);
		final var fragmentStoresAndAtomics = features.contains(EPhysicalFeature.FRAGMENT_STORES_AND_ATOMICS);
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
		queueManager.free();
		vkDestroyDevice(vkDevice, null);
		vkDevice = null;
	}

	@Override
	public void waitIdle()
	{
		final int res = vkDeviceWaitIdle(vkDevice);
		Logger.check(res, WAIT_IDLE_FAILED);
	}

	public VkDevice getVkDevice()
	{
		return vkDevice;
	}

	public VulkanQueue borrowGraphicQueue()
	{
		return queueManager.borrowGraphicQueue();
	}

	public VulkanQueue borrowComputeQueue()
	{
		return queueManager.borrowComputeQueue();
	}

	public VulkanQueue borrowPresentQueue(VkSurface surface)
	{
		return queueManager.borrowPresentQueue(surface);
	}

	public void returnQueue(VulkanQueue queue)
	{
		queueManager.returnQueue(queue);
	}

	public boolean isQueueExclusive()
	{
		return queueManager.isExclusive();
	}

	public int getQueueFamilyIndex(EQueueType queueType)
	{
		return queueManager.getQueueFamilyIndex(queueType);
	}
}
