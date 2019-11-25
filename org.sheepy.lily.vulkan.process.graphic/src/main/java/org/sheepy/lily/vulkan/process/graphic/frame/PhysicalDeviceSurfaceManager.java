package org.sheepy.lily.vulkan.process.graphic.frame;

import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.vulkan.device.capabilities.Capabilities;
import org.sheepy.vulkan.device.capabilities.ColorDomains;
import org.sheepy.vulkan.device.capabilities.VkColorDomain;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.queue.VulkanQueue;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.surface.VkSurface.ISurfaceListener;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;
import org.sheepy.vulkan.window.IWindowListener.ISurfaceDeprecatedListener;
import org.sheepy.vulkan.window.Window;

public class PhysicalDeviceSurfaceManager implements ISurfaceManager
{
	private final ISizeListener sizeListener = size -> setDirty(true);
	private final ISurfaceDeprecatedListener surfaceDeprecationListener = () -> setDirty(true);
	private final ISurfaceListener surfaceListener = () -> setDirty(true);

	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private IAllocationConfiguration allocationConfiguration;
	private ColorDomain requiredColorDomain;
	private VulkanQueue presentQueue;

	private Extent2D extent;
	private VkSurface surface;

	@Override
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		this.allocationConfiguration = config;
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var logicalDevice = context.getLogicalDevice();

		var window = context.getWindow();
		surface = window.createSurface();
		surface.addListener(surfaceListener);

		presentQueue = logicalDevice.borrowPresentQueue(surface);
		window.addListener(sizeListener);
		window.addListener(surfaceDeprecationListener);

		capabilities = new Capabilities(context.getVkPhysicalDevice(), surface);
		colorDomains = new ColorDomains(context.getVkPhysicalDevice(), surface);
		extent = updateExtent(window);

		requiredColorDomain = loadColorDomain(context);
	}

	private Extent2D updateExtent(Window window)
	{
		final var currentExtent = capabilities.vkCapabilities.currentExtent();
		if (currentExtent.width() == -1 || currentExtent.height() == -1)
		{
			// -1 is special case, the surface will take the framebuffer size later.
			var size = window.getFramebufferSize();
			return new Extent2D(size.x(), size.y());
		}
		else
		{
			return new Extent2D(currentExtent.width(), currentExtent.height());
		}
	}

	private ColorDomain loadColorDomain(IGraphicContext context)
	{
		final var colorDomain = context.getConfiguration().getColorDomain();
		final var vkColorDomain = new VkColorDomain(colorDomain.getFormat().getValue(),
													colorDomain.getColorSpace().getValue());

		if (colorDomains.isColorDomainAvaillable(vkColorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
		}

		return colorDomain;
	}

	@Override
	public void free(IGraphicContext context)
	{
		final var logicalDevice = context.getLogicalDevice();

		logicalDevice.returnQueue(presentQueue);
		context.getWindow().removeListener(sizeListener);
		context.getWindow().removeListener(surfaceDeprecationListener);
		surface.removeListener(surfaceListener);

		capabilities.free();
		surface.free();
		capabilities = null;
		surface = null;
	}

	@Override
	public int bestSupportedImageCount(int required)
	{
		int requiredImageCount = 0;
		final var capabilities = this.capabilities.vkCapabilities;

		if (required == 0)
		{
			requiredImageCount = capabilities.minImageCount() + 1;
		}
		else if (required < capabilities.minImageCount())
		{
			requiredImageCount = capabilities.minImageCount();
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
	public ColorDomain getColorDomain()
	{
		return requiredColorDomain;
	}

	@Override
	public Extent2D getExtent()
	{
		return extent;
	}

	@Override
	public Capabilities getCapabilities()
	{
		return capabilities;
	}

	@Override
	public VkSurface getSurface()
	{
		return surface;
	}

	@Override
	public void setDirty(boolean dirty)
	{
		if (allocationConfiguration != null)
		{
			allocationConfiguration.setDirty();
		}
	}

	@Override
	public VulkanQueue getPresentQueue()
	{
		return presentQueue;
	}

	@Override
	public boolean isPresentable()
	{
		return extent.width != 0 && extent.height != 0;
	}
}
