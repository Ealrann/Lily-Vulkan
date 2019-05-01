package org.sheepy.lily.vulkan.resource.barrier;

import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.resource.barrier.IBarrierExecutor;

public class BarrierExecutorFactory
{
	public static IBarrierExecutor create(Barrier barrier)
	{
		IBarrierExecutor res = null;

		switch (barrier.eClass().getClassifierID())
		{
		case ResourcePackage.BUFFER_BARRIER:
			res = new BufferBarrierExecutor((BufferBarrier) barrier);
			break;
		case ResourcePackage.IMAGE_BARRIER:
		case BarrierPackage.REFERENCE_IMAGE_BARRIER:
			res = new ImageBarrierExecutor((AbstractImageBarrier) barrier);
			break;
		default:
			System.err.println("Unknown barrier");
		}

		return res;
	}
}
