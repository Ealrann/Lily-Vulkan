/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.IDescriptor;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getImages <em>Images</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getSampler <em>Sampler</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageDescriptor()
 * @model
 * @generated
 */
public interface ImageDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Images</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Images</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageDescriptor_Images()
	 * @model
	 * @generated
	 */
	EList<IVulkanImage> getImages();

	/**
	 * Returns the value of the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler</em>' reference.
	 * @see #setSampler(Sampler)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageDescriptor_Sampler()
	 * @model
	 * @generated
	 */
	Sampler getSampler();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getSampler <em>Sampler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampler</em>' reference.
	 * @see #getSampler()
	 * @generated
	 */
	void setSampler(Sampler value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * The default value is <code>"GENERAL"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setLayout(EImageLayout)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageDescriptor_Layout()
	 * @model default="GENERAL"
	 * @generated
	 */
	EImageLayout getLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(EImageLayout value);

} // ImageDescriptor
