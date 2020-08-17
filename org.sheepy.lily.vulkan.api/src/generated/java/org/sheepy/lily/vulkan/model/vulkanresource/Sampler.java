/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.sheepy.lily.vulkan.model.IVulkanResource;

import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.Sampler#getImage <em>Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getSampler()
 * @model
 * @generated
 */
public interface Sampler extends SamplerInfo, IVulkanResource
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(IVulkanImage)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getSampler_Image()
	 * @model
	 * @generated
	 */
	IVulkanImage getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.Sampler#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(IVulkanImage value);

} // Sampler
