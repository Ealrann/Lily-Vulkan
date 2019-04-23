/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EDynamicState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DynamicState#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDynamicState()
 * @model
 * @generated
 */
public interface DynamicState extends EObject
{
	/**
	 * Returns the value of the '<em><b>States</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EDynamicState}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EDynamicState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EDynamicState
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDynamicState_States()
	 * @model unique="false"
	 * @generated
	 */
	EList<EDynamicState> getStates();

} // DynamicState
