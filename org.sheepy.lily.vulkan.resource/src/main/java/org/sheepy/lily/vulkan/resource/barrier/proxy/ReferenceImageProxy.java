package org.sheepy.lily.vulkan.resource.barrier.proxy;

import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;

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
