package org.sheepy.vulkan.resource.imagebarrier.proxy;

import org.sheepy.vulkan.model.process.AbstractImageBarrier;
import org.sheepy.vulkan.model.process.ImageBarrier;
import org.sheepy.vulkan.model.process.ReferenceImageBarrier;

public interface IImageProxy
{
	int getFormat();

	int getMipLevels();

	long getId();

	static IImageProxy newProxy(AbstractImageBarrier barrier)
	{
		if (barrier instanceof ImageBarrier)
		{
			return new ImageProxy((ImageBarrier) barrier);
		}
		else if (barrier instanceof ReferenceImageBarrier)
		{
			return new ReferenceImageProxy((ReferenceImageBarrier) barrier);
		}
		return null;
	}
}
