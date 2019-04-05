package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainManager;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.resource.attachment.ISwapAttachmentAdapter;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.common.util.VulkanBufferUtils;
import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;

public class SwapChainManager implements ISwapChainManager
{
	private Long swapChain = null;
	private List<Long> swapChainImages = null;
	private IntBuffer indices = null;
	private int swapImageCount;
	private boolean first = true;
	private EList<ISwapAttachment> attachments;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var logicalDevice = graphicContext.getLogicalDevice();
		final var configuration = graphicContext.getConfiguration();
		final var swapchainConfiguration = configuration.getSwapchainConfiguration();
		final var requiredImageCount = swapchainConfiguration.getRequiredSwapImageCount();
		final var pdsManager = graphicContext.getSurfaceManager();
		final var vkDevice = graphicContext.getVkDevice();
		final var capabilities = pdsManager.getCapabilities().vkCapabilities;
		final var surface = pdsManager.getSurface();
		final var extent = pdsManager.getExtent();
		final var requiredColorDomain = pdsManager.getColorDomain();

		final var imageCount = pdsManager.bestSupportedImageCount(requiredImageCount);
		final var requiredPresentMode = swapchainConfiguration.getPresentationMode();
		final int swapImageUsage = loadSwapChainUsage(swapchainConfiguration);
		final int targetPresentMode = selectPresentMode(graphicContext, requiredPresentMode,
				surface);

		attachments = swapchainConfiguration.getAtachments();
		allocateAttachments(stack, context);
		
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

	private void allocateAttachments(MemoryStack stack, IAllocationContext context)
	{
		for (final ISwapAttachment attachment : attachments)
		{
			final var adapter = ISwapAttachmentAdapter.adapt(attachment);
			adapter.allocate(stack, context);
		}
	}

	private static int loadSwapChainUsage(final SwapchainConfiguration configuration)
	{
		final var usages = configuration.getSwapImageUsages();
		int res = VulkanModelUtil.getEnumeratedFlag(usages);
		if (res == 0)
		{
			res = EImageUsage.COLOR_ATTACHMENT_VALUE;
		}
		return res;
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		vkDestroySwapchainKHR(graphicContext.getVkDevice(), swapChain, null);
		if (indices != null) MemoryUtil.memFree(indices);
		swapChain = null;
		swapChainImages = null;
		indices = null;

		freeAttachments(context);
	}

	private void freeAttachments(IAllocationContext context)
	{
		for (final ISwapAttachment attachment : attachments)
		{
			final var adapter = ISwapAttachmentAdapter.adapt(attachment);
			adapter.free(context);
		}
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

	private static int selectPresentMode(	IGraphicContext context,
											EPresentMode requiredPresentMode,
											VkSurface surface)
	{
		final var selector = new PresentationModeSelector(context.getLogicalDevice(), surface);
		return selector.findBestMode(requiredPresentMode);
	}

	@Override
	public List<Long> getSwapChainImages()
	{
		return swapChainImages;
	}

	@Override
	public int getImageCount()
	{
		return swapChainImages.size();
	}

	@Override
	public long getAddress()
	{
		return swapChain;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		return graphicContext.getSurfaceManager().isAllocationDirty(context);
	}
}
