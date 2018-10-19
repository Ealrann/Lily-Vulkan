package org.sheepy.vulkan.resource.imagebarrier.proxy;

import org.sheepy.vulkan.model.ReferenceImageBarrier;

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