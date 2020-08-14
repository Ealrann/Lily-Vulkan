/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.VulkanEngine#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.VulkanEngine#getProcesses <em>Processes</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.VulkanEngine#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanEngine()
 * @model
 * @generated
 */
public interface VulkanEngine extends IEngine, IResourceContainer
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanEngine_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.VulkanEngine#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IProcess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanEngine_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<IProcess> getProcesses();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanEngine_Features()
	 * @model
	 * @generated
	 */
	EList<EPhysicalDeviceFeature> getFeatures();

} // VulkanEngine
