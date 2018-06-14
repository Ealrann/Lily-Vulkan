package org.sheepy.lily.game.vulkan.device;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryUtil.memAllocFloat;
import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.FloatBuffer;
import java.util.HashSet;
import java.util.Set;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkDeviceCreateInfo;
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.pipeline.swap.SwapPipeline;
import org.sheepy.lily.game.vulkan.queue.QueueManager;

public class LogicalDevice
{
	private PhysicalDeviceWrapper physicalDevice;
	private QueueManager queueManager;
	private boolean needComputeCapability;

	private VkDevice vkDevice;
	private CommandPool commandPool;

	private SwapPipeline swapPipeline;

	public final static LogicalDevice alloc(MemoryStack stack,
			PhysicalDeviceWrapper physicalDevice,
			long surface,
			String[] requiredExtensions,
			PointerBuffer ppEnabledLayerNames)
	{
		return alloc(stack, physicalDevice, surface, requiredExtensions, ppEnabledLayerNames,
				false);
	}

	public final static LogicalDevice alloc(MemoryStack stack,
			PhysicalDeviceWrapper physicalDevice,
			long surface,
			String[] requiredExtensions,
			PointerBuffer ppEnabledLayerNames,
			boolean needComputeCapability)
	{
		LogicalDevice res = new LogicalDevice(physicalDevice, surface, needComputeCapability);

		res.load(stack, requiredExtensions, ppEnabledLayerNames);
		return res;
	}

	private LogicalDevice(PhysicalDeviceWrapper physicalDevice, long surface,
			boolean needComputeCapability)
	{
		this.physicalDevice = physicalDevice;
		this.needComputeCapability = needComputeCapability;

		queueManager = new QueueManager();
		queueManager.load(physicalDevice.getVkPhysicalDevice(), surface, needComputeCapability);
	}

	public void load(MemoryStack stack,
			String[] requiredExtensions,
			PointerBuffer ppEnabledLayerNames)
	{
		Set<Integer> uniqueQueueIndexes = new HashSet<Integer>(queueManager.getQueueIndexes());
		VkDeviceQueueCreateInfo.Buffer queueCreateInfos = VkDeviceQueueCreateInfo
				.callocStack(uniqueQueueIndexes.size(), stack);

		for (int queueIndex : uniqueQueueIndexes)
		{
			VkDeviceQueueCreateInfo queueCreateInfo = queueCreateInfos.get();
			
			FloatBuffer queuePriority = memAllocFloat(1).put(1f);
			queuePriority.flip();
			queueCreateInfo.sType(VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO);
			queueCreateInfo.queueFamilyIndex(queueIndex);
			queueCreateInfo.pQueuePriorities(queuePriority);
		}
		queueCreateInfos.flip();

		// Logical Device
		PointerBuffer extensionsBuffer = stack.callocPointer(requiredExtensions.length);
		for (String requiredExtension : requiredExtensions)
		{
			extensionsBuffer.put(stack.UTF8(requiredExtension));
		}
		extensionsBuffer.flip();
		VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.callocStack(stack);
		deviceFeatures.samplerAnisotropy(true);

		VkDeviceCreateInfo createInfo = VkDeviceCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO);
		createInfo.pNext(NULL);
		createInfo.pQueueCreateInfos(queueCreateInfos);
		createInfo.pEnabledFeatures(deviceFeatures);
		createInfo.ppEnabledExtensionNames(extensionsBuffer);
		createInfo.ppEnabledLayerNames(ppEnabledLayerNames);
		PointerBuffer pDevice = stack.callocPointer(1);
		if (vkCreateDevice(physicalDevice.getVkPhysicalDevice(), createInfo, null,
				pDevice) != VK_SUCCESS)
		{
			System.err.println("failed to create logical device!");
		}
		long deviceId = pDevice.get(0);
		vkDevice = new VkDevice(deviceId, physicalDevice.getVkPhysicalDevice(), createInfo);

		queueManager.loadVkQueues(vkDevice);

		commandPool = CommandPool.alloc(stack, this, queueManager.getGraphicQueueIndex());
	}

	public void attachSwapPipeline(SwapPipeline swapPipeline)
	{
		this.swapPipeline = swapPipeline;
	}

	public void recreateSwapChain(long surface, int width, int height)
	{
		waitIdle();

		queueManager.load(physicalDevice.getVkPhysicalDevice(), surface, needComputeCapability);
		queueManager.loadVkQueues(vkDevice);

		swapPipeline.destroy(false);
		swapPipeline.load(surface, width, height);
	}

	public VkDevice getVkDevice()
	{
		return vkDevice;
	}

	public QueueManager getQueueManager()
	{
		return queueManager;
	}

	public void free()
	{
		swapPipeline.destroy(true);
		commandPool.free();

		vkDestroyDevice(vkDevice, null);
	}

	public PhysicalDeviceWrapper getPhysicalDevice()
	{
		return physicalDevice;
	}

	public int waitIdle()
	{
		return vkDeviceWaitIdle(vkDevice);
	}

	public void draw()
	{
		if (swapPipeline != null)
		{
			int imageIndex = swapPipeline.acquireNextImage();

			if (vkQueueSubmit(queueManager.getGraphicQueue(),
					swapPipeline.getFrameSubmission().getSubmitInfo(imageIndex),
					VK_NULL_HANDLE) != VK_SUCCESS)
			{
				throw new AssertionError("failed to submit draw command buffer!");
			}

			vkQueuePresentKHR(queueManager.getGraphicQueue(),
					swapPipeline.getFrameSubmission().getPresentInfo(imageIndex));
		}
	}

	public CommandPool getCommandPool()
	{
		return commandPool;
	}

	public SwapPipeline getSwapPipeline()
	{
		return swapPipeline;
	}
}
