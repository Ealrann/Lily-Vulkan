/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.resource.SampledImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontSampledImage <em>Font Sampled Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont()
 * @model
 * @generated
 */
public interface NuklearFont extends IResource
{
	/**
	 * Returns the value of the '<em><b>Font Sampled Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Sampled Image</em>' containment reference.
	 * @see #setFontSampledImage(SampledImage)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont_FontSampledImage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SampledImage getFontSampledImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontSampledImage <em>Font Sampled Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Sampled Image</em>' containment reference.
	 * @see #getFontSampledImage()
	 * @generated
	 */
	void setFontSampledImage(SampledImage value);

} // NuklearFont
