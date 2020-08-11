/**
 */
package org.sheepy.lily.vulkan.model.resource;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getSampler <em>Sampler</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageDescriptor()
 * @model
 * @generated
 */
public interface ImageDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageDescriptor_Image()
	 * @model required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler</em>' reference.
	 * @see #setSampler(Sampler)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageDescriptor_Sampler()
	 * @model
	 * @generated
	 */
	Sampler getSampler();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getSampler <em>Sampler</em>}' reference.
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
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageDescriptor_Layout()
	 * @model default="GENERAL" required="true"
	 * @generated
	 */
	EImageLayout getLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(EImageLayout value);

} // ImageDescriptor
