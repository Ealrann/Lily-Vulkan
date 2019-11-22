/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Draw Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask#getVertexProviders <em>Vertex Providers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderDrawTask()
 * @model
 * @generated
 */
public interface RenderDrawTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Vertex Providers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Providers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderDrawTask_VertexProviders()
	 * @model required="true"
	 * @generated
	 */
	EList<VertexProvider<?>> getVertexProviders();

} // RenderDrawTask
