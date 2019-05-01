/**
 */
package org.sheepy.vulkan.model.barrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferAddress <em>Buffer Address</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceBufferBarrier()
 * @model
 * @generated
 */
public interface ReferenceBufferBarrier extends AbstractBufferBarrier
{
	/**
	 * Returns the value of the '<em><b>Buffer Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Address</em>' attribute.
	 * @see #setBufferAddress(long)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceBufferBarrier_BufferAddress()
	 * @model unique="false"
	 * @generated
	 */
	long getBufferAddress();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferAddress <em>Buffer Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Address</em>' attribute.
	 * @see #getBufferAddress()
	 * @generated
	 */
	void setBufferAddress(long value);

} // ReferenceBufferBarrier
