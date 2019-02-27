/**
 */
package org.sheepy.lily.vulkan.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VulkanFactoryImpl extends EFactoryImpl implements VulkanFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VulkanFactory init()
	{
		try
		{
			VulkanFactory theVulkanFactory = (VulkanFactory) EPackage.Registry.INSTANCE
					.getEFactory(VulkanPackage.eNS_URI);
			if (theVulkanFactory != null)
			{
				return theVulkanFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VulkanFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
		case VulkanPackage.VULKAN_ENGINE:
			return createVulkanEngine();
		case VulkanPackage.RESOURCE_PKG:
			return createResourcePkg();
		case VulkanPackage.COLOR_DOMAIN:
			return createColorDomain();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanEngine createVulkanEngine()
	{
		VulkanEngineImpl vulkanEngine = new VulkanEngineImpl();
		return vulkanEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg createResourcePkg()
	{
		ResourcePkgImpl resourcePkg = new ResourcePkgImpl();
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorDomain createColorDomain()
	{
		ColorDomainImpl colorDomain = new ColorDomainImpl();
		return colorDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanPackage getVulkanPackage()
	{
		return (VulkanPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VulkanPackage getPackage()
	{
		return VulkanPackage.eINSTANCE;
	}

} //VulkanFactoryImpl
