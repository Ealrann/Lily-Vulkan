/**
 */
package org.sheepy.vulkan.gameoflife.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.gameoflife.model.*;

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
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case VulkanPackage.BOARD_BUFFER: return createBoardBuffer();
			case VulkanPackage.BOARD_IMAGE: return createBoardImage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoardBuffer createBoardBuffer()
	{
		BoardBufferImpl boardBuffer = new BoardBufferImpl();
		return boardBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoardImage createBoardImage()
	{
		BoardImageImpl boardImage = new BoardImageImpl();
		return boardImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public static VulkanPackage getPackage()
	{
		return VulkanPackage.eINSTANCE;
	}

} //VulkanFactoryImpl
