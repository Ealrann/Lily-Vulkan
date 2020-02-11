package org.sheepy.lily.vulkan.api.util;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

import java.util.Collection;

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
	private static <T> T getParent(EObject eo, Class<T> classifier)
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

	public static int getEnumeratedFlag(Collection<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (var enumeration : enumerates)
		{
			res |= enumeration.getValue();
		}

		return res;
	}
}
