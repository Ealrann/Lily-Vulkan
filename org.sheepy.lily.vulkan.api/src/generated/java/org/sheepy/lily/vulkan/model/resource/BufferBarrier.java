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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffers <em>Buffers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferBarrier()
 * @model
 * @generated
 */
public interface BufferBarrier extends AbstractBufferBarrier
{
	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' containment reference.
	 * @see #setBuffers(BufferReference)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferBarrier_Buffers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferReference getBuffers();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffers <em>Buffers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffers</em>' containment reference.
	 * @see #getBuffers()
	 * @generated
	 */
	void setBuffers(BufferReference value);

} // BufferBarrier
