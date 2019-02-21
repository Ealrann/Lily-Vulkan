/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.ResourceContainer#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getResourceContainer()
 * @model
 * @generated
 */
public interface ResourceContainer extends EObject
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getResourceContainer_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<IResource> getResources();

} // ResourceContainer
