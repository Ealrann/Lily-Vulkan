/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier#getImage <em>Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageBarrier()
 * @model
 * @generated
 */
public interface ImageBarrier extends AbstractImageBarrier
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(IVulkanImage)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageBarrier_Image()
	 * @model required="true"
	 * @generated
	 */
	IVulkanImage getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(IVulkanImage value);

} // ImageBarrier
