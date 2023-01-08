/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder#getSubmission <em>Submission</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getExecutionRecorder()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface ExecutionRecorder extends ILilyEObject
{

	/**
	 * Returns the value of the '<em><b>Submission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submission</em>' containment reference.
	 * @see #setSubmission(Submission)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getExecutionRecorder_Submission()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Submission getSubmission();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder#getSubmission <em>Submission</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submission</em>' containment reference.
	 * @see #getSubmission()
	 * @generated
	 */
	void setSubmission(Submission value);
} // ExecutionRecorder
