/**
 */
package org.sheepy.vulkan.model.process.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.common.model.inference.IInferenceObject;
import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.types.LNamedElement;
import org.sheepy.vulkan.model.IEnginePart;
import org.sheepy.vulkan.model.IProcess;

import org.sheepy.vulkan.model.process.*;

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
 * @see org.sheepy.vulkan.model.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T> extends Switch<T>
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
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case ProcessPackage.ABSTRACT_PROCESS:
			{
				AbstractProcess abstractProcess = (AbstractProcess)theEObject;
				T result = caseAbstractProcess(abstractProcess);
				if (result == null) result = caseIProcess(abstractProcess);
				if (result == null) result = caseIEnginePart(abstractProcess);
				if (result == null) result = caseLNamedElement(abstractProcess);
				if (result == null) result = caseLObject(abstractProcess);
				if (result == null) result = caseIInferenceObject(abstractProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_SEMAPHORE:
			{
				ProcessSemaphore processSemaphore = (ProcessSemaphore)theEObject;
				T result = caseProcessSemaphore(processSemaphore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPROCESS_UNIT:
			{
				IProcessUnit iProcessUnit = (IProcessUnit)theEObject;
				T result = caseIProcessUnit(iProcessUnit);
				if (result == null) result = caseLObject(iProcessUnit);
				if (result == null) result = caseIInferenceObject(iProcessUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.CONFIGURATION:
			{
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_BARRIER:
			{
				PipelineBarrier pipelineBarrier = (PipelineBarrier)theEObject;
				T result = casePipelineBarrier(pipelineBarrier);
				if (result == null) result = caseIProcessUnit(pipelineBarrier);
				if (result == null) result = caseIPipelineUnit(pipelineBarrier);
				if (result == null) result = caseLObject(pipelineBarrier);
				if (result == null) result = caseLNamedElement(pipelineBarrier);
				if (result == null) result = caseIInferenceObject(pipelineBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPIPELINE:
			{
				IPipeline iPipeline = (IPipeline)theEObject;
				T result = caseIPipeline(iPipeline);
				if (result == null) result = caseIProcessUnit(iPipeline);
				if (result == null) result = caseLNamedElement(iPipeline);
				if (result == null) result = caseLObject(iPipeline);
				if (result == null) result = caseIInferenceObject(iPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PIPELINE:
			{
				AbstractPipeline abstractPipeline = (AbstractPipeline)theEObject;
				T result = caseAbstractPipeline(abstractPipeline);
				if (result == null) result = caseIPipeline(abstractPipeline);
				if (result == null) result = caseIProcessUnit(abstractPipeline);
				if (result == null) result = caseLNamedElement(abstractPipeline);
				if (result == null) result = caseLObject(abstractPipeline);
				if (result == null) result = caseIInferenceObject(abstractPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPIPELINE_UNIT:
			{
				IPipelineUnit iPipelineUnit = (IPipelineUnit)theEObject;
				T result = caseIPipelineUnit(iPipelineUnit);
				if (result == null) result = caseLNamedElement(iPipelineUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_COMPOSITE_PIPELINE:
			{
				AbstractCompositePipeline abstractCompositePipeline = (AbstractCompositePipeline)theEObject;
				T result = caseAbstractCompositePipeline(abstractCompositePipeline);
				if (result == null) result = caseAbstractPipeline(abstractCompositePipeline);
				if (result == null) result = caseIPipeline(abstractCompositePipeline);
				if (result == null) result = caseIProcessUnit(abstractCompositePipeline);
				if (result == null) result = caseLNamedElement(abstractCompositePipeline);
				if (result == null) result = caseLObject(abstractCompositePipeline);
				if (result == null) result = caseIInferenceObject(abstractCompositePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PUSH_CONSTANT:
			{
				PushConstant pushConstant = (PushConstant)theEObject;
				T result = casePushConstant(pushConstant);
				if (result == null) result = caseIPipelineUnit(pushConstant);
				if (result == null) result = caseLNamedElement(pushConstant);
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
	public T caseAbstractProcess(AbstractProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semaphore</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSemaphore(ProcessSemaphore object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProcessUnit(IProcessUnit object)
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
	public T caseConfiguration(Configuration object)
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
	public T casePipelineBarrier(PipelineBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPipeline(IPipeline object)
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
	public T caseAbstractPipeline(AbstractPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPipelineUnit(IPipelineUnit object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Composite Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Composite Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractCompositePipeline(AbstractCompositePipeline object)
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
	public T casePushConstant(PushConstant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInferenceObject(IInferenceObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLObject(LObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEngine Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEngine Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEnginePart(IEnginePart object)
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
	public T caseLNamedElement(LNamedElement object)
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
	public T caseIProcess(IProcess object)
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
	public T defaultCase(EObject object)
	{
		return null;
	}

} //ProcessSwitch
