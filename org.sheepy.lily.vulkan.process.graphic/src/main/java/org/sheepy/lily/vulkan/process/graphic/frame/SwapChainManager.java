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
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.util.ModelUtil;
import org.sheepy.lily.vulkan.common.util.VulkanBufferUtils;
import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class SwapChainManager implements IAllocable
{
	private Long swapChain = null;
	private List<Long> swapChainImages = null;
	private IntBuffer indices = null;
	private int swapImageCount;
	private boolean first = true;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var logicalDevice = graphicContext.getLogicalDevice();
		final var configuration = graphicContext.configuration;
		final var swapchainConfiguration = configuration.getSwapchainConfiguration();
		final var requiredImageCount = swapchainConfiguration.getRequiredSwapImageCount();
		final var pdsManager = graphicContext.surfaceManager;
		final var vkDevice = graphicContext.getVkDevice();
		final var capabilities = pdsManager.getCapabilities().vkCapabilities;
		final var surface = pdsManager.getSurface();
		final var extent = pdsManager.getExtent();
		final var requiredColorDomain = pdsManager.getColorDomain();

		final var imageCount = pdsManager.bestSupportedImageCount(requiredImageCount);
		final var requiredPresentMode = swapchainConfiguration.getPresentationMode();
		final int swapImageUsage = loadSwapChainUsage(swapchainConfiguration);
		final int targetPresentMode = selectPresentMode(graphicContext, requiredPresentMode, surface);

		final VkSwapchainCreateInfoKHR createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.ptr);
		createInfo.minImageCount(imageCount);
		createInfo.imageFormat(requiredColorDomain.getFormat().getValue());
		createInfo.imageColorSpace(requiredColorDomain.getColorSpace().getValue());
		createInfo.imageExtent().width(extent.width);
		createInfo.imageExtent().height(extent.height);
		createInfo.imageArrayLayers(1);
		createInfo.imageUsage(swapImageUsage);

		if (logicalDevice.isQueueExclusive() == false)
		{
			indices = logicalDevice.allocQueueIndices();
			createInfo.imageSharingMode(VK_SHARING_MODE_CONCURRENT);
			createInfo.pQueueFamilyIndices(indices);
		}
		else
		{
			createInfo.imageSharingMode(VK_SHARING_MODE_EXCLUSIVE);
			createInfo.pQueueFamilyIndices(null);
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

		if (first && DebugUtil.DEBUG_ENABLED)
		{
			printSwapChainInformations(targetPresentMode);
			first = false;
		}
	}

	private static int loadSwapChainUsage(final SwapchainConfiguration configuration)
	{
		final var usages = configuration.getSwapImageUsages();
		int res = ModelUtil.getEnumeratedFlag(usages);
		if (res == 0)
		{
			res = EImageUsage.COLOR_ATTACHMENT_VALUE;
		}
		return res;
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		vkDestroySwapchainKHR(graphicContext.getVkDevice(), swapChain, null);
		if (indices != null) MemoryUtil.memFree(indices);
		swapChain = null;
		swapChainImages = null;
		indices = null;
	}

	private void printSwapChainInformations(int presentMode)
	{
		final String presentationName = EPresentMode.get(presentMode).getName();
		final int imageCount = swapChainImages.size();
		final String message = String.format(
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

	public int getImageCount()
	{
		return swapChainImages.size();
	}

	public Long getSwapChain()
	{
		return swapChain;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		return graphicContext.surfaceManager.isAllocationDirty(context);
	}
}
