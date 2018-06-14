package org.sheepy.lily.game.vulkan.swapchain;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSurface.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collections;
import java.util.List;

import org.lwjgl.vulkan.VkExtent2D;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.device.PhysicalDeviceSupportDetails;
import org.sheepy.lily.game.vulkan.queue.QueueManager;
import org.sheepy.lily.game.vulkan.util.VulkanBufferUtils;
import org.sheepy.lily.game.vulkan.util.VulkanUtils;

public class SwapChainManager
{
	private LogicalDevice logicalDevice;
	private PhysicalDeviceSupportDetails details;
	private ColorDomain targetColorDomain;
	private Long swapChain = null;

	private List<Long> swapChainImages = null;

	private ColorDomain currentColorDomain;
	private Extent2D extent;

	public SwapChainManager(LogicalDevice logicalDevice, ColorDomain targetColorDomain)
	{
		this.logicalDevice = logicalDevice;
		this.targetColorDomain = targetColorDomain;
	}

	public Long load(long surface, int width, int height)
	{
		this.details = new PhysicalDeviceSupportDetails(logicalDevice.getPhysicalDevice(), surface);
		QueueManager queueManager = logicalDevice.getQueueManager();
		currentColorDomain = chooseSwapSurfaceFormat();
		int presentMode = selectPresentationMode(surface);
		extent = new Extent2D(width, height);

		// Select max image in swap queue
		int swapImageCount = details.getCapabilities().minImageCount() + 1;
		if (details.getCapabilities().maxImageCount() > 0
				&& swapImageCount > details.getCapabilities().maxImageCount())
		{
			swapImageCount = details.getCapabilities().maxImageCount();
		}

		VkSwapchainCreateInfoKHR createInfo = VkSwapchainCreateInfoKHR.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface);
		createInfo.minImageCount(swapImageCount);
		createInfo.imageFormat(currentColorDomain.getColorFormat());
		createInfo.imageColorSpace(currentColorDomain.getColorSpace());
		createInfo.imageExtent().width(extent.width);
		createInfo.imageExtent().height(extent.height);
		createInfo.imageArrayLayers(1);
		createInfo.imageUsage(VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT);

		IntBuffer indices = null;

		if (queueManager.isExclusive() == false)
		{
			createInfo.imageSharingMode(VK_SHARING_MODE_CONCURRENT);
			indices = queueManager.allocIndices();
			createInfo.pQueueFamilyIndices(indices);
		}
		else
		{
			createInfo.imageSharingMode(VK_SHARING_MODE_EXCLUSIVE);
			createInfo.pQueueFamilyIndices(null); // Optional
		}

		createInfo.preTransform(details.getCapabilities().currentTransform());
		createInfo.compositeAlpha(VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR);
		createInfo.presentMode(presentMode);
		createInfo.clipped(true);
		createInfo.oldSwapchain(VK_NULL_HANDLE);

		LongBuffer pSwapChain = memAllocLong(1);
		if (vkCreateSwapchainKHR(logicalDevice.getVkDevice(), createInfo, null,
				pSwapChain) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create swap chain!");
		}
		swapChain = pSwapChain.get(0);

		IntBuffer pImageCount = memAllocInt(1);
		vkGetSwapchainImagesKHR(logicalDevice.getVkDevice(), swapChain, pImageCount, null);
		swapImageCount = pImageCount.get(0);
		LongBuffer pSwapchainImages = memAllocLong(swapImageCount);
		vkGetSwapchainImagesKHR(logicalDevice.getVkDevice(), swapChain, pImageCount,
				pSwapchainImages);

		swapChainImages = Collections.unmodifiableList(VulkanBufferUtils.toList(pSwapchainImages));

		memFree(pSwapchainImages);
		memFree(pImageCount);
		memFree(pSwapChain);
		if (indices != null) memFree(indices);
		createInfo.free();

		return swapChain;
	}

	public List<Long> getSwapChainImages()
	{
		return swapChainImages;
	}

	public Long getSwapChain()
	{
		return swapChain;
	}

	public ColorDomain getColorDomain()
	{
		return currentColorDomain;
	}

	private int selectPresentationMode(long surface)
	{
		IntBuffer pPresentModeCount = memAllocInt(1);
		int err = vkGetPhysicalDeviceSurfacePresentModesKHR(
				logicalDevice.getPhysicalDevice().getVkPhysicalDevice(), surface, pPresentModeCount,
				null);
		int presentModeCount = pPresentModeCount.get(0);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to get number of physical device surface presentation modes: "
							+ VulkanUtils.translateVulkanResult(err));
		}

		IntBuffer pPresentModes = memAllocInt(presentModeCount);
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(
				logicalDevice.getPhysicalDevice().getVkPhysicalDevice(), surface, pPresentModeCount,
				pPresentModes);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get physical device surface presentation modes: "
					+ VulkanUtils.translateVulkanResult(err));
		}

		// Try to use mailbox mode. Low latency and non-tearing
		int swapchainPresentMode = VK_PRESENT_MODE_FIFO_KHR;
		for (int i = 0; i < presentModeCount; i++)
		{
			if (pPresentModes.get(i) == VK_PRESENT_MODE_MAILBOX_KHR)
			{
				swapchainPresentMode = VK_PRESENT_MODE_MAILBOX_KHR;
				break;
			}
			if ((swapchainPresentMode != VK_PRESENT_MODE_MAILBOX_KHR)
					&& (pPresentModes.get(i) == VK_PRESENT_MODE_IMMEDIATE_KHR))
			{
				swapchainPresentMode = VK_PRESENT_MODE_IMMEDIATE_KHR;
			}
		}
		memFree(pPresentModeCount);
		memFree(pPresentModes);

		return swapchainPresentMode;
	}

	private ColorDomain chooseSwapSurfaceFormat()
	{
		ColorDomain res = null;
		ColorDomain[] availableDomains = details.getColorDomains();

		// Best case : the graphic card has no preferences
		if (availableDomains.length == 1
				&& availableDomains[0].getColorFormat() == VK_FORMAT_UNDEFINED)
		{
			res = targetColorDomain;
		}

		for (ColorDomain availableDomain : availableDomains)
		{
			if (availableDomain.getColorFormat() == targetColorDomain.getColorFormat()
					&& availableDomain.getColorSpace() == VK_COLOR_SPACE_SRGB_NONLINEAR_KHR)
			{
				res = targetColorDomain;
				break;
			}
		}

		return res;
	}

	public Extent2D getExtent()
	{
		return extent;
	}

	public void free()
	{
		vkDestroySwapchainKHR(logicalDevice.getVkDevice(), swapChain, null);
	}

	public class Extent2D
	{
		private int width;
		private int height;

		Extent2D(int width, int height)
		{
			this.width = width;
			this.height = height;
		}

		/**
		 * 
		 * Alloc a new Extent. You will have to manage the free.
		 * 
		 * @return
		 */
		public VkExtent2D allocVkExtent2D()
		{
			VkExtent2D vkExtent = VkExtent2D.malloc();
			vkExtent.set(extent.getWidth(), extent.getHeight());
			return vkExtent;
		}

		public int getWidth()
		{
			return width;
		}

		public int getHeight()
		{
			return height;
		}
	}
}
