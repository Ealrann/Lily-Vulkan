/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Mesh Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getVertexDataProvider <em>Vertex Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getIndexDataProvider <em>Index Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getUniformDataProvider <em>Uniform Data Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getComplexMeshProvider()
 * @model
 * @generated
 */
public interface ComplexMeshProvider extends MeshProvider
{
	/**
	 * Returns the value of the '<em><b>Vertex Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Data Provider</em>' containment reference.
	 * @see #setVertexDataProvider(VertexDataProvider)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getComplexMeshProvider_VertexDataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VertexDataProvider getVertexDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getVertexDataProvider <em>Vertex Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Data Provider</em>' containment reference.
	 * @see #getVertexDataProvider()
	 * @generated
	 */
	void setVertexDataProvider(VertexDataProvider value);

	/**
	 * Returns the value of the '<em><b>Index Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Data Provider</em>' containment reference.
	 * @see #setIndexDataProvider(IndexDataProvider)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getComplexMeshProvider_IndexDataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IndexDataProvider getIndexDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getIndexDataProvider <em>Index Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Data Provider</em>' containment reference.
	 * @see #getIndexDataProvider()
	 * @generated
	 */
	void setIndexDataProvider(IndexDataProvider value);

	/**
	 * Returns the value of the '<em><b>Uniform Data Provider</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.graphic.model.UniformDataProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uniform Data Provider</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getComplexMeshProvider_UniformDataProvider()
	 * @model containment="true"
	 * @generated
	 */
	EList<UniformDataProvider> getUniformDataProvider();

} // ComplexMeshProvider
