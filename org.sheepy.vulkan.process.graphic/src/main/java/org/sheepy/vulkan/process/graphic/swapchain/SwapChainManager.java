package org.sheepy.vulkan.process.graphic.swapchain;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkExtent2D;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.vulkan.api.window.IWindowListener;
import org.sheepy.vulkan.api.window.Surface;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.queue.IQueueManagerListener;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.common.util.VulkanBufferUtils;
import org.sheepy.vulkan.model.ColorDomain;
import org.sheepy.vulkan.model.enumeration.EPresentMode;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.process.graphic.process.GraphicContext;

public class SwapChainManager implements IBasicAllocable, IQueueManagerListener, IWindowListener
{
	private final GraphicContext context;

	private Extent2D extent;

	private Long swapChain = null;
	private List<Long> swapChainImages = null;
	private ColorDomain colorDomain;

	private IntBuffer indices = null;
	private int minImageCount;
	private int swapImageCount;
	private Surface surface;
	private int swapImageUsage;
	private EPresentMode desiredMode;
	private int presentMode = -1;

	private boolean dirty = false;

	public SwapChainManager(GraphicContext context)
	{
		this.context = context;

		init();
		final var logicalDevice = context.logicalDevice;

		loadSurface(logicalDevice.window.getSurface());

		logicalDevice.window.addListener(this);
		logicalDevice.queueManager.addListener(this);
	}

	private void init()
	{
		final GraphicConfiguration configuration = context.configuration;

		final var logicalDevice = context.logicalDevice;
		final var capabilities = logicalDevice.getCapabilities();
		swapImageUsage = configuration.getSwapImageUsage();
		colorDomain = configuration.getColorDomain();
		desiredMode = configuration.getPresentationMode();

		if (logicalDevice.isColorDomainAvaillable(colorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
		}

		minImageCount = capabilities.minImageCount() + 1;
		if (capabilities.maxImageCount() > 0 && minImageCount > capabilities.maxImageCount())
		{
			minImageCount = capabilities.maxImageCount();
		}
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		createSwapChain(stack);
		dirty = false;
	}

	@Override
	public void free()
	{
		vkDestroySwapchainKHR(context.getVkDevice(), swapChain, null);
		MemoryUtil.memFree(indices);
		swapChainImages = null;
		indices = null;
	}

	private void loadSurface(Surface surface)
	{
		this.surface = surface;
		extent = new Extent2D(surface.width, surface.height);
		selectPresentMode(context, surface);
	}

	private void createSwapChain(MemoryStack stack) throws AssertionError
	{
		final var queueManager = context.logicalDevice.queueManager;
		final var capabilities = context.logicalDevice.getCapabilities();
		final var vkDevice = context.getVkDevice();

		final VkSwapchainCreateInfoKHR createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.id);
		createInfo.minImageCount(minImageCount);
		createInfo.imageFormat(colorDomain.getFormat().getValue());
		createInfo.imageColorSpace(colorDomain.getColorSpace().getValue());
		createInfo.imageExtent().width(extent.width);
		createInfo.imageExtent().height(extent.height);
		createInfo.imageArrayLayers(1);
		createInfo.imageUsage(swapImageUsage);

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

		createInfo.preTransform(capabilities.currentTransform());
		createInfo.compositeAlpha(VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR);
		createInfo.presentMode(presentMode);
		createInfo.clipped(true);
		createInfo.oldSwapchain(VK_NULL_HANDLE);

		final LongBuffer pSwapChain = stack.mallocLong(1);
		Logger.check("Failed to create swap chain",
				() -> vkCreateSwapchainKHR(vkDevice, createInfo, null, pSwapChain));
		swapChain = pSwapChain.get(0);

		final IntBuffer pImageCount = stack.mallocInt(1);
		vkGetSwapchainImagesKHR(vkDevice, swapChain, pImageCount, null);
		swapImageCount = pImageCount.get(0);
		final LongBuffer pSwapchainImages = stack.mallocLong(swapImageCount);
		vkGetSwapchainImagesKHR(vkDevice, swapChain, pImageCount, pSwapchainImages);

		swapChainImages = List.copyOf(VulkanBufferUtils.toList(pSwapchainImages));
	}

	private void selectPresentMode(GraphicContext context, Surface surface)
	{
		final var selector = new PresentationModeSelector(context.logicalDevice, surface);
		presentMode = selector.findBestMode(desiredMode);
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
		return colorDomain;
	}

	public Extent2D getExtent()
	{
		return extent;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return dirty;
	}

	@Override
	public void onQueueManagerReload()
	{
		dirty = true;
	}

	@Override
	public void onWindowResize(Surface surface)
	{
		loadSurface(surface);
		dirty = true;
	}

	public class Extent2D
	{
		private final int width;
		private final int height;

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
			final VkExtent2D vkExtent = VkExtent2D.malloc();
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
