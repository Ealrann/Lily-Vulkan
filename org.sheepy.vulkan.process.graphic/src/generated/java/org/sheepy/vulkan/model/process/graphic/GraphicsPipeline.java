/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.process.AbstractPipeline;

import org.sheepy.vulkan.model.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline()
 * @model abstract="true"
 * @generated
 */
public interface GraphicsPipeline extends AbstractPipeline, IGraphicsPipeline
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

} // GraphicsPipeline
