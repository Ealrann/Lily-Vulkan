/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFonts <em>Fonts</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFontImage()
 * @model
 * @generated
 */
public interface FontImage extends Image
{
	/**
	 * Returns the value of the '<em><b>Fonts</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.Font}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonts</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFontImage_Fonts()
	 * @model
	 * @generated
	 */
	EList<Font> getFonts();

} // FontImage
