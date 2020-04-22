/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.DescriptorPkg#getDescriptors <em>Descriptors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getDescriptorPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface DescriptorPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getDescriptorPkg_Descriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<IDescriptor> getDescriptors();

} // DescriptorPkg
