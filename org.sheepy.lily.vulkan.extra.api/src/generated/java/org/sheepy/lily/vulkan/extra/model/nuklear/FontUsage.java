/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

import org.sheepy.lily.core.model.ui.Font;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage#getStrings <em>Strings</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontUsage()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface FontUsage extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' reference.
	 * @see #setFont(Font)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontUsage_Font()
	 * @model
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage#getFont <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

	/**
	 * Returns the value of the '<em><b>Strings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strings</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontUsage_Strings()
	 * @model
	 * @generated
	 */
	EList<String> getStrings();

} // FontUsage
