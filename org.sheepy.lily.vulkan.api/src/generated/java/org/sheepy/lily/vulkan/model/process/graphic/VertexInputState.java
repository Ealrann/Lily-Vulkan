/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Input State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.VertexInputState#getInputDescriptor <em>Input Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexInputState()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface VertexInputState extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Input Descriptor</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Descriptor</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexInputState_InputDescriptor()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputDescriptor> getInputDescriptor();

} // VertexInputState
