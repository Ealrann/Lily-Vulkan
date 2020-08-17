package org.sheepy.lily.vulkan.core.debug;

import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;

import java.util.HashMap;
import java.util.Map;

public final class VulkanDebugService implements IVulkanDebugService
{
	private final Map<Long, String> map = new HashMap<>();

	@Override
	public void register(final long ptr, final String name)
	{
		map.put(ptr, name);
	}

	@Override
	public void remove(final long ptr)
	{
		map.remove(ptr);
	}

	@Override
	public String get(final long ptr)
	{
		return map.get(ptr);
	}
}
