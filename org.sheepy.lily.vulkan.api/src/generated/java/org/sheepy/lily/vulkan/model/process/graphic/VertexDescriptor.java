/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getStrideLength <em>Stride Length</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexDescriptor()
 * @model
 * @generated
 */
public interface VertexDescriptor extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexDescriptor_Attributes()
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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexDescriptor_StrideLength()
	 * @model unique="false"
	 * @generated
	 */
	int getStrideLength();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getStrideLength <em>Stride Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stride Length</em>' attribute.
	 * @see #getStrideLength()
	 * @generated
	 */
	void setStrideLength(int value);

} // VertexDescriptor
