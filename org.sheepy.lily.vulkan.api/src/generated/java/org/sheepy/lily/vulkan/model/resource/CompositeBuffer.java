/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.resource.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getParts <em>Parts</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer <em>Transfer Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeBuffer()
 * @model
 * @generated
 */
public interface CompositeBuffer extends IResource
{
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.BufferPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeBuffer_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<BufferPart> getParts();

	/**
	 * Returns the value of the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Buffer</em>' reference.
	 * @see #setTransferBuffer(TransferBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeBuffer_TransferBuffer()
	 * @model required="true"
	 * @generated
	 */
	TransferBuffer getTransferBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Buffer</em>' reference.
	 * @see #getTransferBuffer()
	 * @generated
	 */
	void setTransferBuffer(TransferBuffer value);

} // CompositeBuffer
