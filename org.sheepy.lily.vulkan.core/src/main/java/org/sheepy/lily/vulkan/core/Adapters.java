package org.sheepy.lily.vulkan.core;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.core.cadence.RunProcessAdapter;
import org.sheepy.lily.vulkan.core.cadence.WaitProcessIdleAdapter;
import org.sheepy.lily.vulkan.core.engine.VulkanEngineAdapter;
import org.sheepy.lily.vulkan.core.variable.MouseLocationAdapter;

import java.util.List;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(VulkanEngineAdapter.class,
					   WaitProcessIdleAdapter.class,
					   RunProcessAdapter.class,
					   MouseLocationAdapter.class);
	}
}
