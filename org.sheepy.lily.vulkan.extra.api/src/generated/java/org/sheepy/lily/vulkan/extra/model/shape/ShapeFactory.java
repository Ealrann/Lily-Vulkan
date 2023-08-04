/**
 */
package org.sheepy.lily.vulkan.extra.model.shape;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage
 * @generated
 */
public interface ShapeFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ShapeFactory eINSTANCE = org.sheepy.lily.vulkan.extra.model.shape.impl.ShapeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mesh Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Renderer</em>'.
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
	 * Returns a new object of class '<em>Geometric Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Geometric Mesh</em>'.
	 * @generated
	 */
	GeometricMesh createGeometricMesh();

	/**
	 * Returns a new object of class '<em>Icosahedron</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icosahedron</em>'.
	 * @generated
	 */
	Icosahedron createIcosahedron();

	/**
	 * Returns a new object of class '<em>Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sphere</em>'.
	 * @generated
	 */
	Sphere createSphere();

	/**
	 * Returns a new object of class '<em>Ico Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ico Sphere</em>'.
	 * @generated
	 */
	IcoSphere createIcoSphere();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ShapePackage getShapePackage();

} //ShapeFactory
