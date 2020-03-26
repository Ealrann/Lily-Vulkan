package org.sheepy.lily.vulkan.core.util;

import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

public final class InstanceCountUtil
{
	public static int getInstanceCount(InternalExecutionContext context, EInstanceCount eInstanceCount)
	{
		return switch (eInstanceCount)
				{
					case FIT_TO_SWAP_IMAGE_COUNT -> ((IGraphicContext) context).getSwapChainManager().getImageCount();
					case ONE -> 1;
					case TWO -> 2;
				};
	}
}
