/**
 */
package org.sheepy.vulkan.model.process.compute;

import org.sheepy.vulkan.model.resource.BufferBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier#getBufferBarrier <em>Buffer Barrier</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.compute.ComputePackage#getComputerBufferBarrier()
 * @model
 * @generated
 */
public interface ComputerBufferBarrier extends IComputer
{
	/**
	 * Returns the value of the '<em><b>Buffer Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer Barrier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Barrier</em>' containment reference.
	 * @see #setBufferBarrier(BufferBarrier)
	 * @see org.sheepy.vulkan.model.process.compute.ComputePackage#getComputerBufferBarrier_BufferBarrier()
	 * @model containment="true"
	 * @generated
	 */
	BufferBarrier getBufferBarrier();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier#getBufferBarrier <em>Buffer Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Barrier</em>' containment reference.
	 * @see #getBufferBarrier()
	 * @generated
	 */
	void setBufferBarrier(BufferBarrier value);

} // ComputerBufferBarrier
