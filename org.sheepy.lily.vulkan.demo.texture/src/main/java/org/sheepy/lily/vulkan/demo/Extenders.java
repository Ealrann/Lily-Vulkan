package org.sheepy.lily.vulkan.demo;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.demo.rotating.RotatingSubpassProvider;
import org.sheepy.lily.vulkan.demo.texture.TextureSubpassProvider;
import org.sheepy.lily.vulkan.demo.triangle.TriangleSubpassProvider;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
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
