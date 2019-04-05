package org.sheepy.lily.vulkan.common.util;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public class VulkanModelUtil extends ModelUtil
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

	public static final int getEnumeratedFlag(List<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (final Enumerator enumerate : enumerates)
		{
			res |= enumerate.getValue();
		}

		return res;
	}
}
