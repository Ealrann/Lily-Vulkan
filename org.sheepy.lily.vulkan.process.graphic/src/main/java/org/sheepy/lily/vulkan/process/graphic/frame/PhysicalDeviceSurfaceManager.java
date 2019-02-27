package org.sheepy.lily.vulkan.process.graphic.frame;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtent2D;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.model.ColorDomain;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class PhysicalDeviceSurfaceManager implements IAllocable, IWindowListener
{
	private Capabilities capabilities;
	private ColorDomains colorDomains;

	private ColorDomain requiredColorDomain;

	private Extent2D extent;

	private VkSurface nextSurface;
	private VkSurface currentSurface;

	private boolean dirty = false;
	private final VkPhysicalDevice physicalDevice;
	private final GraphicContext context;

	public PhysicalDeviceSurfaceManager(GraphicContext context)
	{
		this.context = context;
		final var logicalDevice = context.logicalDevice;
		physicalDevice = context.getPhysicalDevice().vkPhysicalDevice;

		loadSurface(logicalDevice.window.getSurface());

		logicalDevice.window.addListener(this);
	}

	private void loadSurface(VkSurface surface)
	{
		this.nextSurface = surface;
		extent = new Extent2D(surface.width, surface.height);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		currentSurface = nextSurface;
		currentSurface.lock();
		capabilities = new Capabilities(physicalDevice, currentSurface);
		colorDomains = new ColorDomains(physicalDevice, currentSurface);

		requiredColorDomain = loadColorDomain();

		dirty = false;
	}

	private ColorDomain loadColorDomain()
	{
		var colorDomain = context.configuration.getColorDomain();
		if (colorDomains.isColorDomainAvaillable(colorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
		}

		return colorDomain;
	}

	@Override
	public void free()
	{
		capabilities.free();
		currentSurface.release();
		currentSurface = null;
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
		return currentSurface;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return dirty;
	}

	@Override
	public void onWindowResize(VkSurface surface)
	{
		loadSurface(surface);
		dirty = true;
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
