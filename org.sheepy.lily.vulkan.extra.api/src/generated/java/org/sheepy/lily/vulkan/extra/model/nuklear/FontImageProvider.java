/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Image Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider#getNuklearFont <em>Nuklear Font</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontImageProvider()
 * @model
 * @generated
 */
public interface FontImageProvider extends ImageDataProvider
{
	/**
	 * Returns the value of the '<em><b>Nuklear Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nuklear Font</em>' reference.
	 * @see #setNuklearFont(NuklearFont)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontImageProvider_NuklearFont()
	 * @model required="true"
	 * @generated
	 */
	NuklearFont getNuklearFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider#getNuklearFont <em>Nuklear Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nuklear Font</em>' reference.
	 * @see #getNuklearFont()
	 * @generated
	 */
	void setNuklearFont(NuklearFont value);

} // FontImageProvider
