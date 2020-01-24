package org.sheepy.lily.vulkan.demo.test.composite;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(TestDataProviderAdapter.class, InstanceDataProviderAdapter.class);
	}
}
