package org.sheepy.lily.vulkan.common.util;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.model.VulkanEngine;

public class ModelUtil
{
	public static final Application getApplication(EObject eObject)
	{
		while (eObject != null
				&& ApplicationPackage.Literals.APPLICATION.isInstance(eObject) == false)
		{
			eObject = eObject.eContainer();
		}

		return (Application) eObject;
	}

	public static VulkanEngine getEngine(EObject eo)
	{
		while (eo != null)
		{
			if (eo instanceof VulkanEngine)
			{
				return (VulkanEngine) eo;
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
