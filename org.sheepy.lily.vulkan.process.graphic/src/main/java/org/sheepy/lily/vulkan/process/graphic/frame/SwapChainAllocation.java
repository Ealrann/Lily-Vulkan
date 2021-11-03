package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.frame.util.PresentationModeSelector;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static org.lwjgl.vulkan.KHRSurface.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = SwapchainConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.SWAPCHAIN_CONFIGURATION__COLOR_ATTACHMENT)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
public final class SwapChainAllocation implements ISwapChainAllocation, IAdapter
{
	private static final String FAILED_TO_CREATE_SWAP_CHAIN = "Failed to create swap chain";
	private static boolean first = true;

	private final long swapChainPtr;
	private final long[] swapChainImages;
	private final IntBuffer indices;

	public SwapChainAllocation(SwapchainConfiguration configuration,
							   ProcessContext context,
							   @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation)
	{
		assert surfaceAllocation.isPresentable();

		final var graphicConfiguration = (GraphicConfiguration) configuration.eContainer();
		final var extent = surfaceAllocation.getExtent();
		final var logicalDevice = context.getLogicalDevice();
		final var swapchainConfiguration = graphicConfiguration.getSwapchainConfiguration();
		final var requiredImageCount = swapchainConfiguration.getRequiredSwapImageCount();
		final var vkDevice = context.getVkDevice();
		final var capabilities = surfaceAllocation.getCapabilities().vkCapabilities;
		final var surface = surfaceAllocation.getSurface();
		final var colorDomain = surfaceAllocation.getColorDomain();
		final var stack = context.stack();
		final var imageCount = surfaceAllocation.bestSupportedImageCount(requiredImageCount);
		final int swapImageUsage = loadSwapChainUsage(swapchainConfiguration);
		final var targetPresentMode = selectPresentMode(context, swapchainConfiguration, surface);

		final var createInfo = VkSwapchainCreateInfoKHR.calloc(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR);
		createInfo.surface(surface.ptr);
		createInfo.minImageCount(imageCount);
		createInfo.imageFormat(colorDomain.format);
		createInfo.imageColorSpace(colorDomain.colorSpace);
		createInfo.imageExtent().width(extent.x());
		createInfo.imageExtent().height(extent.y());
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
			indices = null;
		}

		createInfo.preTransform(capabilities.currentTransform());
		createInfo.compositeAlpha(VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR);
		createInfo.presentMode(targetPresentMode.getValue());
		createInfo.clipped(true);
		createInfo.oldSwapchain(VK_NULL_HANDLE);

		final LongBuffer pSwapChain = stack.mallocLong(1);
		Logger.check(FAILED_TO_CREATE_SWAP_CHAIN, () -> vkCreateSwapchainKHR(vkDevice, createInfo, null, pSwapChain));
		swapChainPtr = pSwapChain.get(0);

		final int[] pImageCount = new int[1];
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, null);
		final int swapImageCount = pImageCount[0];
		swapChainImages = new long[swapImageCount];
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, swapChainImages);

		if (first && DebugUtil.DEBUG_ENABLED)
		{
			printSwapChainInformations(targetPresentMode);
			first = false;
		}
	}

	@Free
	public void free(ProcessContext context)
	{
		vkDestroySwapchainKHR(context.getVkDevice(), swapChainPtr, null);
		if (indices != null) MemoryUtil.memFree(indices);
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

	private void printSwapChainInformations(EPresentMode presentMode)
	{
		final String presentationName = presentMode.getName();
		final String message = String.format("Swapchain created:\n\t- PresentationMode: %s\n\t- Number of images: %d",
											 presentationName,
											 swapChainImages.length);
		System.out.println(message);
	}

	private static EPresentMode selectPresentMode(ProcessContext context,
												  SwapchainConfiguration configuration,
												  VkSurface surface)
	{
		final var selector = new PresentationModeSelector(configuration);
		return selector.findBestMode(context, surface);
	}

	@Override
	public long getImagePtr(int index)
	{
		return swapChainImages[index];
	}

	@Override
	public int getImageCount()
	{
		return swapChainImages.length;
	}

	@Override
	public long getPtr()
	{
		return swapChainPtr;
	}
}
