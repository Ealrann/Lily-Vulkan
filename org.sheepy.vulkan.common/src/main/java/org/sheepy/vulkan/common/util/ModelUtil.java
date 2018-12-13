package org.sheepy.vulkan.common.util;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.ApplicationPackage;

public class ModelUtil
{
	public static final Application getVulkanApplication(EObject eObject)
	{
		while (eObject != null && eObject.eClass() != ApplicationPackage.Literals.APPLICATION)
		{
			eObject = eObject.eContainer();
		}

		return (Application) eObject;
	}

}
