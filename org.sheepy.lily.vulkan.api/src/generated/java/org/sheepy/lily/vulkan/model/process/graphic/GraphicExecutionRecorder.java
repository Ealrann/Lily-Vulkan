/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder#getCommandBuffer <em>Command Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder()
 * @model
 * @generated
 */
public interface GraphicExecutionRecorder extends ExecutionRecorder
{

	/**
	 * Returns the value of the '<em><b>Command Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffer</em>' reference.
	 * @see #setCommandBuffer(GraphicCommandBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder_CommandBuffer()
	 * @model required="true"
	 * @generated
	 */
	GraphicCommandBuffer getCommandBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder#getCommandBuffer <em>Command Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Buffer</em>' reference.
	 * @see #getCommandBuffer()
	 * @generated
	 */
	void setCommandBuffer(GraphicCommandBuffer value);
} // GraphicExecutionRecorder
