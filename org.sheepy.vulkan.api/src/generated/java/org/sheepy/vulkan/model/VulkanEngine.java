/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.VulkanEngine#getSharedResources <em>Shared Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanEngine#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanEngine()
 * @model
 * @generated
 */
public interface VulkanEngine extends EObject
{
	/**
	 * Returns the value of the '<em><b>Shared Resources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Resources</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Resources</em>' containment reference.
	 * @see #setSharedResources(SharedResources)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanEngine_SharedResources()
	 * @model containment="true"
	 * @generated
	 */
	SharedResources getSharedResources();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanEngine#getSharedResources <em>Shared Resources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Resources</em>' containment reference.
	 * @see #getSharedResources()
	 * @generated
	 */
	void setSharedResources(SharedResources value);

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.IProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanEngine_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<IProcess> getProcesses();

} // VulkanEngine
