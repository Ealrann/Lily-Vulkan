/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Renderable Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPresentation <em>Presentation</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderableDataSource()
 * @model
 * @generated
 */
public interface RenderableDataSource<T extends Presentation> extends EObject
{
	/**
	 * Returns the value of the '<em><b>Presentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation</em>' reference.
	 * @see #setPresentation(Presentation)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderableDataSource_Presentation()
	 * @model required="true"
	 * @generated
	 */
	T getPresentation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPresentation <em>Presentation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation</em>' reference.
	 * @see #getPresentation()
	 * @generated
	 */
	void setPresentation(T value);

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
