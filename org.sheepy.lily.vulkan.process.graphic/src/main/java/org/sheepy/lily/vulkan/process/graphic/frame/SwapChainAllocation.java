package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.frame.util.PresentationModeSelector;
import org.sheepy.lily.vulkan.process.graphic.resource.SwapImageAttachmentAdapter;
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
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
public final class SwapChainAllocation implements ISwapChainAllocation, IExtender
{
	private static final String FAILED_TO_CREATE_SWAP_CHAIN = "Failed to create swap chain";
	private static boolean first = true;

	private final SwapImageAttachment swapImageAttachment;
	private final long swapChainPtr;
	private final int swapImageCount;
	private final IntBuffer indices;

	public SwapChainAllocation(SwapchainConfiguration configuration,
							   ProcessContext context,
							   @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation)
	{
		assert surfaceAllocation.isPresentable();

		swapImageAttachment = configuration.getColorAttachment();

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

		final var createInfo = VkSwapchainCreateInfoKHR.callocStack(stack);
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

		final var swapImageAdapter = swapImageAttachment.adapt(SwapImageAttachmentAdapter.class);
		swapImageAdapter.allocate(context, swapChainPtr);
		swapImageCount = swapImageAdapter.getImageCount();

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
		swapImageAttachment.adapt(SwapImageAttachmentAdapter.class).free();
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
											 swapImageCount);
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
		final var swapImageAdapter = swapImageAttachment.adapt(SwapImageAttachmentAdapter.class);
		return swapImageAdapter.getImagePtr(index);
	}

	@Override
	public int getImageCount()
	{
		return swapImageCount;
	}

	@Override
	public long getPtr()
	{
		return swapChainPtr;
	}
}
