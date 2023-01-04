/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager#getRecorders <em>Recorders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager#getIndexCount <em>Index Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager#getCommandBuffers <em>Command Buffers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionManager()
 * @model
 * @generated
 */
public interface ComputeExecutionManager extends ProcessExecutionManager
{

	/**
	 * Returns the value of the '<em><b>Recorders</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recorders</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionManager_Recorders()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<ComputeExecutionRecorder> getRecorders();

	/**
	 * Returns the value of the '<em><b>Index Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Count</em>' attribute.
	 * @see #setIndexCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionManager_IndexCount()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getIndexCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager#getIndexCount <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Count</em>' attribute.
	 * @see #getIndexCount()
	 * @generated
	 */
	void setIndexCount(int value);

	/**
	 * Returns the value of the '<em><b>Command Buffers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Buffers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeExecutionManager_CommandBuffers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputeCommandBuffer> getCommandBuffers();
} // ComputeExecutionManager
