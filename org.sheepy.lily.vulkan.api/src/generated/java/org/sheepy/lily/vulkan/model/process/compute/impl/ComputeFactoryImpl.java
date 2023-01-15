/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER: return createComputeExecutionManager();
			case ComputePackage.COMPUTE_EXECUTION_RECORDER: return createComputeExecutionRecorder();
			case ComputePackage.COMPUTE_COMMAND_BUFFER: return createComputeCommandBuffer();
			case ComputePackage.COMPUTE_ACQUIRER: return createComputeAcquirer();
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
	public ComputeExecutionManager createComputeExecutionManager()
	{
		ComputeExecutionManagerImpl computeExecutionManager = new ComputeExecutionManagerImpl();
		return computeExecutionManager;
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
	public ComputeCommandBuffer createComputeCommandBuffer()
	{
		ComputeCommandBufferImpl computeCommandBuffer = new ComputeCommandBufferImpl();
		return computeCommandBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeAcquirer createComputeAcquirer()
	{
		ComputeAcquirerImpl computeAcquirer = new ComputeAcquirerImpl();
		return computeAcquirer;
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
