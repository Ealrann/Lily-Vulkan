package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.ColorDomain;
import org.sheepy.lily.vulkan.process.graphic.api.Extent2D;
import org.sheepy.lily.vulkan.process.graphic.api.ISurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

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
		final var graphicContext = (GraphicContext) context;
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

	private ColorDomain loadColorDomain(GraphicContext context)
	{
		final var colorDomain = context.configuration.getColorDomain();
		if (colorDomains.isColorDomainAvaillable(colorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
		}

		return colorDomain;
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		graphicContext.getWindow().addListener(listener);

		capabilities.free();
		surface.free();
		capabilities = null;
		surface = null;
	}

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

	public ColorDomain getColorDomain()
	{
		return requiredColorDomain;
	}

	@Override
	public Extent2D getExtent()
	{
		return extent;
	}

	public Capabilities getCapabilities()
	{
		return capabilities;
	}

	public ColorDomains getColorDomains()
	{
		return colorDomains;
	}

	public VkSurface getSurface()
	{
		return surface;
	}

	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return dirty || surface.isDeprecated();
	}

	public VulkanQueue getPresentQueue()
	{
		return presentQueue;
	}
}
