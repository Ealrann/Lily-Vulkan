package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.graphic.ISwapChainManager;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.frame.util.PresentationModeSelector;
import org.sheepy.lily.vulkan.process.graphic.resource.SwapImageAttachmentAdapter;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

public final class SwapChainManager implements ISwapChainManager
{
	private static final String FAILED_TO_CREATE_SWAP_CHAIN = "Failed to create swap chain";

	private final SwapImageAttachment swapImageAttachment;

	private long swapChainPtr = 0;
	private IntBuffer indices = null;
	private boolean first = true;
	private int swapImageCount = 0;

	public SwapChainManager(SwapImageAttachment swapImageAttachment)
	{
		this.swapImageAttachment = swapImageAttachment;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addDependencies(List.of(context.getSurfaceManager()));
		config.setAllocationCondition(c -> ((IGraphicContext) c).getSurfaceManager().isPresentable());
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
		final var colorDomain = pdsManager.getColorDomain();
		final var stack = context.stack();
		final var imageCount = pdsManager.bestSupportedImageCount(requiredImageCount);
		final int swapImageUsage = loadSwapChainUsage(swapchainConfiguration);
		final int targetPresentMode = selectPresentMode(context, swapchainConfiguration, surface);

		final var createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.ptr);
		createInfo.minImageCount(imageCount);
		createInfo.imageFormat(colorDomain.getFormat().getValue());
		createInfo.imageColorSpace(colorDomain.getColorSpace().getValue());
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
		Logger.check(FAILED_TO_CREATE_SWAP_CHAIN, () -> vkCreateSwapchainKHR(vkDevice, createInfo, null, pSwapChain));
		swapChainPtr = pSwapChain.get(0);

		final var swapImageAdapter = swapImageAttachment.adapt(SwapImageAttachmentAdapter.class);
		swapImageAdapter.allocate(context, swapChainPtr);
		swapImageCount = swapImageAdapter.getImageCount();

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
		swapImageAttachment.adapt(SwapImageAttachmentAdapter.class).free();
		if (indices != null) MemoryUtil.memFree(indices);
		swapChainPtr = 0;
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
		int res = VulkanModelUtil.getEnumeratedFlag(usages);
		if (res == 0)
		{
			res = EImageUsage.COLOR_ATTACHMENT_VALUE;
		}
		return res;
	}

	private void printSwapChainInformations(int presentMode)
	{
		final String presentationName = EPresentMode.get(presentMode).getName();
		final String message = String.format("Swapchain created:\n\t- PresentationMode: %s\n\t- Number of images: %d",
											 presentationName,
											 swapImageCount);
		System.out.println(message);
	}

	private static int selectPresentMode(IGraphicContext context,
										 SwapchainConfiguration configuration,
										 VkSurface surface)
	{
		final var selector = new PresentationModeSelector(configuration);
		return selector.findBestMode(context, surface);
	}

	@Override
	public List<Long> getSwapChainImages()
	{
		final var swapImageAdapter = swapImageAttachment.adapt(SwapImageAttachmentAdapter.class);
		return swapImageAdapter.getImagePtrs();
	}

	@Override
	public int getImageCount()
	{
		return swapImageCount;
	}

	@Override
	public long getAddress()
	{
		return swapChainPtr;
	}
}
