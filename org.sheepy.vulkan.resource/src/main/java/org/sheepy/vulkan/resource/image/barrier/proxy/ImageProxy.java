package org.sheepy.vulkan.resource.image.barrier.proxy;

import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.resource.image.IImageAdapter;

public class ImageProxy implements IImageProxy
{
	private final ImageBarrier barrier;

	ImageProxy(ImageBarrier barrier)
	{
		this.barrier = barrier;
	}

	@Override
	public int getFormat()
	{
		var adapter = IImageAdapter.adapt(barrier.getImage());
		return adapter.getFormat();
	}

	@Override
	public int getMipLevels()
	{
		var adapter = IImageAdapter.adapt(barrier.getImage());
		return adapter.getMipLevels();
	}

	@Override
	public long getId()
	{
		var adapter = IImageAdapter.adapt(barrier.getImage());
		return adapter.getId();
	}

}