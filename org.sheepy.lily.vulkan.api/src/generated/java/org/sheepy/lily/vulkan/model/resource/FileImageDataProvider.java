/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.resource.FileImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Image Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FileImageDataProvider#getFileImage <em>File Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFileImageDataProvider()
 * @model
 * @generated
 */
public interface FileImageDataProvider extends ImageDataProvider
{
	/**
	 * Returns the value of the '<em><b>File Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Image</em>' reference.
	 * @see #setFileImage(FileImage)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFileImageDataProvider_FileImage()
	 * @model required="true"
	 * @generated
	 */
	FileImage getFileImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FileImageDataProvider#getFileImage <em>File Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Image</em>' reference.
	 * @see #getFileImage()
	 * @generated
	 */
	void setFileImage(FileImage value);

} // FileImageDataProvider
