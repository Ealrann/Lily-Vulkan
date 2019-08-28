/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.joml.Vector3dc;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection <em>Front Direction</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection <em>Up Direction</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection <em>Right Direction</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getAxis()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Axis extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Front Direction</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Front Direction</em>' attribute.
	 * @see #setFrontDirection(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getAxis_FrontDirection()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getFrontDirection();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection <em>Front Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Front Direction</em>' attribute.
	 * @see #getFrontDirection()
	 * @generated
	 */
	void setFrontDirection(Vector3dc value);

	/**
	 * Returns the value of the '<em><b>Up Direction</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Up Direction</em>' attribute.
	 * @see #setUpDirection(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getAxis_UpDirection()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getUpDirection();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection <em>Up Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Up Direction</em>' attribute.
	 * @see #getUpDirection()
	 * @generated
	 */
	void setUpDirection(Vector3dc value);

	/**
	 * Returns the value of the '<em><b>Right Direction</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Direction</em>' attribute.
	 * @see #setRightDirection(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getAxis_RightDirection()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getRightDirection();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection <em>Right Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Direction</em>' attribute.
	 * @see #getRightDirection()
	 * @generated
	 */
	void setRightDirection(Vector3dc value);

} // Axis
