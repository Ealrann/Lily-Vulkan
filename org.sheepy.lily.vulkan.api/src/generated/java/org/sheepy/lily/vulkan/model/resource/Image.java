/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage()
 * @model abstract="true"
 * @generated
 */
public interface Image extends DescriptedResource
{

	/**
	 * Returns the value of the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Layout</em>' containment reference.
	 * @see #setInitialLayout(ImageLayout)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_InitialLayout()
	 * @model containment="true"
	 * @generated
	 */
	ImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' containment reference.
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(ImageLayout value);

} // Image
