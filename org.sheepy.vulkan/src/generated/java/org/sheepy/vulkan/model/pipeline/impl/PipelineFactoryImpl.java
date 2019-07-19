/**
 */
package org.sheepy.vulkan.model.pipeline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.pipeline.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipelineFactoryImpl extends EFactoryImpl implements PipelineFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PipelineFactory init()
	{
		try
		{
			PipelineFactory thePipelineFactory = (PipelineFactory)EPackage.Registry.INSTANCE.getEFactory(PipelinePackage.eNS_URI);
			if (thePipelineFactory != null)
			{
				return thePipelineFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PipelineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineFactoryImpl()
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
			case PipelinePackage.PUSH_CONSTANT_RANGE: return createPushConstantRange();
			case PipelinePackage.SPECIALIZATION_CONSTANT: return createSpecializationConstant();
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
	public PushConstantRange createPushConstantRange()
	{
		PushConstantRangeImpl pushConstantRange = new PushConstantRangeImpl();
		return pushConstantRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializationConstant createSpecializationConstant()
	{
		SpecializationConstantImpl specializationConstant = new SpecializationConstantImpl();
		return specializationConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelinePackage getPipelinePackage()
	{
		return (PipelinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PipelinePackage getPackage()
	{
		return PipelinePackage.eINSTANCE;
	}

} //PipelineFactoryImpl
