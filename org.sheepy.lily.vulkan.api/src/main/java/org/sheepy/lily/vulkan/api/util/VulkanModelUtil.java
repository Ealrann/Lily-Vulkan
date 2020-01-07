package org.sheepy.lily.vulkan.api.util;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

public final class VulkanModelUtil
{
	public static VulkanEngine getEngine(EObject eo)
	{
		return getParent(eo, VulkanEngine.class);
	}

	public static GraphicProcess getGraphicProcess(EObject eo)
	{
		return getParent(eo, GraphicProcess.class);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Object> T getParent(EObject eo, Class<T> classifier)
	{
		while (eo != null)
		{
			if (classifier.isInstance(eo))
			{
				return (T) eo;
			}
			else
			{
				eo = eo.eContainer();
			}
		}
		return null;
	}

	public static int getInstanceCount(IExecutionContext context, EInstanceCount eInstanceCount)
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
