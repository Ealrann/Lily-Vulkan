package org.sheepy.vulkan.device;

import static org.lwjgl.system.MemoryUtil.memAllocInt;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSurface.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.lwjgl.vulkan.VkSurfaceFormatKHR;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.swapchain.ColorDomain;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.window.Surface;

public class PhysicalDeviceSupportDetails implements IAllocable
{
	private VkPhysicalDevice vkPhysicalDevice;

	private Surface surface;

	private VkSurfaceCapabilitiesKHR capabilities;
	private ColorDomain[] colorDomains;
	private int[] presentModes;

	public PhysicalDeviceSupportDetails(VkPhysicalDevice vkPhysicalDevice)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
	}

	public void load(Surface surface)
	{
		this.surface = surface;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		int err;
		// Capabilities
		capabilities = VkSurfaceCapabilitiesKHR.calloc();
		err = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(vkPhysicalDevice, surface.id, capabilities);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get physical device surface capabilities: "
					+ VulkanUtils.translateVulkanResult(err));
		}

		// Format
		IntBuffer pCount = memAllocInt(1);
		vkGetPhysicalDeviceSurfaceFormatsKHR(vkPhysicalDevice, surface.id, pCount, null);
		if (pCount.get(0) > 0)
		{
			VkSurfaceFormatKHR.Buffer formatBuffer = VkSurfaceFormatKHR.calloc(pCount.get(0));
			vkGetPhysicalDeviceSurfaceFormatsKHR(vkPhysicalDevice, surface.id, pCount,
					formatBuffer);

			colorDomains = new ColorDomain[pCount.get(0)];
			for (int i = 0; i < pCount.get(0); i++)
			{
				VkSurfaceFormatKHR format = formatBuffer.get(i);
				colorDomains[i] = new ColorDomain(format.format(), format.colorSpace());
			}

			formatBuffer.free();
		}

		// Presentation Modes
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(vkPhysicalDevice, surface.id, pCount, null);
		int presentModeCount = pCount.get(0);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to get number of physical device surface presentation modes: "
							+ VulkanUtils.translateVulkanResult(err));
		}

		IntBuffer modes = memAllocInt(presentModeCount);
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(vkPhysicalDevice, surface.id, pCount,
				modes);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get physical device surface presentation modes: "
					+ VulkanUtils.translateVulkanResult(err));
		}

		presentModes = new int[presentModeCount];
		for (int i = 0; i < presentModeCount; i++)
		{
			presentModes[i] = modes.get(i);
		}

		memFree(pCount);
		memFree(modes);
	}

	public boolean isAdequate()
	{
		boolean res = false;

		res = getColorDomains().length != 0 && getPresentModes().length > 0;

		return res;
	}

	public VkSurfaceCapabilitiesKHR getCapabilities()
	{
		return capabilities;
	}

	@Override
	public void free()
	{
		capabilities.free();
	}

	public ColorDomain[] getColorDomains()
	{
		return colorDomains;
	}

	public int[] getPresentModes()
	{
		return presentModes;
	}
}