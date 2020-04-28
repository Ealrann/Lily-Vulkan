/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.DescriptorPool#getDescriptorSets <em>Descriptor Sets</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getDescriptorPool()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface DescriptorPool extends ILilyEObject
{

	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getDescriptorPool_DescriptorSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();
} // DescriptorPool
