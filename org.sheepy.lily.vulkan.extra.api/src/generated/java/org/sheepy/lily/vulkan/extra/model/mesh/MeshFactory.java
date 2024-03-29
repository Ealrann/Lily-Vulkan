/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage
 * @generated
 */
public interface MeshFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeshFactory eINSTANCE = org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renderer</em>'.
	 * @generated
	 */
	MeshRenderer createMeshRenderer();

	/**
	 * Returns a new object of class '<em>IMesh Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IMesh Structure</em>'.
	 * @generated
	 */
	IMeshStructure createIMeshStructure();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MeshPackage getMeshPackage();

} //MeshFactory
