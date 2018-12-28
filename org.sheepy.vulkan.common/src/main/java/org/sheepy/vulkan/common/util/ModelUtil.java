package org.sheepy.vulkan.common.util;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.ApplicationPackage;

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

}
