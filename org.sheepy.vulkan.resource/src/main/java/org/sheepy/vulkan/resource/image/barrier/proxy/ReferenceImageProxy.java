package org.sheepy.vulkan.resource.image.barrier.proxy;

import org.sheepy.vulkan.model.resource.ReferenceImageBarrier;

public class ReferenceImageProxy implements IImageProxy
{
	private ReferenceImageBarrier barrier;

	ReferenceImageProxy(ReferenceImageBarrier barrier)
	{
		this.barrier = barrier;
	}

	@Override
	public int getFormat()
	{
		return barrier.getImageFormat();
	}

	@Override
	public int getMipLevels()
	{
		return barrier.getMipLevels();
	}

	@Override
	public long getId()
	{
		return barrier.getImageId();
	}
}
