/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getViewports <em>Viewports</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getScissors <em>Scissors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getStaticViewportState()
 * @model
 * @generated
 */
public interface StaticViewportState extends ViewportState
{
	/**
	 * Returns the value of the '<em><b>Viewports</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.Viewport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewports</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getStaticViewportState_Viewports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Viewport> getViewports();

	/**
	 * Returns the value of the '<em><b>Scissors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.Scissor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scissors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scissors</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getStaticViewportState_Scissors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scissor> getScissors();

} // StaticViewportState
