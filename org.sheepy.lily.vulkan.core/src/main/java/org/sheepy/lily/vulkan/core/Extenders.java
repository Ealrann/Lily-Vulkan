package org.sheepy.lily.vulkan.core;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.core.cadence.RunProcessAdapter;
import org.sheepy.lily.vulkan.core.cadence.WaitProcessIdleAdapter;
import org.sheepy.lily.vulkan.core.engine.VulkanEngineAllocation;
import org.sheepy.lily.vulkan.core.input.VulkanInputManager;
import org.sheepy.lily.vulkan.core.variable.MouseLocationAdapter;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(VulkanEngineAllocation.class,
					   WaitProcessIdleAdapter.class,
					   RunProcessAdapter.class,
					   MouseLocationAdapter.class,
					   VulkanInputManager.class);
	}
}
