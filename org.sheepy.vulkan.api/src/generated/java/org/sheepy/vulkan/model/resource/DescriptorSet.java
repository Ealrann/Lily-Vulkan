/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.common.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.DescriptorSet#getDescriptors <em>Descriptors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getDescriptorSet()
 * @model
 * @generated
 */
public interface DescriptorSet extends LNamedElement
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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getDescriptorSet_Descriptors()
	 * @model required="true"
	 * @generated
	 */
	EList<IDescriptor> getDescriptors();
} // DescriptorSet
