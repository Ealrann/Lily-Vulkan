package org.sheepy.lily.vulkan.core.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

public final class InstanceCountUtil
{
	public static int getInstanceCount(ILilyEObject source, EInstanceCount eInstanceCount)
	{
		return switch (eInstanceCount)
				{
					case FIT_TO_SWAP_IMAGE_COUNT -> getSwapImageCount(source);
					case ONE -> 1;
					case TWO -> 2;
				};
	}

	private static int getSwapImageCount(ILilyEObject source)
	{
		final var process = (GraphicProcess) ModelUtil.findParent(source, AbstractProcess.class);
		return process.getConfiguration().getSwapchainConfiguration().adapt(ISwapChainAllocation.class).getImageCount();
	}
}
