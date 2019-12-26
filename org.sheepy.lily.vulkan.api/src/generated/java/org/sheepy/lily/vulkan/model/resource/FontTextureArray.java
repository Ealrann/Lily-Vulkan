/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.ui.Font;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Texture Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray#getFonts <em>Fonts</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontTextureArray()
 * @model
 * @generated
 */
public interface FontTextureArray extends ITextureArray
{
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"18"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontTextureArray_Height()
	 * @model default="18" unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Fonts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.Font}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonts</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontTextureArray_Fonts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Font> getFonts();

} // FontTextureArray
