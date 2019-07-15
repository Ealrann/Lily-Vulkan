/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EFormat;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttributeDescription()
 * @model
 * @generated
 */
public interface AttributeDescription extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #setFormat(EFormat)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttributeDescription_Format()
	 * @model unique="false"
	 * @generated
	 */
	EFormat getFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(EFormat value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttributeDescription_Offset()
	 * @model unique="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

} // AttributeDescription
