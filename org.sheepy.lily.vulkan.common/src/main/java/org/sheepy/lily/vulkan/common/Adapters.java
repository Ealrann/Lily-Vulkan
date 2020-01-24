package org.sheepy.lily.vulkan.common;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.common.cadence.RunProcessAdapter;
import org.sheepy.lily.vulkan.common.cadence.WaitProcessIdleAdapter;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	VulkanEngineAdapter.class,
						WaitProcessIdleAdapter.class,
						RunProcessAdapter.class);
	}
}
