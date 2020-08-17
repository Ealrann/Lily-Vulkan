/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.image.ImageInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getInlays <em>Inlays</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getBackground <em>Background</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getCompositeImage()
 * @model
 * @generated
 */
public interface CompositeImage extends IVulkanImage, ImageInfo
{
	/**
	 * Returns the value of the '<em><b>Inlays</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlays</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getCompositeImage_Inlays()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImageInlay> getInlays();

	/**
	 * Returns the value of the '<em><b>Background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background</em>' reference.
	 * @see #setBackground(IVulkanImage)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getCompositeImage_Background()
	 * @model required="true"
	 * @generated
	 */
	IVulkanImage getBackground();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getBackground <em>Background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background</em>' reference.
	 * @see #getBackground()
	 * @generated
	 */
	void setBackground(IVulkanImage value);

} // CompositeImage
