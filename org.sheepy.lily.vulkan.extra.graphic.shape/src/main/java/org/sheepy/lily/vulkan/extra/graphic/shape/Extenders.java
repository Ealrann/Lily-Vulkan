package org.sheepy.lily.vulkan.extra.graphic.shape;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcoSphereAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.IcosahedronAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.adapter.SphereAdapter;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(IcosahedronAdapter.class, IcoSphereAdapter.class, SphereAdapter.class);
	}
}
