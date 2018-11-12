/**
 */
package org.sheepy.vulkan.model.process.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.vulkan.model.IProcessPool;

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
			case ProcessPackage.CONFIGURATION:
			{
				Configuration configuration = (Configuration)theEObject;
				T1 result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PROCESS_POOL:
			{
				AbstractProcessPool<?> abstractProcessPool = (AbstractProcessPool<?>)theEObject;
				T1 result = caseAbstractProcessPool(abstractProcessPool);
				if (result == null) result = caseIProcessPool(abstractProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PROCESS:
			{
				AbstractProcess abstractProcess = (AbstractProcess)theEObject;
				T1 result = caseAbstractProcess(abstractProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPROCESS_UNIT:
			{
				IProcessUnit iProcessUnit = (IProcessUnit)theEObject;
				T1 result = caseIProcessUnit(iProcessUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_BARRIER:
			{
				PipelineBarrier pipelineBarrier = (PipelineBarrier)theEObject;
				T1 result = casePipelineBarrier(pipelineBarrier);
				if (result == null) result = caseIProcessUnit(pipelineBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_BUFFER_BARRIER:
			{
				PipelineBufferBarrier pipelineBufferBarrier = (PipelineBufferBarrier)theEObject;
				T1 result = casePipelineBufferBarrier(pipelineBufferBarrier);
				if (result == null) result = casePipelineBarrier(pipelineBufferBarrier);
				if (result == null) result = caseIProcessUnit(pipelineBufferBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PIPELINE:
			{
				AbstractPipeline abstractPipeline = (AbstractPipeline)theEObject;
				T1 result = caseAbstractPipeline(abstractPipeline);
				if (result == null) result = caseIProcessUnit(abstractPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_COMPOSITE_PIPELINE:
			{
				AbstractCompositePipeline abstractCompositePipeline = (AbstractCompositePipeline)theEObject;
				T1 result = caseAbstractCompositePipeline(abstractCompositePipeline);
				if (result == null) result = caseAbstractPipeline(abstractCompositePipeline);
				if (result == null) result = caseIProcessUnit(abstractCompositePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	public T1 caseConfiguration(Configuration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Process Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends AbstractProcess> T1 caseAbstractProcessPool(AbstractProcessPool<T> object)
	{
		return null;
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
	public T1 caseIProcessUnit(IProcessUnit object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline Buffer Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipelineBufferBarrier(PipelineBufferBarrier object)
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
	public T1 caseAbstractCompositePipeline(AbstractCompositePipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessPool(IProcessPool object)
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
