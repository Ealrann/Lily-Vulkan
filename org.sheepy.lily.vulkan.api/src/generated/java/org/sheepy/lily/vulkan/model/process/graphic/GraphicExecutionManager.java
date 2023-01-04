/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager#getRecorders <em>Recorders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager#getCommandBuffers <em>Command Buffers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionManager()
 * @model
 * @generated
 */
public interface GraphicExecutionManager extends ProcessExecutionManager
{

	/**
	 * Returns the value of the '<em><b>Recorders</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recorders</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionManager_Recorders()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<GraphicExecutionRecorder> getRecorders();

	/**
	 * Returns the value of the '<em><b>Command Buffers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicExecutionManager_CommandBuffers()
	 * @model containment="true"
	 * @generated
	 */
	EList<GraphicCommandBuffer> getCommandBuffers();
} // GraphicExecutionManager
