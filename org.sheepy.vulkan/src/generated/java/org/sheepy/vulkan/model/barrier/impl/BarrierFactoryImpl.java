/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.barrier.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BarrierFactoryImpl extends EFactoryImpl implements BarrierFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BarrierFactory init()
	{
		try
		{
			BarrierFactory theBarrierFactory = (BarrierFactory)EPackage.Registry.INSTANCE.getEFactory(BarrierPackage.eNS_URI);
			if (theBarrierFactory != null)
			{
				return theBarrierFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BarrierFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BarrierFactoryImpl()
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
			case BarrierPackage.REFERENCE_BUFFER_BARRIER: return createReferenceBufferBarrier();
			case BarrierPackage.REFERENCE_IMAGE_BARRIER: return createReferenceImageBarrier();
			case BarrierPackage.IMAGE_TRANSITION: return createImageTransition();
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
	public ReferenceBufferBarrier createReferenceBufferBarrier()
	{
		ReferenceBufferBarrierImpl referenceBufferBarrier = new ReferenceBufferBarrierImpl();
		return referenceBufferBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceImageBarrier createReferenceImageBarrier()
	{
		ReferenceImageBarrierImpl referenceImageBarrier = new ReferenceImageBarrierImpl();
		return referenceImageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageTransition createImageTransition()
	{
		ImageTransitionImpl imageTransition = new ImageTransitionImpl();
		return imageTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BarrierPackage getBarrierPackage()
	{
		return (BarrierPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BarrierPackage getPackage()
	{
		return BarrierPackage.eINSTANCE;
	}

} //BarrierFactoryImpl
