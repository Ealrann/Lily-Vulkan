/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.process.compute.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputeFactoryImpl extends EFactoryImpl implements ComputeFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComputeFactory init()
	{
		try
		{
			ComputeFactory theComputeFactory = (ComputeFactory)EPackage.Registry.INSTANCE.getEFactory(ComputePackage.eNS_URI);
			if (theComputeFactory != null)
			{
				return theComputeFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeFactoryImpl()
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
			case ComputePackage.COMPUTE_PROCESS: return createComputeProcess();
			case ComputePackage.COMPUTE_PIPELINE: return createComputePipeline();
			case ComputePackage.DISPATCH_TASK: return createDispatchTask();
			case ComputePackage.COMPUTE_CONFIGURATION: return createComputeConfiguration();
			case ComputePackage.COMPUTE_EXECUTION_RECORDER: return createComputeExecutionRecorder();
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
	public ComputeProcess createComputeProcess()
	{
		ComputeProcessImpl computeProcess = new ComputeProcessImpl();
		return computeProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputePipeline createComputePipeline()
	{
		ComputePipelineImpl computePipeline = new ComputePipelineImpl();
		return computePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchTask createDispatchTask()
	{
		DispatchTaskImpl dispatchTask = new DispatchTaskImpl();
		return dispatchTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeConfiguration createComputeConfiguration()
	{
		ComputeConfigurationImpl computeConfiguration = new ComputeConfigurationImpl();
		return computeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeExecutionRecorder createComputeExecutionRecorder()
	{
		ComputeExecutionRecorderImpl computeExecutionRecorder = new ComputeExecutionRecorderImpl();
		return computeExecutionRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputePackage getComputePackage()
	{
		return (ComputePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputePackage getPackage()
	{
		return ComputePackage.eINSTANCE;
	}

} //ComputeFactoryImpl
