/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontArrayDescriptor <em>Font Array Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont()
 * @model
 * @generated
 */
public interface NuklearFont extends IResource
{

	/**
	 * Returns the value of the '<em><b>Font Array Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Array Descriptor</em>' reference.
	 * @see #setFontArrayDescriptor(ImageArrayDescriptor)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFont_FontArrayDescriptor()
	 * @model
	 * @generated
	 */
	ImageArrayDescriptor getFontArrayDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontArrayDescriptor <em>Font Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Array Descriptor</em>' reference.
	 * @see #getFontArrayDescriptor()
	 * @generated
	 */
	void setFontArrayDescriptor(ImageArrayDescriptor value);

} // NuklearFont
