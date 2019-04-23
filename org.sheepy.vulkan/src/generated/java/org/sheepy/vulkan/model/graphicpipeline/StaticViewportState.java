/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Viewport State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getViewports <em>Viewports</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getScissors <em>Scissors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getStaticViewportState()
 * @model
 * @generated
 */
public interface StaticViewportState extends ViewportState
{
	/**
	 * Returns the value of the '<em><b>Viewports</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.graphicpipeline.Viewport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewports</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getStaticViewportState_Viewports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Viewport> getViewports();

	/**
	 * Returns the value of the '<em><b>Scissors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.graphicpipeline.Scissor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scissors</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getStaticViewportState_Scissors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scissor> getScissors();

} // StaticViewportState
