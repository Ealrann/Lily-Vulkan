/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.sheepy.lily.vulkan.model.process.IPipeline;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terrain Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer#getMeshProvider <em>Mesh Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getMeshRenderer()
 * @model
 * @generated
 */
public interface MeshRenderer extends GraphicsPipeline, IPipeline
{
	/**
	 * Returns the value of the '<em><b>Mesh Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Provider</em>' reference.
	 * @see #setMeshProvider(IMeshProvider)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getMeshRenderer_MeshProvider()
	 * @model
	 * @generated
	 */
	IMeshProvider getMeshProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer#getMeshProvider <em>Mesh Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh Provider</em>' reference.
	 * @see #getMeshProvider()
	 * @generated
	 */
	void setMeshProvider(IMeshProvider value);

} // TerrainRenderer
