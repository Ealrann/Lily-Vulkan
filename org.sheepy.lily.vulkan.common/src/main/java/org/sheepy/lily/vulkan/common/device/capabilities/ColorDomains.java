package org.sheepy.lily.vulkan.common.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceFormatsKHR;
import static org.lwjgl.vulkan.VK10.VK_FORMAT_UNDEFINED;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceFormatKHR;
import org.sheepy.lily.vulkan.common.window.VkSurface;

public class ColorDomains implements Iterable<VkColorDomain>
{
	private final List<VkColorDomain> colorDomains = new ArrayList<>();
	private final Set<ColorDomainWithHash> setDomains = new HashSet<>();

	public ColorDomains(VkPhysicalDevice device, VkSurface surface)
	{
		final int[] aCount = new int[1];
		vkGetPhysicalDeviceSurfaceFormatsKHR(device, surface.ptr, aCount, null);
		final int count = aCount[0];
		if (count > 0)
		{
			final var formatBuffer = VkSurfaceFormatKHR.calloc(count);
			vkGetPhysicalDeviceSurfaceFormatsKHR(device, surface.ptr, aCount, formatBuffer);
			for (int i = 0; i < count; i++)
			{
				newColorDomain(formatBuffer.get(i));
			}
			formatBuffer.free();
		}
	}

	private void newColorDomain(VkSurfaceFormatKHR surfaceFormat)
	{
		final int format = surfaceFormat.format();
		final int colorSpace = surfaceFormat.colorSpace();
		final VkColorDomain colorDomain = new VkColorDomain(format, colorSpace);

		addColorDomain(colorDomain);
	}

	private void addColorDomain(VkColorDomain newDomain)
	{
		colorDomains.add(newDomain);
		setDomains.add(new ColorDomainWithHash(newDomain));
	}

	public boolean contains(VkColorDomain colorDomain)
	{
		return setDomains.contains(new ColorDomainWithHash(colorDomain));
	}

	public int size()
	{
		return colorDomains.size();
	}

	public VkColorDomain get(int index)
	{
		return colorDomains.get(index);
	}

	@Override
	public Iterator<VkColorDomain> iterator()
	{
		return colorDomains.iterator();
	}

	public boolean isColorDomainAvaillable(VkColorDomain colorDomain)
	{
		// Best case : the graphic card has no preferences
		if (size() == 1 && get(0).format == VK_FORMAT_UNDEFINED)
		{
			return true;
		}
		else if (contains(colorDomain))
		{
			return true;
		}

		return false;
	}

	private static class ColorDomainWithHash
	{
		private final VkColorDomain colorDomain;

		public ColorDomainWithHash(VkColorDomain colorDomain)
		{
			this.colorDomain = colorDomain;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(colorDomain.colorSpace, colorDomain.format);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final ColorDomainWithHash other = (ColorDomainWithHash) obj;
			return Objects.equals(colorDomain.colorSpace, other.colorDomain.colorSpace)
					&& Objects.equals(colorDomain.format, other.colorDomain.format);
		}

	}
}
