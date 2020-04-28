package org.sheepy.lily.vulkan.demo.test.composite;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(TestDataProviderAdapter.class, InstanceDataProviderAdapter.class);
	}
}
