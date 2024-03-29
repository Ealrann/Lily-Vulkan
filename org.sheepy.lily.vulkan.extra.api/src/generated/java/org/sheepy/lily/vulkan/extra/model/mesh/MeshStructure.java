/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure#getMeshes <em>Meshes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage#getMeshStructure()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MeshStructure<T extends Mesh> extends IMeshStructure
{
	/**
	 * Returns the value of the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meshes</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage#getMeshStructure_Meshes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<T> getMeshes();

} // MeshStructure
