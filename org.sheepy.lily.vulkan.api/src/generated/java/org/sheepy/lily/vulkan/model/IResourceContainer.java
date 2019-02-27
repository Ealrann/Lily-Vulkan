/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.ecore.EObject;

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
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIResourceContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IResourceContainer extends EObject
{
	/**
	 * Returns the value of the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Pkg</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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

} // IResourceContainer
