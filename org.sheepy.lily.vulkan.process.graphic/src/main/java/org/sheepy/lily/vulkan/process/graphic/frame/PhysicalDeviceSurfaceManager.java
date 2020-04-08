package org.sheepy.lily.vulkan.process.graphic.frame;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.game.api.window.IWindowListener;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
import org.sheepy.lily.vulkan.core.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.core.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.core.device.capabilities.VkColorDomain;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.core.window.VkSurface.ISurfaceListener;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class PhysicalDeviceSurfaceManager implements ISurfaceManager, IAllocable<GraphicContext>
{
	private final IWindowListener.ISizeListener sizeListener = size -> setDirty(true);
	private final IWindowListener.ISurfaceDeprecatedListener surfaceDeprecationListener = () -> setDirty(true);
	private final ISurfaceListener surfaceListener = () -> setDirty(true);

	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private IAllocationConfigurator allocationConfiguration;
	private ColorDomain requiredColorDomain;
	private VulkanQueue presentQueue;

	private Vector2ic extent;
	private VkSurface surface;

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		this.allocationConfiguration = config;
	}

	@Override
	public void allocate(GraphicContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		final var vkInstance = context.getVkInstance();
		final var window = context.getWindow();
		surface = window.createSurface(vkInstance);
		surface.addListener(surfaceListener);

		presentQueue = logicalDevice.borrowPresentQueue(surface);
		window.addListener(sizeListener);
		window.addListener(surfaceDeprecationListener);

		capabilities = new Capabilities(context.getVkPhysicalDevice(), surface);
		colorDomains = new ColorDomains(context.getVkPhysicalDevice(), surface);
		extent = updateExtent(window);

		requiredColorDomain = loadColorDomain(context);
	}

	private Vector2ic updateExtent(Window window)
	{
		final var currentExtent = capabilities.vkCapabilities.currentExtent();
		if (currentExtent.width() == -1 || currentExtent.height() == -1)
		{
			// -1 is special case, the surface will take the framebuffer size later.
			final var size = window.getFramebufferSize();
			return new Vector2i(size.x(), size.y());
		}
		else
		{
			return new Vector2i(currentExtent.width(), currentExtent.height());
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
	public void free(GraphicContext context)
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
		presentQueue = null;
	}

	@Override
	public int bestSupportedImageCount(int required)
	{
		final int requiredImageCount;
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
			return capabilities.maxImageCount();
		}
		else
		{
			return requiredImageCount;
		}
	}

	@Override
	public ColorDomain getColorDomain()
	{
		return requiredColorDomain;
	}

	@Override
	public Vector2ic getExtent()
	{
		return extent;
	}

	public Capabilities getCapabilities()
	{
		return capabilities;
	}

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

	public VulkanQueue getPresentQueue()
	{
		return presentQueue;
	}

	@Override
	public boolean isPresentable()
	{
		return extent.x() != 0 && extent.y() != 0;
	}

	@Override
	public int supportedUsageFlags()
	{
		return capabilities.vkCapabilities.supportedUsageFlags();
	}
}
