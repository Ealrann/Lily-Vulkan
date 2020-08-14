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
			VulkanFactory theVulkanFactory = (VulkanFactory)EPackage.Registry.INSTANCE.getEFactory(VulkanPackage.eNS_URI);
			if (theVulkanFactory != null)
			{
				return theVulkanFactory;
			}
		}
		catch (Exception exception)
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
			case VulkanPackage.VULKAN_ENGINE: return createVulkanEngine();
			case VulkanPackage.VULKAN_RESOURCE_PKG: return createVulkanResourcePkg();
			case VulkanPackage.RUN_PROCESS: return createRunProcess();
			case VulkanPackage.WAIT_PROCESS_IDLE: return createWaitProcessIdle();
			case VulkanPackage.DESCRIPTOR_PKG: return createDescriptorPkg();
			case VulkanPackage.MOUSE_LOCATION: return createMouseLocation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public VulkanResourcePkg createVulkanResourcePkg()
	{
		VulkanResourcePkgImpl vulkanResourcePkg = new VulkanResourcePkgImpl();
		return vulkanResourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RunProcess createRunProcess()
	{
		RunProcessImpl runProcess = new RunProcessImpl();
		return runProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WaitProcessIdle createWaitProcessIdle()
	{
		WaitProcessIdleImpl waitProcessIdle = new WaitProcessIdleImpl();
		return waitProcessIdle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorPkg createDescriptorPkg()
	{
		DescriptorPkgImpl descriptorPkg = new DescriptorPkgImpl();
		return descriptorPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MouseLocation createMouseLocation()
	{
		MouseLocationImpl mouseLocation = new MouseLocationImpl();
		return mouseLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanPackage getVulkanPackage()
	{
		return (VulkanPackage)getEPackage();
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
