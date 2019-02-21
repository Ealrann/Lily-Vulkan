/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.process.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessFactoryImpl extends EFactoryImpl implements ProcessFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessFactory init()
	{
		try
		{
			ProcessFactory theProcessFactory = (ProcessFactory)EPackage.Registry.INSTANCE.getEFactory(ProcessPackage.eNS_URI);
			if (theProcessFactory != null)
			{
				return theProcessFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcessFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessFactoryImpl()
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
			case ProcessPackage.PROCESS_SEMAPHORE: return createProcessSemaphore();
			case ProcessPackage.PIPELINE_BARRIER: return createPipelineBarrier();
			case ProcessPackage.PUSH_CONSTANT: return createPushConstant();
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
	public ProcessSemaphore createProcessSemaphore()
	{
		ProcessSemaphoreImpl processSemaphore = new ProcessSemaphoreImpl();
		return processSemaphore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineBarrier createPipelineBarrier()
	{
		PipelineBarrierImpl pipelineBarrier = new PipelineBarrierImpl();
		return pipelineBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushConstant createPushConstant()
	{
		PushConstantImpl pushConstant = new PushConstantImpl();
		return pushConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessPackage getProcessPackage()
	{
		return (ProcessPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcessPackage getPackage()
	{
		return ProcessPackage.eINSTANCE;
	}

} //ProcessFactoryImpl