package org.sheepy.lily.vulkan.api.nativehelper.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceFormatsKHR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceFormatKHR;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.model.ColorDomain;
import org.sheepy.lily.vulkan.model.enumeration.EColorSpace;
import org.sheepy.lily.vulkan.model.enumeration.EFormat;
import org.sheepy.lily.vulkan.model.impl.ColorDomainImpl;

public class ColorDomains implements Iterable<ColorDomain>
{
	private final List<ColorDomain> colorDomains = new ArrayList<>();
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
		final ColorDomain colorDomain = new ColorDomainImpl();
		colorDomain.setFormat(EFormat.values()[surfaceFormat.format()]);
		colorDomain.setColorSpace(EColorSpace.values()[surfaceFormat.colorSpace()]);
		addColorDomain(colorDomain);
	}

	private void addColorDomain(ColorDomain newDomain)
	{
		colorDomains.add(newDomain);
		setDomains.add(new ColorDomainWithHash(newDomain));
	}

	public boolean contains(ColorDomain colorDomain)
	{
		return setDomains.contains(new ColorDomainWithHash(colorDomain));
	}

	public int size()
	{
		return colorDomains.size();
	}

	public ColorDomain get(int index)
	{
		return colorDomains.get(index);
	}

	@Override
	public Iterator<ColorDomain> iterator()
	{
		return colorDomains.iterator();
	}

	public boolean isColorDomainAvaillable(ColorDomain colorDomain)
	{
		// Best case : the graphic card has no preferences
		if (size() == 1 && get(0).getFormat() == EFormat.UNDEFINED)
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
		private final ColorDomain colorDomain;

		public ColorDomainWithHash(ColorDomain colorDomain)
		{
			this.colorDomain = colorDomain;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(colorDomain.getColorSpace(), colorDomain.getFormat());
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final ColorDomainWithHash other = (ColorDomainWithHash) obj;
			return Objects.equals(colorDomain.getColorSpace(), other.colorDomain.getColorSpace())
					&& Objects.equals(colorDomain.getFormat(), other.colorDomain.getFormat());
		}

	}
}
