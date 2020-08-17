/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.sheepy.vulkan.model.image.ImageInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Viewer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageViewer()
 * @model
 * @generated
 */
public interface ImageViewer extends IMemoryChunkPart, IVulkanImage, ImageInfo
{
	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' containment reference.
	 * @see #setDataProvider(ImageDataProvider)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageViewer_DataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ImageDataProvider getDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#getDataProvider <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' containment reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(ImageDataProvider value);

	/**
	 * Returns the value of the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #setMipmapEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getImageViewer_MipmapEnabled()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMipmapEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#isMipmapEnabled <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #isMipmapEnabled()
	 * @generated
	 */
	void setMipmapEnabled(boolean value);

} // ImageViewer
