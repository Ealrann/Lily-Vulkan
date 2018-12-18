/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Resources</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.SharedResources#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getSharedResources()
 * @model
 * @generated
 */
public interface SharedResources extends IEnginePart
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.IResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.VulkanPackage#getSharedResources_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<IResource> getResources();

} // SharedResources
