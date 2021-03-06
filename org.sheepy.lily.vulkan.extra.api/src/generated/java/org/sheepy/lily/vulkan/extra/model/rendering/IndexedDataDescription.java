/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.vulkan.model.enumeration.EIndexType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getIndexedDataDescription()
 * @model
 * @generated
 */
public interface IndexedDataDescription<T extends Structure> extends DataProvider<T>
{
	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' attribute.
	 * The default value is <code>"UINT32"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EIndexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #setIndexType(EIndexType)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getIndexedDataDescription_IndexType()
	 * @model default="UINT32" required="true"
	 * @generated
	 */
	EIndexType getIndexType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription#getIndexType <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(EIndexType value);

} // IndexedDataDescription
