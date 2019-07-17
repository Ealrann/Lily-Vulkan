/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.joml.Vector2fc;
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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation <em>Geo Location</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation <em>Geo Orientation</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation <em>Axis Location</em>}</li>
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
	 * Returns the value of the '<em><b>Geo Location</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geo Location</em>' attribute.
	 * @see #setGeoLocation(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity_GeoLocation()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getGeoLocation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation <em>Geo Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geo Location</em>' attribute.
	 * @see #getGeoLocation()
	 * @generated
	 */
	void setGeoLocation(Vector3dc value);

	/**
	 * Returns the value of the '<em><b>Geo Orientation</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geo Orientation</em>' attribute.
	 * @see #setGeoOrientation(Vector2fc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity_GeoOrientation()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector2f"
	 * @generated
	 */
	Vector2fc getGeoOrientation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation <em>Geo Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geo Orientation</em>' attribute.
	 * @see #getGeoOrientation()
	 * @generated
	 */
	void setGeoOrientation(Vector2fc value);

	/**
	 * Returns the value of the '<em><b>Axis Location</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Location</em>' attribute.
	 * @see #setAxisLocation(Vector3dc)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntity_AxisLocation()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3dc getAxisLocation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation <em>Axis Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Location</em>' attribute.
	 * @see #getAxisLocation()
	 * @generated
	 */
	void setAxisLocation(Vector3dc value);

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
