/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.application.FileResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontImage()
 * @model
 * @generated
 */
public interface FontImage extends Image
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(FileResource)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontImage_File()
	 * @model containment="true"
	 * @generated
	 */
	FileResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileResource value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"18"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontImage_Height()
	 * @model default="18" unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

} // FontImage
