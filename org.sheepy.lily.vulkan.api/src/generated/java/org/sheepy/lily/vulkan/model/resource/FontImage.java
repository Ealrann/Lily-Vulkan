/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.ui.Font;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFont <em>Font</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontImage()
 * @model
 * @generated
 */
public interface FontImage extends Image
{
	/**
	 * Returns the value of the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' reference.
	 * @see #setFont(Font)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getFontImage_Font()
	 * @model required="true"
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFont <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

} // FontImage
