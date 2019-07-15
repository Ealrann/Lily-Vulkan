/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.model.enumeration.EInputRate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor#getInputRate <em>Input Rate</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor#getStrideLength <em>Stride Length</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getInputDescriptor()
 * @model
 * @generated
 */
public interface InputDescriptor extends EObject
{
	/**
	 * Returns the value of the '<em><b>Input Rate</b></em>' attribute.
	 * The default value is <code>"VERTEX"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EInputRate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Rate</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInputRate
	 * @see #setInputRate(EInputRate)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getInputDescriptor_InputRate()
	 * @model default="VERTEX" unique="false"
	 * @generated
	 */
	EInputRate getInputRate();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor#getInputRate <em>Input Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Rate</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInputRate
	 * @see #getInputRate()
	 * @generated
	 */
	void setInputRate(EInputRate value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getInputDescriptor_Attributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AttributeDescription> getAttributes();

	/**
	 * Returns the value of the '<em><b>Stride Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stride Length</em>' attribute.
	 * @see #setStrideLength(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getInputDescriptor_StrideLength()
	 * @model unique="false"
	 * @generated
	 */
	int getStrideLength();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor#getStrideLength <em>Stride Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stride Length</em>' attribute.
	 * @see #getStrideLength()
	 * @generated
	 */
	void setStrideLength(int value);

} // InputDescriptor
