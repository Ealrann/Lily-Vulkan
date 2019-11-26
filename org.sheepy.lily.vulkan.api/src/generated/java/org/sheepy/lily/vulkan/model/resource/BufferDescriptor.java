/**
 */
package org.sheepy.lily.vulkan.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBufferReference <em>Buffer Reference</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDescriptor()
 * @model
 * @generated
 */
public interface BufferDescriptor extends Descriptor
{
	/**
	 * Returns the value of the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #setBufferReference(IBufferReference)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDescriptor_BufferReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IBufferReference getBufferReference();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBufferReference <em>Buffer Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #getBufferReference()
	 * @generated
	 */
	void setBufferReference(IBufferReference value);

} // BufferDescriptor
