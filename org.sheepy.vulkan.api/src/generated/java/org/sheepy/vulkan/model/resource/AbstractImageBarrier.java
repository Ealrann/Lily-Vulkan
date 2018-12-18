/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.AbstractImageBarrier#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getAbstractImageBarrier()
 * @model abstract="true"
 * @generated
 */
public interface AbstractImageBarrier extends Barrier
{
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.ImageTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getAbstractImageBarrier_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImageTransition> getTransitions();

} // AbstractImageBarrier
