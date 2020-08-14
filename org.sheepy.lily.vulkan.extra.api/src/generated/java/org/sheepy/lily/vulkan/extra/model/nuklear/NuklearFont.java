/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.IVulkanResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontImage <em>Font Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont()
 * @model
 * @generated
 */
public interface NuklearFont extends IVulkanResource
{

	/**
	 * Returns the value of the '<em><b>Font Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Image</em>' reference.
	 * @see #setFontImage(FontImageProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont_FontImage()
	 * @model required="true"
	 * @generated
	 */
	FontImageProvider getFontImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontImage <em>Font Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Image</em>' reference.
	 * @see #getFontImage()
	 * @generated
	 */
	void setFontImage(FontImageProvider value);

} // NuklearFont
