package org.sheepy.lily.vulkan.resource.barrier.proxy;

import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.resource.image.ImageAdapter;

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
		return barrier.getImage().getFormat().getValue();
	}

	@Override
	public int getMipLevels()
	{
		return barrier.getImage().getMipLevels();
	}

	@Override
	public long getId()
	{
		var adapter = ImageAdapter.adapt(barrier.getImage());
		return adapter.getId();
	}

}
