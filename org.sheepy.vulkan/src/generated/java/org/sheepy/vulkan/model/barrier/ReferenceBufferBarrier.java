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
 *   <li>{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferPtr <em>Buffer Ptr</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceBufferBarrier()
 * @model
 * @generated
 */
public interface ReferenceBufferBarrier extends AbstractBufferBarrier
{
	/**
	 * Returns the value of the '<em><b>Buffer Ptr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Ptr</em>' attribute.
	 * @see #setBufferPtr(long)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceBufferBarrier_BufferPtr()
	 * @model unique="false"
	 * @generated
	 */
	long getBufferPtr();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferPtr <em>Buffer Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Ptr</em>' attribute.
	 * @see #getBufferPtr()
	 * @generated
	 */
	void setBufferPtr(long value);

} // ReferenceBufferBarrier
