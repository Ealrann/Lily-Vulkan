/**
 */
package org.sheepy.lily.vulkan.model;

import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IProcess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.IProcess#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.IProcess#getQueuePriority <em>Queue Priority</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.IProcess#getCadence <em>Cadence</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IProcess extends IResourceContainer, LNamedElement, IExecutionManager
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IProcess#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Queue Priority</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Priority</em>' attribute.
	 * @see #setQueuePriority(float)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess_QueuePriority()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getQueuePriority();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IProcess#getQueuePriority <em>Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Priority</em>' attribute.
	 * @see #getQueuePriority()
	 * @generated
	 */
	void setQueuePriority(float value);

	/**
	 * Returns the value of the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cadence</em>' containment reference.
	 * @see #setCadence(ICadence)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess_Cadence()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ICadence getCadence();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IProcess#getCadence <em>Cadence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cadence</em>' containment reference.
	 * @see #getCadence()
	 * @generated
	 */
	void setCadence(ICadence value);

} // IProcess
