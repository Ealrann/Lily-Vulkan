/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.joml.Vector3dc;
import org.sheepy.lily.core.model.resource.IRootResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Camera</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getFieldOfView <em>Field Of View</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getZNear <em>ZNear</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getZFar <em>ZFar</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getLookDirection <em>Look Direction</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera()
 * @model
 * @generated
 */
public interface Camera extends IRootResource
{
	/**
	 * Returns the value of the '<em><b>Field Of View</b></em>' attribute.
	 * The default value is <code>"45"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Of View</em>' attribute.
	 * @see #setFieldOfView(float)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_FieldOfView()
	 * @model default="45" required="true"
	 * @generated
	 */
	float getFieldOfView();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getFieldOfView <em>Field Of View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Of View</em>' attribute.
	 * @see #getFieldOfView()
	 * @generated
	 */
	void setFieldOfView(float value);

	/**
	 * Returns the value of the '<em><b>ZNear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZNear</em>' attribute.
	 * @see #setZNear(float)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_ZNear()
	 * @model required="true"
	 * @generated
	 */
	float getZNear();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getZNear <em>ZNear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZNear</em>' attribute.
	 * @see #getZNear()
	 * @generated
	 */
	void setZNear(float value);

	/**
	 * Returns the value of the '<em><b>ZFar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZFar</em>' attribute.
	 * @see #setZFar(float)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_ZFar()
	 * @model required="true"
	 * @generated
	 */
	float getZFar();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getZFar <em>ZFar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZFar</em>' attribute.
	 * @see #getZFar()
	 * @generated
	 */
	void setZFar(float value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_Position()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getPosition();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Vector3dc value);

	/**
	 * Returns the value of the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' containment reference.
	 * @see #setAxis(Axis)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_Axis()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Axis getAxis();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getAxis <em>Axis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' containment reference.
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(Axis value);

	/**
	 * Returns the value of the '<em><b>Look Direction</b></em>' attribute.
	 * The default value is <code>"1;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Look Direction</em>' attribute.
	 * @see #setLookDirection(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCamera_LookDirection()
	 * @model default="1;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getLookDirection();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Camera#getLookDirection <em>Look Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Look Direction</em>' attribute.
	 * @see #getLookDirection()
	 * @generated
	 */
	void setLookDirection(Vector3dc value);

} // Camera
