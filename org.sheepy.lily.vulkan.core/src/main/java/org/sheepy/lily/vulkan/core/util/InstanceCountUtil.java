package org.sheepy.lily.vulkan.core.util;

import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

public final class InstanceCountUtil
{
	private InstanceCountUtil()
	{
	}

	public static int getInstanceCount(final LMObject source, final EInstanceCount instanceCount)
	{
		return switch (instanceCount)
				{
					case FIT_TO_SWAP_IMAGE_COUNT -> getSwapImageCount(source);
					case ONE -> 1;
					case TWO -> 2;
				};
	}

	private static int getSwapImageCount(final LMObject source)
	{
		final var process = (GraphicProcess) ModelUtil.findParent(source, AbstractProcess.class);
		return process.configuration()
					  .swapchainConfiguration()
					  .adapt(ISwapChainAllocation.class)
					  .getImageCount();
	}
}
