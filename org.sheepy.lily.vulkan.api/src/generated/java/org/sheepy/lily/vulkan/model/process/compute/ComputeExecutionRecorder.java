/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getIndex <em>Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getCommandBuffer <em>Command Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionRecorder()
 * @model
 * @generated
 */
public interface ComputeExecutionRecorder extends ExecutionRecorder
{

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionRecorder_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Command Buffer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer#getSubmittedBy <em>Submitted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffer</em>' reference.
	 * @see #setCommandBuffer(ComputeCommandBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionRecorder_CommandBuffer()
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer#getSubmittedBy
	 * @model opposite="submittedBy" required="true"
	 * @generated
	 */
	ComputeCommandBuffer getCommandBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getCommandBuffer <em>Command Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Buffer</em>' reference.
	 * @see #getCommandBuffer()
	 * @generated
	 */
	void setCommandBuffer(ComputeCommandBuffer value);
} // ComputeExecutionRecorder
