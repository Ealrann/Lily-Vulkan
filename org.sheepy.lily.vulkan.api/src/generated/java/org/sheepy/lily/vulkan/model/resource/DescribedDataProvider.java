/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Described Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.DescribedDataProvider#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getDescribedDataProvider()
 * @model
 * @generated
 */
public interface DescribedDataProvider<T> extends BufferDataProvider<T>
{

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' containment reference.
	 * @see #setDescriptor(Descriptor)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getDescribedDataProvider_Descriptor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Descriptor getDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.DescribedDataProvider#getDescriptor <em>Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' containment reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(Descriptor value);} // DescribedDataProvider
