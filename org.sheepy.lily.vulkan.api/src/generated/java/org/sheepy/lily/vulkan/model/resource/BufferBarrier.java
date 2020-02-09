/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferBarrier()
 * @model
 * @generated
 */
public interface BufferBarrier extends AbstractBufferBarrier
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferBarrier_Buffer()
	 * @model
	 * @generated
	 */
	IBuffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(IBuffer value);

} // BufferBarrier
