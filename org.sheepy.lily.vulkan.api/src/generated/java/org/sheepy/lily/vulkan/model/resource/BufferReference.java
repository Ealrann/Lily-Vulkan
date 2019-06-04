/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferReference()
 * @model
 * @generated
 */
public interface BufferReference extends IBufferReference
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(Buffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferReference_Buffer()
	 * @model required="true"
	 * @generated
	 */
	Buffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferReference_Offset()
	 * @model unique="false"
	 * @generated
	 */
	long getOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(long value);

} // BufferReference
