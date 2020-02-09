/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.resource.IImage;

import org.sheepy.lily.vulkan.model.IDescriptor;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Array Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getImages <em>Images</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageArrayDescriptor()
 * @model
 * @generated
 */
public interface ImageArrayDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Images</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.resource.IImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Images</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageArrayDescriptor_Images()
	 * @model
	 * @generated
	 */
	EList<IImage> getImages();

	/**
	 * Returns the value of the '<em><b>Initial Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setInitialLayout(EImageLayout)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageArrayDescriptor_InitialLayout()
	 * @model required="true"
	 * @generated
	 */
	EImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getInitialLayout <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(EImageLayout value);

} // ImageArrayDescriptor
