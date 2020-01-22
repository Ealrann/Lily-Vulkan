package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.graphic.ISwapChainManager;
import org.sheepy.lily.vulkan.common.util.VulkanBufferUtils;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.frame.util.PresentationModeSelector;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.util.VkModelUtil;

public final class SwapChainManager implements ISwapChainManager
{
	private static final String FAILED_TO_CREATE_SWAP_CHAIN = "Failed to create swap chain";

	private long swapChainPtr = 0;
	private List<Long> swapChainImages = null;
	private IntBuffer indices = null;
	private int swapImageCount;
	private boolean first = true;

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addDependencies(List.of(context.getSurfaceManager()));
		config.setAllocationCondition(c -> ((IGraphicContext) c).getSurfaceManager()
																.isPresentable());
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var pdsManager = context.getSurfaceManager();
		final var extent = pdsManager.getExtent();
		final var logicalDevice = context.getLogicalDevice();
		final var configuration = context.getConfiguration();
		final var swapchainConfiguration = configuration.getSwapchainConfiguration();
		final var requiredImageCount = swapchainConfiguration.getRequiredSwapImageCount();
		final var vkDevice = context.getVkDevice();
		final var capabilities = pdsManager.getCapabilities().vkCapabilities;
		final var surface = pdsManager.getSurface();
		final var requiredColorDomain = pdsManager.getColorDomain();
		final var stack = context.stack();
		final var imageCount = pdsManager.bestSupportedImageCount(requiredImageCount);
		final int swapImageUsage = loadSwapChainUsage(swapchainConfiguration);
		final int targetPresentMode = selectPresentMode(context, swapchainConfiguration, surface);

		final var createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
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
			final boolean accessFromCompute = swapchainConfiguration.isAllowingAccessFromCompute();
			indices = allocQueueIndices(logicalDevice, accessFromCompute);
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
		Logger.check(	FAILED_TO_CREATE_SWAP_CHAIN,
						() -> vkCreateSwapchainKHR(vkDevice, createInfo, null, pSwapChain));
		swapChainPtr = pSwapChain.get(0);

		final IntBuffer pImageCount = stack.mallocInt(1);
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, null);
		swapImageCount = pImageCount.get(0);
		final LongBuffer pSwapchainImages = stack.mallocLong(swapImageCount);
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, pSwapchainImages);

		swapChainImages = List.copyOf(VulkanBufferUtils.toList(pSwapchainImages));

		if (first && DebugUtil.DEBUG_ENABLED)
		{
			printSwapChainInformations(targetPresentMode);
			first = false;
		}
	}

	@Override
	public void free(IGraphicContext context)
	{
		vkDestroySwapchainKHR(context.getVkDevice(), swapChainPtr, null);
		if (indices != null) MemoryUtil.memFree(indices);
		swapChainPtr = 0;
		swapChainImages = null;
		indices = null;
	}

	public static IntBuffer allocQueueIndices(LogicalDevice logicalDevice, boolean computeAcces)
	{
		final Function<EQueueType, Integer> indexOf = logicalDevice::getQueueFamilyIndex;
		final Set<Integer> indices = new HashSet<>();
		indices.add(indexOf.apply(EQueueType.Graphic));
		indices.add(indexOf.apply(EQueueType.Present));
		if (computeAcces) indices.add(indexOf.apply(EQueueType.Compute));

		final IntBuffer res = MemoryUtil.memAllocInt(indices.size());
		for (final Integer index : indices)
		{
			res.put(index);
		}
		res.flip();

		return res;
	}

	private static int loadSwapChainUsage(final SwapchainConfiguration configuration)
	{
		final var usages = configuration.getSwapImageUsages();
		int res = VkModelUtil.getEnumeratedFlag(usages);
		if (res == 0)
		{
			res = EImageUsage.COLOR_ATTACHMENT_VALUE;
		}
		return res;
	}

	private void printSwapChainInformations(int presentMode)
	{
		final String presentationName = EPresentMode.get(presentMode).getName();
		final int imageCount = swapChainImages.size();
		final String message = String.format(	"Swapchain created:\n\t- PresentationMode: %s\n\t- Number of images: %d",
												presentationName,
												imageCount);
		System.out.println(message);
	}

	private static int selectPresentMode(	IGraphicContext context,
											SwapchainConfiguration configuration,
											VkSurface surface)
	{
		final var selector = new PresentationModeSelector(configuration);
		return selector.findBestMode(context, surface);
	}

	@Override
	public List<Long> getSwapChainImages()
	{
		return swapChainImages;
	}

	@Override
	public int getImageCount()
	{
		return swapChainImages != null ? swapChainImages.size() : 0;
	}

	@Override
	public long getAddress()
	{
		return swapChainPtr;
	}
}
