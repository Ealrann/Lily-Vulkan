package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtent2D;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
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

		var currentExtent = capabilities.vkCapabilities.currentExtent();
		extent = new Extent2D(currentExtent.width(), currentExtent.height());

		requiredColorDomain = loadColorDomain(graphicContext);

		dirty = false;
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
		final var graphicContext = (GraphicContext) context;
		graphicContext.getWindow().addListener(listener);

		capabilities.free();
		surface.free();
		capabilities = null;
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
