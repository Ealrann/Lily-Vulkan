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
			case ProcessPackage.PROCESS_PART_PKG: return (EObject)createProcessPartPkg();
			case ProcessPackage.TASK_PKG: return (EObject)createTaskPkg();
			case ProcessPackage.PIPELINE: return (EObject)createPipeline();
			case ProcessPackage.PIPELINE_BARRIER: return (EObject)createPipelineBarrier();
			case ProcessPackage.COMPOSITE_TASK: return (EObject)createCompositeTask();
			case ProcessPackage.BIND_DESCRIPTOR_SETS: return (EObject)createBindDescriptorSets();
			case ProcessPackage.PUSH_CONSTANT_BUFFER: return (EObject)createPushConstantBuffer();
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK: return (EObject)createFlushTransferBufferTask();
			case ProcessPackage.COPY_BUFFER_TASK: return (EObject)createCopyBufferTask();
			case ProcessPackage.PROCESS_EXTENSION_PKG: return (EObject)createProcessExtensionPkg();
			case ProcessPackage.PREPARE_COMPOSITE_TRANSFER: return (EObject)createPrepareCompositeTransfer();
			case ProcessPackage.SWAP_BINDINGS_TASK: return (EObject)createSwapBindingsTask();
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
	public ProcessPartPkg createProcessPartPkg()
	{
		ProcessPartPkgImpl processPartPkg = new ProcessPartPkgImpl();
		return processPartPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TaskPkg createTaskPkg()
	{
		TaskPkgImpl taskPkg = new TaskPkgImpl();
		return taskPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pipeline createPipeline()
	{
		PipelineImpl pipeline = new PipelineImpl();
		return pipeline;
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
	public CompositeTask createCompositeTask()
	{
		CompositeTaskImpl compositeTask = new CompositeTaskImpl();
		return compositeTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindDescriptorSets createBindDescriptorSets()
	{
		BindDescriptorSetsImpl bindDescriptorSets = new BindDescriptorSetsImpl();
		return bindDescriptorSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushConstantBuffer createPushConstantBuffer()
	{
		PushConstantBufferImpl pushConstantBuffer = new PushConstantBufferImpl();
		return pushConstantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlushTransferBufferTask createFlushTransferBufferTask()
	{
		FlushTransferBufferTaskImpl flushTransferBufferTask = new FlushTransferBufferTaskImpl();
		return flushTransferBufferTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CopyBufferTask createCopyBufferTask()
	{
		CopyBufferTaskImpl copyBufferTask = new CopyBufferTaskImpl();
		return copyBufferTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessExtensionPkg createProcessExtensionPkg()
	{
		ProcessExtensionPkgImpl processExtensionPkg = new ProcessExtensionPkgImpl();
		return processExtensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrepareCompositeTransfer createPrepareCompositeTransfer()
	{
		PrepareCompositeTransferImpl prepareCompositeTransfer = new PrepareCompositeTransferImpl();
		return prepareCompositeTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapBindingsTask createSwapBindingsTask()
	{
		SwapBindingsTaskImpl swapBindingsTask = new SwapBindingsTaskImpl();
		return swapBindingsTask;
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
