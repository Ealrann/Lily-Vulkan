/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBufferReference()
 * @model
 * @generated
 */
public interface CompositeBufferReference extends CompositePartReference, IBufferReference
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBufferReference_Buffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(CompositeBuffer value);

} // CompositeBufferReference
