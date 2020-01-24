package org.sheepy.lily.vulkan.common.util;

import org.sheepy.lily.vulkan.common.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

public final class InstanceCountUtil
{
	public static int getInstanceCount(	InternalExecutionContext context,
										EInstanceCount eInstanceCount)
	{
		switch (eInstanceCount)
		{
		case FIT_TO_SWAP_IMAGE_COUNT:
			return ((IGraphicContext) context).getSwapChainManager().getImageCount();
		case ONE:
			return 1;
		case TWO:
			return 2;
		}

		return 0;
	}
}
