/**
 */
package org.sheepy.lily.vulkan.model.process.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResourceContainer;

import org.sheepy.lily.vulkan.model.process.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ProcessPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case ProcessPackage.ABSTRACT_PROCESS:
			{
				AbstractProcess abstractProcess = (AbstractProcess)theEObject;
				T1 result = caseAbstractProcess(abstractProcess);
				if (result == null) result = caseIProcess(abstractProcess);
				if (result == null) result = caseIResourceContainer(abstractProcess);
				if (result == null) result = caseLNamedElement(abstractProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_PKG:
			{
				PipelinePkg pipelinePkg = (PipelinePkg)theEObject;
				T1 result = casePipelinePkg(pipelinePkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPIPELINE_TASK:
			{
				IPipelineTask iPipelineTask = (IPipelineTask)theEObject;
				T1 result = caseIPipelineTask(iPipelineTask);
				if (result == null) result = caseLNamedElement(iPipelineTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PIPELINE:
			{
				AbstractPipeline abstractPipeline = (AbstractPipeline)theEObject;
				T1 result = caseAbstractPipeline(abstractPipeline);
				if (result == null) result = caseLNamedElement(abstractPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TASK_PIPELINE:
			{
				TaskPipeline taskPipeline = (TaskPipeline)theEObject;
				T1 result = caseTaskPipeline(taskPipeline);
				if (result == null) result = caseAbstractPipeline(taskPipeline);
				if (result == null) result = caseIResourceContainer(taskPipeline);
				if (result == null) result = caseLNamedElement(taskPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.VK_PIPELINE:
			{
				VkPipeline vkPipeline = (VkPipeline)theEObject;
				T1 result = caseVkPipeline(vkPipeline);
				if (result == null) result = caseTaskPipeline(vkPipeline);
				if (result == null) result = caseAbstractPipeline(vkPipeline);
				if (result == null) result = caseIResourceContainer(vkPipeline);
				if (result == null) result = caseLNamedElement(vkPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TASK_PKG:
			{
				TaskPkg taskPkg = (TaskPkg)theEObject;
				T1 result = caseTaskPkg(taskPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE:
			{
				Pipeline pipeline = (Pipeline)theEObject;
				T1 result = casePipeline(pipeline);
				if (result == null) result = caseTaskPipeline(pipeline);
				if (result == null) result = caseAbstractPipeline(pipeline);
				if (result == null) result = caseIResourceContainer(pipeline);
				if (result == null) result = caseLNamedElement(pipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPOSITE_PIPELINE:
			{
				CompositePipeline compositePipeline = (CompositePipeline)theEObject;
				T1 result = caseCompositePipeline(compositePipeline);
				if (result == null) result = caseAbstractPipeline(compositePipeline);
				if (result == null) result = caseLNamedElement(compositePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_BARRIER:
			{
				PipelineBarrier pipelineBarrier = (PipelineBarrier)theEObject;
				T1 result = casePipelineBarrier(pipelineBarrier);
				if (result == null) result = caseIPipelineTask(pipelineBarrier);
				if (result == null) result = caseLNamedElement(pipelineBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPOSITE_TASK:
			{
				CompositeTask compositeTask = (CompositeTask)theEObject;
				T1 result = caseCompositeTask(compositeTask);
				if (result == null) result = caseIPipelineTask(compositeTask);
				if (result == null) result = caseMaintainable(compositeTask);
				if (result == null) result = caseLNamedElement(compositeTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.BIND_DESCRIPTOR_SETS:
			{
				BindDescriptorSets bindDescriptorSets = (BindDescriptorSets)theEObject;
				T1 result = caseBindDescriptorSets(bindDescriptorSets);
				if (result == null) result = caseIPipelineTask(bindDescriptorSets);
				if (result == null) result = caseLNamedElement(bindDescriptorSets);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PUSH_CONSTANT:
			{
				PushConstant pushConstant = (PushConstant)theEObject;
				T1 result = casePushConstant(pushConstant);
				if (result == null) result = caseIPipelineTask(pushConstant);
				if (result == null) result = caseLNamedElement(pushConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PUSH_CONSTANT_BUFFER:
			{
				PushConstantBuffer pushConstantBuffer = (PushConstantBuffer)theEObject;
				T1 result = casePushConstantBuffer(pushConstantBuffer);
				if (result == null) result = casePushConstant(pushConstantBuffer);
				if (result == null) result = caseIPipelineTask(pushConstantBuffer);
				if (result == null) result = caseLNamedElement(pushConstantBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK:
			{
				FlushTransferBufferTask flushTransferBufferTask = (FlushTransferBufferTask)theEObject;
				T1 result = caseFlushTransferBufferTask(flushTransferBufferTask);
				if (result == null) result = caseIPipelineTask(flushTransferBufferTask);
				if (result == null) result = caseLNamedElement(flushTransferBufferTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COPY_BUFFER_TASK:
			{
				CopyBufferTask copyBufferTask = (CopyBufferTask)theEObject;
				T1 result = caseCopyBufferTask(copyBufferTask);
				if (result == null) result = caseIPipelineTask(copyBufferTask);
				if (result == null) result = caseLNamedElement(copyBufferTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPROCESS_EXTENSION:
			{
				IProcessExtension iProcessExtension = (IProcessExtension)theEObject;
				T1 result = caseIProcessExtension(iProcessExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_EXTENSION_PKG:
			{
				ProcessExtensionPkg processExtensionPkg = (ProcessExtensionPkg)theEObject;
				T1 result = caseProcessExtensionPkg(processExtensionPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_CONFIGURATION:
			{
				ProcessConfiguration processConfiguration = (ProcessConfiguration)theEObject;
				T1 result = caseProcessConfiguration(processConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_EXECUTION_MANAGER:
			{
				ProcessExecutionManager processExecutionManager = (ProcessExecutionManager)theEObject;
				T1 result = caseProcessExecutionManager(processExecutionManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.EXECUTION_RECORDER:
			{
				ExecutionRecorder executionRecorder = (ExecutionRecorder)theEObject;
				T1 result = caseExecutionRecorder(executionRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.FETCH_BUFFER:
			{
				FetchBuffer fetchBuffer = (FetchBuffer)theEObject;
				T1 result = caseFetchBuffer(fetchBuffer);
				if (result == null) result = caseIPipelineTask(fetchBuffer);
				if (result == null) result = caseLNamedElement(fetchBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractProcess(AbstractProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipelinePkg(PipelinePkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPipelineTask(IPipelineTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractPipeline(AbstractPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTaskPipeline(TaskPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vk Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vk Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVkPipeline(VkPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTaskPkg(TaskPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipeline(Pipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositePipeline(CompositePipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipelineBarrier(PipelineBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositeTask(CompositeTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bind Descriptor Sets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bind Descriptor Sets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBindDescriptorSets(BindDescriptorSets object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePushConstant(PushConstant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Constant Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePushConstantBuffer(PushConstantBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flush Transfer Buffer Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flush Transfer Buffer Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFlushTransferBufferTask(FlushTransferBufferTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copy Buffer Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copy Buffer Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCopyBufferTask(CopyBufferTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessExtension(IProcessExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProcessExtensionPkg(ProcessExtensionPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProcessConfiguration(ProcessConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProcessExecutionManager(ProcessExecutionManager object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseExecutionRecorder(ExecutionRecorder object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fetch Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fetch Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFetchBuffer(FetchBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIResourceContainer(IResourceContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcess(IProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Maintainable<T>> T1 caseMaintainable(Maintainable<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //ProcessSwitch
