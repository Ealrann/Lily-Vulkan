package org.sheepy.vulkan.swapchain;

import static org.lwjgl.system.MemoryUtil.memAllocInt;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSurface.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtent2D;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.PhysicalDeviceSupportDetails;
import org.sheepy.vulkan.pipeline.graphic.SwapConfiguration;
import org.sheepy.vulkan.queue.QueueManager;
import org.sheepy.vulkan.util.VulkanBufferUtils;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.window.Surface;

public class SwapChainManager implements IAllocable
{
	private LogicalDevice logicalDevice;
	private SwapConfiguration configuration;

	private PhysicalDeviceSupportDetails details;
	
	private Surface surface;
	private Extent2D extent;
	private int presentMode;
	
	private Long swapChain = null;
	private List<Long> swapChainImages = null;
	private ColorDomain currentColorDomain;
	
	public SwapChainManager(LogicalDevice logicalDevice, SwapConfiguration configuration)
	{
		this.logicalDevice = logicalDevice;
		this.configuration = configuration;

		this.details = new PhysicalDeviceSupportDetails(logicalDevice.getPhysicalDevice().getVkPhysicalDevice());
	}

	public void configure(Surface surface)
	{
		details.load(surface);
		presentMode = selectPresentationMode(surface.id, configuration.presentationMode);
		extent = new Extent2D(surface.width, surface.height);
		this.surface = surface;
	}
	
	@Override
	public void allocate(MemoryStack stack)
	{
		QueueManager queueManager = logicalDevice.getQueueManager();
		details.allocate(stack);
		currentColorDomain = chooseSwapSurfaceFormat();
		
		// Select max image in swap queue
		int swapImageCount = details.getCapabilities().minImageCount() + 1;
		if (details.getCapabilities().maxImageCount() > 0
				&& swapImageCount > details.getCapabilities().maxImageCount())
		{
			swapImageCount = details.getCapabilities().maxImageCount();
		}

		VkSwapchainCreateInfoKHR createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.id);
		createInfo.minImageCount(swapImageCount);
		createInfo.imageFormat(currentColorDomain.getColorFormat());
		createInfo.imageColorSpace(currentColorDomain.getColorSpace());
		createInfo.imageExtent().width(extent.width);
		createInfo.imageExtent().height(extent.height);
		createInfo.imageArrayLayers(1);
		createInfo.imageUsage(configuration.swapImageUsages);

		IntBuffer indices = null;

		if (queueManager.isExclusive() == false)
		{
			createInfo.imageSharingMode(VK_SHARING_MODE_CONCURRENT);
			indices = queueManager.allocIndices(stack);
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

		LongBuffer pSwapChain = stack.mallocLong(1);
		if (vkCreateSwapchainKHR(logicalDevice.getVkDevice(), createInfo, null,
				pSwapChain) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create swap chain!");
		}
		swapChain = pSwapChain.get(0);

		IntBuffer pImageCount = stack.mallocInt(1);
		vkGetSwapchainImagesKHR(logicalDevice.getVkDevice(), swapChain, pImageCount, null);
		swapImageCount = pImageCount.get(0);
		LongBuffer pSwapchainImages = stack.mallocLong(swapImageCount);
		vkGetSwapchainImagesKHR(logicalDevice.getVkDevice(), swapChain, pImageCount,
				pSwapchainImages);

		swapChainImages = Collections.unmodifiableList(VulkanBufferUtils.toList(pSwapchainImages));
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

	private int selectPresentationMode(long surface, int desiredMode)
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
			if (pPresentModes.get(i) == desiredMode)
			{
				swapchainPresentMode = desiredMode;
				break;
			}
			if (pPresentModes.get(i) == VK_PRESENT_MODE_MAILBOX_KHR)
			{
				swapchainPresentMode = VK_PRESENT_MODE_MAILBOX_KHR;
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
		ColorDomain targetColorDomain = configuration.colorDomain;

		// Best case : the graphic card has no preferences
		if (availableDomains.length == 1
				&& availableDomains[0].getColorFormat() == VK_FORMAT_UNDEFINED)
		{
			res = targetColorDomain;
		}

//		System.out.println("\nAvaillable Color Formats:");
		for (ColorDomain availableDomain : availableDomains)
		{
//			System.out.println("\t" + availableDomain);
			if (availableDomain.getColorFormat() == targetColorDomain.getColorFormat()
					&& availableDomain.getColorSpace() == targetColorDomain.getColorSpace())
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

	@Override
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
