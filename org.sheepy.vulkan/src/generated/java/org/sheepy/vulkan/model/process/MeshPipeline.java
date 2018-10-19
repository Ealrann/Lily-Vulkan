/**
 */
package org.sheepy.vulkan.model.process;

import org.sheepy.vulkan.model.resource.MeshBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mesh Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.MeshPipeline#getMesh <em>Mesh</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getMeshPipeline()
 * @model
 * @generated
 */
public interface MeshPipeline extends GraphicsPipeline
{
	/**
	 * Returns the value of the '<em><b>Mesh</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh</em>' reference.
	 * @see #setMesh(MeshBuffer)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getMeshPipeline_Mesh()
	 * @model
	 * @generated
	 */
	MeshBuffer getMesh();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.MeshPipeline#getMesh <em>Mesh</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh</em>' reference.
	 * @see #getMesh()
	 * @generated
	 */
	void setMesh(MeshBuffer value);

} // MeshPipeline
