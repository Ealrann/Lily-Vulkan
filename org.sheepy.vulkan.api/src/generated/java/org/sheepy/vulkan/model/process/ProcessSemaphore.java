/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semaphore</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.ProcessSemaphore#getProcess <em>Process</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.ProcessSemaphore#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getProcessSemaphore()
 * @model
 * @generated
 */
public interface ProcessSemaphore extends EObject
{
	/**
	 * Returns the value of the '<em><b>Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.vulkan.model.process.AbstractProcess#getDependentProcesses <em>Dependent Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' reference.
	 * @see #setProcess(AbstractProcess)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getProcessSemaphore_Process()
	 * @see org.sheepy.vulkan.model.process.AbstractProcess#getDependentProcesses
	 * @model opposite="dependentProcesses"
	 * @generated
	 */
	AbstractProcess getProcess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.ProcessSemaphore#getProcess <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(AbstractProcess value);

	/**
	 * Returns the value of the '<em><b>Wait Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setWaitStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getProcessSemaphore_WaitStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.ProcessSemaphore#getWaitStage <em>Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getWaitStage()
	 * @generated
	 */
	void setWaitStage(EPipelineStage value);

} // ProcessSemaphore
