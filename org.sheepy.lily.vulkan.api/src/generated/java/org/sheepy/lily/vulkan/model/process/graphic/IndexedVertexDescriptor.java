/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.vulkan.model.enumeration.EIndexType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Vertex Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getIndexedVertexDescriptor()
 * @model
 * @generated
 */
public interface IndexedVertexDescriptor extends VertexDescriptor
{
	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EIndexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #setIndexType(EIndexType)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getIndexedVertexDescriptor_IndexType()
	 * @model unique="false"
	 * @generated
	 */
	EIndexType getIndexType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor#getIndexType <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(EIndexType value);

} // IndexedVertexDescriptor
