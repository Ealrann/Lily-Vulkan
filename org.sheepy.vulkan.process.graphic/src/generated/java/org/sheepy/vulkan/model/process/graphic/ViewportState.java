/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewport State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ViewportState#getViewports <em>Viewports</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ViewportState#getScissors <em>Scissors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewportState()
 * @model
 * @generated
 */
public interface ViewportState extends EObject
{

	/**
	 * Returns the value of the '<em><b>Viewports</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.graphic.Viewport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewports</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewportState_Viewports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Viewport> getViewports();

	/**
	 * Returns the value of the '<em><b>Scissors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.graphic.Scissor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scissors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scissors</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getViewportState_Scissors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scissor> getScissors();
} // ViewportState
