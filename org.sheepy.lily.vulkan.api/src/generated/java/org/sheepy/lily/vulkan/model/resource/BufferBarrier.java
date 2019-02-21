/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.enumeration.EAccess;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferBarrier()
 * @model
 * @generated
 */
public interface BufferBarrier extends Barrier
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(Buffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferBarrier_Buffer()
	 * @model
	 * @generated
	 */
	Buffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Src Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EAccess
	 * @see #setSrcAccess(EAccess)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferBarrier_SrcAccess()
	 * @model unique="false"
	 * @generated
	 */
	EAccess getSrcAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getSrcAccess <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Access</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EAccess
	 * @see #getSrcAccess()
	 * @generated
	 */
	void setSrcAccess(EAccess value);

	/**
	 * Returns the value of the '<em><b>Dst Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EAccess
	 * @see #setDstAccess(EAccess)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferBarrier_DstAccess()
	 * @model unique="false"
	 * @generated
	 */
	EAccess getDstAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getDstAccess <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Access</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EAccess
	 * @see #getDstAccess()
	 * @generated
	 */
	void setDstAccess(EAccess value);

} // BufferBarrier
