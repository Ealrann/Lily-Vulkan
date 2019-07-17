/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.model.nuklear.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuklearFactoryImpl extends EFactoryImpl implements NuklearFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NuklearFactory init()
	{
		try
		{
			NuklearFactory theNuklearFactory = (NuklearFactory)EPackage.Registry.INSTANCE.getEFactory(NuklearPackage.eNS_URI);
			if (theNuklearFactory != null)
			{
				return theNuklearFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NuklearFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFactoryImpl()
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS: return createNuklearPushConstants();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK: return createNuklearLayoutTask();
			case NuklearPackage.NUKLEAR_CONTEXT: return createNuklearContext();
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
	public NuklearPushConstants createNuklearPushConstants()
	{
		NuklearPushConstantsImpl nuklearPushConstants = new NuklearPushConstantsImpl();
		return nuklearPushConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearLayoutTask createNuklearLayoutTask()
	{
		NuklearLayoutTaskImpl nuklearLayoutTask = new NuklearLayoutTaskImpl();
		return nuklearLayoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearContext createNuklearContext()
	{
		NuklearContextImpl nuklearContext = new NuklearContextImpl();
		return nuklearContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearPackage getNuklearPackage()
	{
		return (NuklearPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NuklearPackage getPackage()
	{
		return NuklearPackage.eINSTANCE;
	}

} //NuklearFactoryImpl
