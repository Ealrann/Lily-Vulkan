package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.util.VulkanBufferUtils;
import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class SwapChainManager implements IAllocable
{
	private Long swapChain = null;
	private List<Long> swapChainImages = null;
	private IntBuffer indices = null;
	private int swapImageCount;

	private static int loadSwapChainUsage(final GraphicConfiguration configuration)
	{
		int swapImageUsage = 0;
		var usages = configuration.getSwapImageUsages();
		if (usages.isEmpty() == false)
		{
			for (EImageUsage usage : usages)
			{
				swapImageUsage |= usage.getValue();
			}
		}
		else
		{
			swapImageUsage = EImageUsage.COLOR_ATTACHMENT_VALUE;
		}
		return swapImageUsage;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var queueManager = graphicContext.getLogicalDevice().queueManager;
		final var configuration = graphicContext.configuration;
		final var pdsManager = graphicContext.surfaceManager;
		final var vkDevice = graphicContext.getVkDevice();
		final var capabilities = pdsManager.getCapabilities().vkCapabilities;
		final var surface = pdsManager.getSurface();
		final var extent = pdsManager.getExtent();
		final var requiredColorDomain = pdsManager.getColorDomain();

		var requiredImageCount = loadRequiredImageCount(graphicContext);
		var requiredPresentMode = configuration.getPresentationMode();
		int swapImageUsage = loadSwapChainUsage(configuration);
		int targetPresentMode = selectPresentMode(graphicContext, requiredPresentMode, surface);

		final VkSwapchainCreateInfoKHR createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.ptr);
		createInfo.minImageCount(requiredImageCount);
		createInfo.imageFormat(requiredColorDomain.getFormat().getValue());
		createInfo.imageColorSpace(requiredColorDomain.getColorSpace().getValue());
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
		createInfo.presentMode(targetPresentMode);
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

		if (graphicContext.application.isDebug())
		{
			printSwapChainInformations(targetPresentMode);
		}
	}

	private static int loadRequiredImageCount(GraphicContext context)
	{
		int requiredImageCount = 0;
		final var capabilities = context.surfaceManager.getCapabilities().vkCapabilities;
		int required = context.configuration.getRequiredSwapImageCount();
		if (required < capabilities.minImageCount() || required == 0)
		{
			requiredImageCount = capabilities.minImageCount() + 1;
		}
		else
		{
			requiredImageCount = required;
		}

		if (capabilities.maxImageCount() > 0 && requiredImageCount > capabilities.maxImageCount())
		{
			requiredImageCount = capabilities.maxImageCount();
		}

		return requiredImageCount;
	}

	@Override
	public void free(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		vkDestroySwapchainKHR(graphicContext.getVkDevice(), swapChain, null);
		MemoryUtil.memFree(indices);
		swapChainImages = null;
		indices = null;
	}

	private void printSwapChainInformations(int presentMode)
	{
		String presentationName = EPresentMode.get(presentMode).getName();
		int imageCount = swapChainImages.size();
		String message = String.format(
				"Swapchain created:\n\t- PresentationMode: %s\n\t- Number of images: %d",
				presentationName, imageCount);
		System.out.println(message);
	}

	private static int selectPresentMode(	GraphicContext context,
											EPresentMode requiredPresentMode,
											VkSurface surface)
	{
		final var selector = new PresentationModeSelector(context.getLogicalDevice(), surface);
		return selector.findBestMode(requiredPresentMode);
	}

	public List<Long> getSwapChainImages()
	{
		return swapChainImages;
	}

	public Long getSwapChain()
	{
		return swapChain;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		return graphicContext.surfaceManager.isAllocationDirty(context);
	}
}
