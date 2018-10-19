/**
 */
package org.sheepy.vulkan.demo.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.demo.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VulkanDemoFactoryImpl extends EFactoryImpl implements VulkanDemoFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VulkanDemoFactory init()
	{
		try
		{
			VulkanDemoFactory theVulkanDemoFactory = (VulkanDemoFactory)EPackage.Registry.INSTANCE.getEFactory(VulkanDemoPackage.eNS_URI);
			if (theVulkanDemoFactory != null)
			{
				return theVulkanDemoFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VulkanDemoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanDemoFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case VulkanDemoPackage.MESH_PIPELINE: return createMeshPipeline();
			case VulkanDemoPackage.MESH_BUFFER: return createMeshBuffer();
			case VulkanDemoPackage.UNIFORM_BUFFER: return createUniformBuffer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshPipeline createMeshPipeline()
	{
		MeshPipelineImpl meshPipeline = new MeshPipelineImpl();
		return meshPipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshBuffer createMeshBuffer()
	{
		MeshBufferImpl meshBuffer = new MeshBufferImpl();
		return meshBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniformBuffer createUniformBuffer()
	{
		UniformBufferImpl uniformBuffer = new UniformBufferImpl();
		return uniformBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanDemoPackage getVulkanDemoPackage()
	{
		return (VulkanDemoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static VulkanDemoPackage getPackage()
	{
		return VulkanDemoPackage.eINSTANCE;
	}

} //VulkanDemoFactoryImpl
