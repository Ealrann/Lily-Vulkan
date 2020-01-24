package org.sheepy.lily.vulkan.api.util;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

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

	public static int getEnumeratedFlag(List<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (int i = 0; i < enumerates.size(); i++)
		{
			final Enumerator enumerate = enumerates.get(i);
			res |= enumerate.getValue();
		}

		return res;
	}
}
