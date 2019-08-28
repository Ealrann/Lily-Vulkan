/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.EFormat;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getColorSpace <em>Color Space</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorDomain()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ColorDomain extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The default value is <code>"B8G8R8A8_UNORM"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #setFormat(EFormat)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorDomain_Format()
	 * @model default="B8G8R8A8_UNORM" unique="false"
	 * @generated
	 */
	EFormat getFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(EFormat value);

	/**
	 * Returns the value of the '<em><b>Color Space</b></em>' attribute.
	 * The default value is <code>"SRGB_NONLINEAR_KHR"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EColorSpace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Space</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EColorSpace
	 * @see #setColorSpace(EColorSpace)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorDomain_ColorSpace()
	 * @model default="SRGB_NONLINEAR_KHR" unique="false"
	 * @generated
	 */
	EColorSpace getColorSpace();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getColorSpace <em>Color Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Space</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EColorSpace
	 * @see #getColorSpace()
	 * @generated
	 */
	void setColorSpace(EColorSpace value);

} // ColorDomain
