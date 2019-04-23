package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.device.capabilities.Capabilities;
import org.sheepy.vulkan.device.capabilities.ColorDomains;
import org.sheepy.vulkan.device.capabilities.VkColorDomain;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.queue.VulkanQueue;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.window.IWindowListener;

public class PhysicalDeviceSurfaceManager implements IAllocable, ISurfaceManager
{
	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private ColorDomain requiredColorDomain;
	private VulkanQueue presentQueue;

	private Extent2D extent;
	private VkSurface surface;

	public boolean dirty = false;

	private final IWindowListener listener = new IWindowListener()
	{
		@Override
		public void onResize(org.joml.Vector2i size)
		{
			setDirty(true);
		}

		@Override
		public void onSurfaceDeprecation()
		{
			setDirty(true);
		}
	};

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var logicalDevice = graphicContext.getLogicalDevice();

		surface = graphicContext.getWindow().createSurface();
		presentQueue = logicalDevice.createPresentQueue(surface);
		graphicContext.getWindow().addListener(listener);

		capabilities = new Capabilities(graphicContext.getVkPhysicalDevice(), surface);
		colorDomains = new ColorDomains(graphicContext.getVkPhysicalDevice(), surface);

		final var currentExtent = capabilities.vkCapabilities.currentExtent();
		extent = new Extent2D(currentExtent.width(), currentExtent.height());

		requiredColorDomain = loadColorDomain(graphicContext);

		dirty = false;
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
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		graphicContext.getWindow().addListener(listener);

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

	public ColorDomains getColorDomains()
	{
		return colorDomains;
	}

	@Override
	public VkSurface getSurface()
	{
		return surface;
	}

	@Override
	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return dirty || surface.isDeprecated();
	}

	@Override
	public VulkanQueue getPresentQueue()
	{
		return presentQueue;
	}
}
