/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage
 * @generated
 */
public interface GraphicExtraFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicExtraFactory eINSTANCE = org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mesh Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Provider</em>'.
	 * @generated
	 */
	MeshProvider createMeshProvider();

	/**
	 * Returns a new object of class '<em>Complex Mesh Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Mesh Provider</em>'.
	 * @generated
	 */
	ComplexMeshProvider createComplexMeshProvider();

	/**
	 * Returns a new object of class '<em>Vertex Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertex Data Provider</em>'.
	 * @generated
	 */
	VertexDataProvider createVertexDataProvider();

	/**
	 * Returns a new object of class '<em>Index Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Data Provider</em>'.
	 * @generated
	 */
	IndexDataProvider createIndexDataProvider();

	/**
	 * Returns a new object of class '<em>Uniform Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uniform Data Provider</em>'.
	 * @generated
	 */
	UniformDataProvider createUniformDataProvider();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphicExtraPackage getGraphicExtraPackage();

} //GraphicExtraFactory
