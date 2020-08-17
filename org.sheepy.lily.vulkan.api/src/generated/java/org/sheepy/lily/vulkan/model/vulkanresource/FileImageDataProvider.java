/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageReference <em>File Image Reference</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageContainment <em>File Image Containment</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getFileImageDataProvider()
 * @model
 * @generated
 */
public interface FileImageDataProvider extends ImageDataProvider
{
	/**
	 * Returns the value of the '<em><b>File Image Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Image Reference</em>' reference.
	 * @see #setFileImageReference(FileImage)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getFileImageDataProvider_FileImageReference()
	 * @model required="true"
	 * @generated
	 */
	FileImage getFileImageReference();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageReference <em>File Image Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Image Reference</em>' reference.
	 * @see #getFileImageReference()
	 * @generated
	 */
	void setFileImageReference(FileImage value);

	/**
	 * Returns the value of the '<em><b>File Image Containment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Image Containment</em>' containment reference.
	 * @see #setFileImageContainment(FileImage)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getFileImageDataProvider_FileImageContainment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FileImage getFileImageContainment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageContainment <em>File Image Containment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Image Containment</em>' containment reference.
	 * @see #getFileImageContainment()
	 * @generated
	 */
	void setFileImageContainment(FileImage value);

} // FileImageDataProvider
