package org.sheepy.lily.vulkan.process.graphic.frame.util;

import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

import java.util.List;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfacePresentModesKHR;

public class PresentationModeSelector
{
	private static final String FAILED_GET_MODES = "Failed to get physical device surface presentation modes";
	private static final String FAILED_COUNT_MODES = "Failed to get count of physical device surface presentation modes";

	private final List<EPresentMode> presentModeRanks;

	public PresentationModeSelector(SwapchainConfiguration configuration)
	{
		final var presentWhenVBlank = configuration.isPresentWhenVBlank();
		final var acquireWaitForVBlank = configuration.isAcquireWaitForVBlank();

		if (acquireWaitForVBlank)
		{
			if (presentWhenVBlank)
			{
				presentModeRanks = List.of(EPresentMode.FIFO,
										   EPresentMode.FIFO_RELAXED,
										   EPresentMode.MAIL_BOX,
										   EPresentMode.IMMEDIATE);
			}
			else
			{
				presentModeRanks = List.of(EPresentMode.FIFO_RELAXED,
										   EPresentMode.FIFO,
										   EPresentMode.IMMEDIATE,
										   EPresentMode.MAIL_BOX);
			}
		}
		else
		{
			if (presentWhenVBlank)
			{
				presentModeRanks = List.of(EPresentMode.MAIL_BOX,
										   EPresentMode.IMMEDIATE,
										   EPresentMode.FIFO,
										   EPresentMode.FIFO_RELAXED);
			}
			else
			{
				presentModeRanks = List.of(EPresentMode.IMMEDIATE,
										   EPresentMode.MAIL_BOX,
										   EPresentMode.FIFO_RELAXED,
										   EPresentMode.FIFO);
			}
		}
	}

	public EPresentMode findBestMode(ProcessContext context, VkSurface surface)
	{
		final var device = context.getVkPhysicalDevice();
		final var stack = context.stack();

		final var pPresentModeCount = stack.mallocInt(1);
		Logger.check(vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.ptr, pPresentModeCount, null),
					 FAILED_COUNT_MODES);

		final int presentModeCount = pPresentModeCount.get(0);
		final var pPresentModes = stack.mallocInt(presentModeCount);
		Logger.check(vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.ptr, pPresentModeCount, pPresentModes),
					 FAILED_GET_MODES);

		EPresentMode swapchainPresentMode = EPresentMode.FIFO;
		int rankFound = Integer.MAX_VALUE;
		for (int i = 0; i < presentModeCount; i++)
		{
			final int modeValue = pPresentModes.get(i);
			final var mode = EPresentMode.get(modeValue);
			final var rank = presentModeRanks.indexOf(mode);

			if (rank < rankFound)
			{
				rankFound = rank;
				swapchainPresentMode = mode;
			}
		}

		return swapchainPresentMode;
	}
}
