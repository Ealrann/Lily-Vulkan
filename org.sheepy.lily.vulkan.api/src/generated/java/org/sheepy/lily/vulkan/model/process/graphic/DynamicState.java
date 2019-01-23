/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.vulkan.model.enumeration.EDynamicState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicState#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDynamicState()
 * @model
 * @generated
 */
public interface DynamicState extends EObject
{
	/**
	 * Returns the value of the '<em><b>States</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.enumeration.EDynamicState}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EDynamicState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EDynamicState
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDynamicState_States()
	 * @model unique="false"
	 * @generated
	 */
	EList<EDynamicState> getStates();

} // DynamicState
