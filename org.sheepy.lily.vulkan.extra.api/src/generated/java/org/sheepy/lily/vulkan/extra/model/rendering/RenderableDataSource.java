/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Renderable Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getStructure <em>Structure</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderableDataSource()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface RenderableDataSource<T extends Structure> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure</em>' reference.
	 * @see #setStructure(Structure)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderableDataSource_Structure()
	 * @model required="true"
	 * @generated
	 */
	T getStructure();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getStructure <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure</em>' reference.
	 * @see #getStructure()
	 * @generated
	 */
	void setStructure(T value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' attribute.
	 * @see #setPart(int)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderableDataSource_Part()
	 * @model required="true"
	 * @generated
	 */
	int getPart();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPart <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' attribute.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(int value);

} // RenderableDataSource
