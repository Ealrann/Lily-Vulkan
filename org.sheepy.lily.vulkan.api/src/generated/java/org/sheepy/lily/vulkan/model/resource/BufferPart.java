/**
 */
package org.sheepy.lily.vulkan.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferPart#getDataProvider <em>Data Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferPart()
 * @model
 * @generated
 */
public interface BufferPart extends IBuffer
{
	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' containment reference.
	 * @see #setDataProvider(BufferDataProvider)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferPart_DataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferDataProvider<?> getDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferPart#getDataProvider <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' containment reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(BufferDataProvider<?> value);

} // BufferPart
