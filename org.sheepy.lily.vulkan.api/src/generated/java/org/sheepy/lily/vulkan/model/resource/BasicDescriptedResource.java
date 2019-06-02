/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Descripted Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBasicDescriptedResource()
 * @model abstract="true"
 * @generated
 */
public interface BasicDescriptedResource extends DescriptedResource
{
	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' containment reference.
	 * @see #setDescriptor(Descriptor)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBasicDescriptedResource_Descriptor()
	 * @model containment="true"
	 * @generated
	 */
	Descriptor getDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource#getDescriptor <em>Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' containment reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(Descriptor value);

} // BasicDescriptedResource
