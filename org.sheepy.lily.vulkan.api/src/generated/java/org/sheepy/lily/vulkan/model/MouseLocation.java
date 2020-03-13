/**
 */
package org.sheepy.lily.vulkan.model;

import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.MouseLocation#getVulkanEngine <em>Vulkan Engine</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getMouseLocation()
 * @model
 * @generated
 */
public interface MouseLocation extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Vulkan Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vulkan Engine</em>' reference.
	 * @see #setVulkanEngine(VulkanEngine)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getMouseLocation_VulkanEngine()
	 * @model required="true"
	 * @generated
	 */
	VulkanEngine getVulkanEngine();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.MouseLocation#getVulkanEngine <em>Vulkan Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vulkan Engine</em>' reference.
	 * @see #getVulkanEngine()
	 * @generated
	 */
	void setVulkanEngine(VulkanEngine value);

} // MouseLocation
