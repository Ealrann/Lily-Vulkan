/**
 */
package org.sheepy.lily.vulkan.model;

import org.sheepy.lily.core.model.cadence.ICadenceTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait Process Idle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.WaitProcessIdle#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getWaitProcessIdle()
 * @model
 * @generated
 */
public interface WaitProcessIdle extends ICadenceTask
{
	/**
	 * Returns the value of the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' reference.
	 * @see #setProcess(IProcess)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getWaitProcessIdle_Process()
	 * @model required="true"
	 * @generated
	 */
	IProcess getProcess();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.WaitProcessIdle#getProcess <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(IProcess value);

} // WaitProcessIdle
