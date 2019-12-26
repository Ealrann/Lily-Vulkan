/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.vulkan.model.resource.FontTextureArray;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontTextureArray <em>Font Texture Array</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont()
 * @model
 * @generated
 */
public interface NuklearFont extends IResource
{

	/**
	 * Returns the value of the '<em><b>Font Texture Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Texture Array</em>' reference.
	 * @see #setFontTextureArray(FontTextureArray)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont_FontTextureArray()
	 * @model required="true"
	 * @generated
	 */
	FontTextureArray getFontTextureArray();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontTextureArray <em>Font Texture Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Texture Array</em>' reference.
	 * @see #getFontTextureArray()
	 * @generated
	 */
	void setFontTextureArray(FontTextureArray value);

} // NuklearFont
