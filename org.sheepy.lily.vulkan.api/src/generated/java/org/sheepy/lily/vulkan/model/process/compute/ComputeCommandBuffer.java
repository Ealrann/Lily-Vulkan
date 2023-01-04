/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer#getSubmittedBy <em>Submitted By</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeCommandBuffer()
 * @model
 * @generated
 */
public interface ComputeCommandBuffer extends ICommandBuffer
{

	/**
	 * Returns the value of the '<em><b>Submitted By</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder}.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getCommandBuffer <em>Command Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submitted By</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeCommandBuffer_SubmittedBy()
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder#getCommandBuffer
	 * @model opposite="commandBuffer"
	 * @generated
	 */
	EList<ComputeExecutionRecorder> getSubmittedBy();
} // ComputeCommandBuffer
