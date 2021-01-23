package org.sheepy.lily.vulkan.extra.graphic.shape;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcoSphereAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcosahedronAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.SphereAdapter;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(IcosahedronAdapter.class, IcoSphereAdapter.class, SphereAdapter.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
