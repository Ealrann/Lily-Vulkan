/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeImage#getInlays <em>Inlays</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeImage#getBackground <em>Background</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeImage()
 * @model
 * @generated
 */
public interface CompositeImage extends VulkanImage
{
	/**
	 * Returns the value of the '<em><b>Inlays</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.ImageInlay}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlays</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeImage_Inlays()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImageInlay> getInlays();

	/**
	 * Returns the value of the '<em><b>Background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background</em>' reference.
	 * @see #setBackground(VulkanImage)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCompositeImage_Background()
	 * @model required="true"
	 * @generated
	 */
	VulkanImage getBackground();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeImage#getBackground <em>Background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background</em>' reference.
	 * @see #getBackground()
	 * @generated
	 */
	void setBackground(VulkanImage value);

} // CompositeImage
