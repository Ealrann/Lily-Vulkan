package org.sheepy.lily.game.vulkan.device;

import static org.lwjgl.system.MemoryStack.stackPush;
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
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.QueueManager;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.swapchain.ColorDomain;
import org.sheepy.lily.game.vulkan.swappipeline.SwapConfiguration;
import org.sheepy.lily.game.vulkan.swappipeline.SwapPipeline;

public class LogicalDevice
{
	private PhysicalDeviceWrapper physicalDevice;
	private QueueManager queueManager;

	private VkDevice vkDevice;
	private VkQueue graphicQueue;
	private VkQueue presentQueue;
	private CommandPool commandPool;

	private SwapPipeline swapPipeline;

	public final static LogicalDevice alloc(MemoryStack stack,
			PhysicalDeviceWrapper physicalDevice,
			long surface,
			String[] requiredExtensions,
			PointerBuffer ppEnabledLayerNames)
	{
		LogicalDevice res = new LogicalDevice(physicalDevice, surface);

		res.load(stack, requiredExtensions, ppEnabledLayerNames);
		return res;
	}

	private LogicalDevice(PhysicalDeviceWrapper physicalDevice, long surface)
	{
		this.physicalDevice = physicalDevice;

		queueManager = new QueueManager(physicalDevice.getVkPhysicalDevice());
		queueManager.load(surface);
	}

	public void load(MemoryStack stack,
			String[] requiredExtensions,
			PointerBuffer ppEnabledLayerNames)
	{
		VkDeviceQueueCreateInfo.Buffer queueCreateInfos = VkDeviceQueueCreateInfo.callocStack(2,
				stack);
		VkDeviceQueueCreateInfo queueCreateInfo = VkDeviceQueueCreateInfo.callocStack(stack);

		Set<Integer> uniqueQueueIndexes = new HashSet<Integer>(queueManager.getQueueIndexes());
		for (int queueIndex : uniqueQueueIndexes)
		{
			FloatBuffer queuePriority = memAllocFloat(1).put(1f);
			queuePriority.flip();
			queueCreateInfo.sType(VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO);
			queueCreateInfo.queueFamilyIndex(queueIndex);
			queueCreateInfo.pQueuePriorities(queuePriority);

			queueCreateInfos.put(queueCreateInfo);
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
		graphicQueue = queueManager.getGraphicQueue(vkDevice);
		presentQueue = queueManager.getPresentQueue(vkDevice);

		commandPool = CommandPool.alloc(stack, this, queueManager.getGraphicQueueIndex());
	}

	public SwapPipeline createSwapPipeline(SwapConfiguration configuration, ColorDomain colorDomain)
	{
		try (MemoryStack stack = stackPush())
		{
			swapPipeline = new SwapPipeline(this, configuration, commandPool, colorDomain);
		}

		return swapPipeline;
	}

	public void recreateSwapChain(long surface, int width, int height)
	{
		waitIdle();
		
		queueManager.load(surface);

		swapPipeline.destroy(false);
		swapPipeline.load(surface, width, height);
	}

	public VkDevice getVkDevice()
	{
		return vkDevice;
	}

	public VkQueue getGraphicQueue()
	{
		return graphicQueue;
	}

	public VkQueue getPresentQueue()
	{
		return presentQueue;
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

			if (vkQueueSubmit(graphicQueue,
					swapPipeline.getFrameSubmission().getSubmitInfo(imageIndex),
					VK_NULL_HANDLE) != VK_SUCCESS)
			{
				throw new AssertionError("failed to submit draw command buffer!");
			}

			vkQueuePresentKHR(presentQueue,
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
