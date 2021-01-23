package org.sheepy.lily.vulkan.core;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.core.cadence.RunProcessAdapter;
import org.sheepy.lily.vulkan.core.cadence.WaitProcessIdleAdapter;
import org.sheepy.lily.vulkan.core.engine.VulkanEngineAllocation;
import org.sheepy.lily.vulkan.core.input.VulkanInputManager;
import org.sheepy.lily.vulkan.core.variable.MouseLocationAdapter;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(VulkanEngineAllocation.class,
					   WaitProcessIdleAdapter.class,
					   RunProcessAdapter.class,
					   MouseLocationAdapter.class,
					   VulkanInputManager.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
