/**
 */
package org.sheepy.lily.vulkan.model;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.model.resource.ResourcePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IResource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.IResourceContainer#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.IResourceContainer#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIResourceContainer()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface IResourceContainer extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #setResourcePkg(ResourcePkg)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIResourceContainer_ResourcePkg()
	 * @model containment="true"
	 * @generated
	 */
	ResourcePkg getResourcePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IResourceContainer#getResourcePkg <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #getResourcePkg()
	 * @generated
	 */
	void setResourcePkg(ResourcePkg value);

	/**
	 * Returns the value of the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Pkg</em>' containment reference.
	 * @see #setDescriptorPkg(DescriptorPkg)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIResourceContainer_DescriptorPkg()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorPkg getDescriptorPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IResourceContainer#getDescriptorPkg <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Pkg</em>' containment reference.
	 * @see #getDescriptorPkg()
	 * @generated
	 */
	void setDescriptorPkg(DescriptorPkg value);

} // IResourceContainer
