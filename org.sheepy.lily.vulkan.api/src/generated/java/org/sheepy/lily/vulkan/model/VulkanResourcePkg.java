/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.VulkanResourcePkg#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanResourcePkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface VulkanResourcePkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IVulkanResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getVulkanResourcePkg_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<IVulkanResource> getResources();

} // VulkanResourcePkg
