/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ico Sphere</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.mesh.IcoSphere#getSubdivisionCount <em>Subdivision Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage#getIcoSphere()
 * @model
 * @generated
 */
public interface IcoSphere extends GeometricStructure
{
	/**
	 * Returns the value of the '<em><b>Subdivision Count</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subdivision Count</em>' attribute.
	 * @see #setSubdivisionCount(int)
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage#getIcoSphere_SubdivisionCount()
	 * @model default="2"
	 * @generated
	 */
	int getSubdivisionCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.mesh.IcoSphere#getSubdivisionCount <em>Subdivision Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subdivision Count</em>' attribute.
	 * @see #getSubdivisionCount()
	 * @generated
	 */
	void setSubdivisionCount(int value);

} // IcoSphere
