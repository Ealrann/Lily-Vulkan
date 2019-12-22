/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.vulkan.model.image.ImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Texture2 DArray</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getFiles <em>Files</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArray()
 * @model
 * @generated
 */
public interface Texture2DArray extends IResource
{
	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.FileResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArray_Files()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<FileResource> getFiles();

	/**
	 * Returns the value of the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #setMipmapEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArray_MipmapEnabled()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMipmapEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#isMipmapEnabled <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mipmap Enabled</em>' attribute.
	 * @see #isMipmapEnabled()
	 * @generated
	 */
	void setMipmapEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Layout</em>' containment reference.
	 * @see #setInitialLayout(ImageLayout)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArray_InitialLayout()
	 * @model containment="true"
	 * @generated
	 */
	ImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getInitialLayout <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' containment reference.
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(ImageLayout value);

} // Texture2DArray
