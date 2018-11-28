/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.api.types.SVector2i;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Viewport#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Viewport#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMaxDepth <em>Max Depth</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewport()
 * @model
 * @generated
 */
public interface Viewport extends EObject
{
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"0, 0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(SVector2i)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewport_Offset()
	 * @model default="0, 0" unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(SVector2i value);

	/**
	 * Returns the value of the '<em><b>Extent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' attribute.
	 * @see #setExtent(SVector2i)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewport_Extent()
	 * @model unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getExtent();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getExtent <em>Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' attribute.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(SVector2i value);

	/**
	 * Returns the value of the '<em><b>Min Depth</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Depth</em>' attribute.
	 * @see #setMinDepth(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewport_MinDepth()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMinDepth <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Depth</em>' attribute.
	 * @see #getMinDepth()
	 * @generated
	 */
	void setMinDepth(int value);

	/**
	 * Returns the value of the '<em><b>Max Depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Depth</em>' attribute.
	 * @see #setMaxDepth(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewport_MaxDepth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getMaxDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMaxDepth <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Depth</em>' attribute.
	 * @see #getMaxDepth()
	 * @generated
	 */
	void setMaxDepth(int value);

} // Viewport
