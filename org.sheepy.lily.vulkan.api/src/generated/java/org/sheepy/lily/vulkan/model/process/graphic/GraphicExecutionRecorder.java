/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder#getCommandBuffers <em>Command Buffers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder()
 * @model
 * @generated
 */
public interface GraphicExecutionRecorder extends ExecutionRecorder
{

	/**
	 * Returns the value of the '<em><b>Command Buffers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder_CommandBuffers()
	 * @model required="true"
	 * @generated
	 */
	EList<GraphicCommandBuffer> getCommandBuffers();
} // GraphicExecutionRecorder
