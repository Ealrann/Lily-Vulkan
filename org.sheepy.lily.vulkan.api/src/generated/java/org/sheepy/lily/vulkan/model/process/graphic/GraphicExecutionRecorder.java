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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder#getIndex <em>Index</em>}</li>
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
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Command Buffer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer#getSubmittedBy <em>Submitted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffer</em>' reference.
	 * @see #setCommandBuffer(GraphicCommandBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionRecorder_CommandBuffer()
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer#getSubmittedBy
	 * @model opposite="submittedBy" required="true"
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
