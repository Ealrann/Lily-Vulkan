/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.joml.Vector3dc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getLocation <em>Location</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis <em>Axis</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity()
 * @model abstract="true"
 * @generated
 */
public interface PhysicalEntity extends Entity
{
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity_Location()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getLocation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Vector3dc value);

	/**
	 * Returns the value of the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' containment reference.
	 * @see #setAxis(Axis)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity_Axis()
	 * @model containment="true"
	 * @generated
	 */
	Axis getAxis();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis <em>Axis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' containment reference.
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(Axis value);

} // PhysicalEntity
