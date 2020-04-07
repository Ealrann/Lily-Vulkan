package org.sheepy.lily.vulkan.api.device;

import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.util.Set;

public interface IPhysicalDevice
{
	Set<EImageUsage> supportedSwapUsages();
}
