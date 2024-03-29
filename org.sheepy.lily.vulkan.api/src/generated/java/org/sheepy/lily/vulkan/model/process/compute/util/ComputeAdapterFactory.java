/**
 */
package org.sheepy.lily.vulkan.model.process.compute.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage
 * @generated
 */
public class ComputeAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComputePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ComputePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeSwitch<Adapter> modelSwitch = new ComputeSwitch<>()
		{
			@Override
			public Adapter caseComputeProcess(ComputeProcess object)
			{
				return createComputeProcessAdapter();
			}
			@Override
			public Adapter caseComputePipeline(ComputePipeline object)
			{
				return createComputePipelineAdapter();
			}
			@Override
			public Adapter caseDispatchTask(DispatchTask object)
			{
				return createDispatchTaskAdapter();
			}
			@Override
			public Adapter caseComputeConfiguration(ComputeConfiguration object)
			{
				return createComputeConfigurationAdapter();
			}
			@Override
			public Adapter caseComputeExecutionManager(ComputeExecutionManager object)
			{
				return createComputeExecutionManagerAdapter();
			}
			@Override
			public Adapter caseComputeExecutionRecorder(ComputeExecutionRecorder object)
			{
				return createComputeExecutionRecorderAdapter();
			}
			@Override
			public Adapter caseComputeCommandBuffer(ComputeCommandBuffer object)
			{
				return createComputeCommandBufferAdapter();
			}
			@Override
			public Adapter caseComputeAcquirer(ComputeAcquirer object)
			{
				return createComputeAcquirerAdapter();
			}
			@Override
			public Adapter caseIResourceContainer(IResourceContainer object)
			{
				return createIResourceContainerAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter caseIProcess(IProcess object)
			{
				return createIProcessAdapter();
			}
			@Override
			public Adapter caseAbstractProcess(AbstractProcess object)
			{
				return createAbstractProcessAdapter();
			}
			@Override
			public Adapter caseAbstractPipeline(AbstractPipeline object)
			{
				return createAbstractPipelineAdapter();
			}
			@Override
			public Adapter caseTaskPipeline(TaskPipeline object)
			{
				return createTaskPipelineAdapter();
			}
			@Override
			public Adapter caseVkPipeline(VkPipeline object)
			{
				return createVkPipelineAdapter();
			}
			@Override
			public <T extends Maintainable<T>> Adapter caseMaintainable(Maintainable<T> object)
			{
				return createMaintainableAdapter();
			}
			@Override
			public Adapter caseIPipelineTask(IPipelineTask object)
			{
				return createIPipelineTaskAdapter();
			}
			@Override
			public Adapter caseProcessConfiguration(ProcessConfiguration object)
			{
				return createProcessConfigurationAdapter();
			}
			@Override
			public Adapter caseProcessExecutionManager(ProcessExecutionManager object)
			{
				return createProcessExecutionManagerAdapter();
			}
			@Override
			public Adapter caseExecutionRecorder(ExecutionRecorder object)
			{
				return createExecutionRecorderAdapter();
			}
			@Override
			public Adapter caseICommandBuffer(ICommandBuffer object)
			{
				return createICommandBufferAdapter();
			}
			@Override
			public Adapter caseIExecutionAcquirer(IExecutionAcquirer object)
			{
				return createIExecutionAcquirerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeProcess
	 * @generated
	 */
	public Adapter createComputeProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePipeline
	 * @generated
	 */
	public Adapter createComputePipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask <em>Dispatch Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.DispatchTask
	 * @generated
	 */
	public Adapter createDispatchTaskAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration
	 * @generated
	 */
	public Adapter createComputeConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager <em>Execution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager
	 * @generated
	 */
	public Adapter createComputeExecutionManagerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder <em>Execution Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder
	 * @generated
	 */
	public Adapter createComputeExecutionRecorderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer <em>Command Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer
	 * @generated
	 */
	public Adapter createComputeCommandBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer <em>Acquirer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer
	 * @generated
	 */
	public Adapter createComputeAcquirerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @generated
	 */
	public Adapter createIResourceContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	public Adapter createLNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @generated
	 */
	public Adapter createIProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	public Adapter createAbstractProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline
	 * @generated
	 */
	public Adapter createAbstractPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.TaskPipeline <em>Task Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPipeline
	 * @generated
	 */
	public Adapter createTaskPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.VkPipeline <em>Vk Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline
	 * @generated
	 */
	public Adapter createVkPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.maintainer.Maintainable <em>Maintainable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable
	 * @generated
	 */
	public Adapter createMaintainableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
	 * @generated
	 */
	public Adapter createIPipelineTaskAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.ProcessConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessConfiguration
	 * @generated
	 */
	public Adapter createProcessConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager <em>Execution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager
	 * @generated
	 */
	public Adapter createProcessExecutionManagerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder <em>Execution Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.ExecutionRecorder
	 * @generated
	 */
	public Adapter createExecutionRecorderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.ICommandBuffer <em>ICommand Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.ICommandBuffer
	 * @generated
	 */
	public Adapter createICommandBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IExecutionAcquirer <em>IExecution Acquirer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IExecutionAcquirer
	 * @generated
	 */
	public Adapter createIExecutionAcquirerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ComputeAdapterFactory
