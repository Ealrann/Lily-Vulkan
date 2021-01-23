package org.sheepy.lily.vulkan.demo;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.demo.rotating.RotatingSubpassProvider;
import org.sheepy.lily.vulkan.demo.texture.TextureSubpassProvider;
import org.sheepy.lily.vulkan.demo.triangle.TriangleSubpassProvider;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(CameraConstantAdapter.class,
					   TriangleSubpassProvider.class,
					   RotatingSubpassProvider.class,
					   TextureSubpassProvider.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
