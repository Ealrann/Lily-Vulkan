/**
 */
package org.sheepy.vulkan.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.BufferBarrier#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.BufferBarrier#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBufferBarrier()
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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBufferBarrier_Buffer()
	 * @model
	 * @generated
	 */
	Buffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access</em>' attribute.
	 * @see #setSrcAccess(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBufferBarrier_SrcAccess()
	 * @model unique="false"
	 * @generated
	 */
	int getSrcAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.BufferBarrier#getSrcAccess <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Access</em>' attribute.
	 * @see #getSrcAccess()
	 * @generated
	 */
	void setSrcAccess(int value);

	/**
	 * Returns the value of the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access</em>' attribute.
	 * @see #setDstAccess(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBufferBarrier_DstAccess()
	 * @model unique="false"
	 * @generated
	 */
	int getDstAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.BufferBarrier#getDstAccess <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Access</em>' attribute.
	 * @see #getDstAccess()
	 * @generated
	 */
	void setDstAccess(int value);

} // BufferBarrier
