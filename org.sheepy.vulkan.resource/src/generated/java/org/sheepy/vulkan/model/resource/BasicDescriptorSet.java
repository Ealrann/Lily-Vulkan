/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.BasicDescriptorSet#getDescriptors <em>Descriptors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBasicDescriptorSet()
 * @model
 * @generated
 */
public interface BasicDescriptorSet extends DescriptorSet
{
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.IDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' reference list.
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBasicDescriptorSet_Descriptors()
	 * @model required="true"
	 * @generated
	 */
	EList<IDescriptor> getDescriptors();

} // DescriptorSet
