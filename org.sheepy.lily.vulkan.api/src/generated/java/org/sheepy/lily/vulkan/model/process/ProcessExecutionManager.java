/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitForExecution <em>Wait For Execution</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitedBy <em>Waited By</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExecutionManager()
 * @model abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface ProcessExecutionManager extends ILilyEObject
{

	/**
	 * Returns the value of the '<em><b>Wait For Execution</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager}.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitedBy <em>Waited By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Execution</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExecutionManager_WaitForExecution()
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitedBy
	 * @model opposite="waitedBy"
	 * @generated
	 */
	EList<ProcessExecutionManager> getWaitForExecution();

	/**
	 * Returns the value of the '<em><b>Waited By</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager}.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitForExecution <em>Wait For Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waited By</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExecutionManager_WaitedBy()
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitForExecution
	 * @model opposite="waitForExecution"
	 * @generated
	 */
	EList<ProcessExecutionManager> getWaitedBy();

	/**
	 * Returns the value of the '<em><b>Wait Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setWaitStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExecutionManager_WaitStage()
	 * @model
	 * @generated
	 */
	EPipelineStage getWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitStage <em>Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getWaitStage()
	 * @generated
	 */
	void setWaitStage(EPipelineStage value);
} // ProcessExecutionManager
