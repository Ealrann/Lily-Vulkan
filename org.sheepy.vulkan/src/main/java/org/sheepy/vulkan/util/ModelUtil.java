package org.sheepy.vulkan.util;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;

public class ModelUtil
{
	public static final VulkanApplication getVulkanApplication(EObject eObject)
	{
		while (eObject != null && eObject.eClass() != VulkanPackage.Literals.VULKAN_APPLICATION)
		{
			eObject = eObject.eContainer();
		}

		return (VulkanApplication) eObject;
	}

}
