package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtent2D;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.ColorDomain;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class PhysicalDeviceSurfaceManager implements IAllocable
{
	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private ColorDomain requiredColorDomain;

	private Extent2D extent;

	private VkSurface surface;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		final var logicalDevice = graphicContext.getLogicalDevice();
		final var window = logicalDevice.window;

		surface = window.getSurface();
		surface.lock();
		extent = new Extent2D(surface.width, surface.height);
		capabilities = new Capabilities(graphicContext.getVkPhysicalDevice(), surface);
		colorDomains = new ColorDomains(graphicContext.getVkPhysicalDevice(), surface);

		requiredColorDomain = loadColorDomain(graphicContext);
	}

	private ColorDomain loadColorDomain(GraphicContext context)
	{
		var colorDomain = context.configuration.getColorDomain();
		if (colorDomains.isColorDomainAvaillable(colorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
		}

		return colorDomain;
	}

	@Override
	public void free(IAllocationContext context)
	{
		capabilities.free();
		capabilities = null;
		surface.release();
		surface = null;
	}

	public ColorDomain getColorDomain()
	{
		return requiredColorDomain;
	}

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

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return surface.isDeprecated();
	}

	public class Extent2D
	{
		public final int width;
		public final int height;

		Extent2D(int width, int height)
		{
			this.width = width;
			this.height = height;
		}

		/**
		 *
		 * Alloc a new Extent. You will have to manage the free.
		 *
		 * @return
		 */
		public VkExtent2D allocVkExtent2D()
		{
			final VkExtent2D vkExtent = VkExtent2D.malloc();
			vkExtent.set(width, height);
			return vkExtent;
		}

		public int getWidth()
		{
			return width;
		}

		public int getHeight()
		{
			return height;
		}
	}
}
