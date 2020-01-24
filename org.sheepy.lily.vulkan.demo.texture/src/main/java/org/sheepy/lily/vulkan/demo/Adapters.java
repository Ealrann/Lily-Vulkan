package org.sheepy.lily.vulkan.demo;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.demo.rotating.RotatingSubpassProvider;
import org.sheepy.lily.vulkan.demo.texture.TextureSubpassProvider;
import org.sheepy.lily.vulkan.demo.triangle.TriangleSubpassProvider;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	CameraConstantAdapter.class,
						TriangleSubpassProvider.class,
						RotatingSubpassProvider.class,
						TextureSubpassProvider.class);
	}
}
