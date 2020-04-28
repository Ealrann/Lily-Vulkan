package org.sheepy.lily.vulkan.extra.graphic.shape;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcoSphereAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcosahedronAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.SphereAdapter;

public class Adapters implements IExtenderProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(IcosahedronAdapter.class, IcoSphereAdapter.class, SphereAdapter.class);
	}
}
