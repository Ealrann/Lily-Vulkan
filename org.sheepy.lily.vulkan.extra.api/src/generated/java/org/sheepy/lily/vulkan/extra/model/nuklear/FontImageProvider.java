/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.resource.ImageDataProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Image Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider#getFontUsages <em>Font Usages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontImageProvider()
 * @model
 * @generated
 */
public interface FontImageProvider extends ImageDataProvider
{
	/**
	 * Returns the value of the '<em><b>Font Usages</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Usages</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getFontImageProvider_FontUsages()
	 * @model containment="true"
	 * @generated
	 */
	EList<FontUsage> getFontUsages();

} // FontImageProvider
