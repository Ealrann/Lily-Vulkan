/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.resource.FileResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FileImage#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FileImage#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFileImage()
 * @model
 * @generated
 */
public interface FileImage extends Image
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' reference.
	 * @see #setFile(FileResource)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFileImage_File()
	 * @model resolveProxies="false"
	 * @generated
	 */
	FileResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FileImage#getFile <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileResource value);

	/**
	 * Returns the value of the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #setMipmapEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFileImage_MipmapEnabled()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMipmapEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FileImage#isMipmapEnabled <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #isMipmapEnabled()
	 * @generated
	 */
	void setMipmapEnabled(boolean value);

} // FileImage
