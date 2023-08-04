/**
 */
package org.sheepy.lily.vulkan.extra.model.shape;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sphere</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.shape.Sphere#getSliceCount <em>Slice Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage#getSphere()
 * @model
 * @generated
 */
public interface Sphere extends GeometricStructure
{
	/**
	 * Returns the value of the '<em><b>Slice Count</b></em>' attribute.
	 * The default value is <code>"12"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Count</em>' attribute.
	 * @see #setSliceCount(int)
	 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage#getSphere_SliceCount()
	 * @model default="12"
	 * @generated
	 */
	int getSliceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.shape.Sphere#getSliceCount <em>Slice Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Count</em>' attribute.
	 * @see #getSliceCount()
	 * @generated
	 */
	void setSliceCount(int value);

} // Sphere
