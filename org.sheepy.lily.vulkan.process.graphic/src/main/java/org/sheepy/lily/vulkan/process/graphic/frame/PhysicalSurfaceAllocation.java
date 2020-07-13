package org.sheepy.lily.vulkan.process.graphic.frame;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.graphic.IPhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.api.graphic.VkColorDomain;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.core.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.core.window.VkSurface.ISurfaceListener;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = PhysicalSurface.class)
@Allocation(context = ProcessContext.class)
public final class PhysicalSurfaceAllocation implements IPhysicalSurfaceAllocation, IExtender
{
	private final ISurfaceListener dirtyListener = this::setDirty;
	private final VkColorDomain colorDomain;
	private final Vector2ic extent;
	private final Capabilities capabilities;
	private final VulkanQueue presentQueue;
	private final VkSurface surface;
	private final IAllocationState allocationConfigurator;
	private final LogicalDevice logicalDevice;

	private PhysicalSurfaceAllocation(PhysicalSurface physicalSurface,
									  IAllocationState allocationConfigurator,
									  ProcessContext context)
	{
		this.allocationConfigurator = allocationConfigurator;
		logicalDevice = context.getLogicalDevice();
		final var vkPhysicalDevice = context.getVkPhysicalDevice();
		final var vkInstance = context.getVkInstance();
		final var window = context.getWindow();
		surface = window.createSurface(vkInstance);
		surface.addListener(dirtyListener);

		presentQueue = logicalDevice.borrowPresentQueue(surface);
		window.listenNoParam(dirtyListener, IWindow.Features.Size);
		window.listen(dirtyListener, IWindow.Features.SurfaceDeprecated);

		capabilities = new Capabilities(vkPhysicalDevice, surface);
		extent = computeExtent(window);
		colorDomain = loadColorDomain(vkPhysicalDevice, physicalSurface.getColorDomain());

		System.out.println("ALLOC surface = " + surface.ptr);
	}

	private Vector2ic computeExtent(Window window)
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

	@Free
	public void free(ProcessContext context)
	{
		System.out.println("FREE surface = " + surface.ptr);
		final var window = context.getWindow();

		window.sulkNoParam(dirtyListener, IWindow.Features.Size);
		window.sulk(dirtyListener, IWindow.Features.SurfaceDeprecated);
		surface.removeListener(dirtyListener);

		capabilities.free();
		surface.free();
	}

	private VkColorDomain loadColorDomain(VkPhysicalDevice device, ColorDomain colorDomain)
	{
		final var colorDomains = new ColorDomains(device, surface);
		final var vkColorDomain = new VkColorDomain(colorDomain.getFormat().getValue(),
													colorDomain.getColorSpace().getValue());

		if (colorDomains.isColorDomainAvaillable(vkColorDomain) == false)
		{
			Logger.log("The desired ColorDomain is not availlable");
			return colorDomains.get(0);
		}
		else
		{
			return vkColorDomain;
		}
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
	public VkColorDomain getColorDomain()
	{
		return colorDomain;
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
	public void setDirty()
	{
		allocationConfigurator.setAllocationObsolete();
		logicalDevice.returnQueue(presentQueue);
		// Some driver will refuse to alloc a new swapchain while the current one is in use.
		logicalDevice.waitIdle();
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
