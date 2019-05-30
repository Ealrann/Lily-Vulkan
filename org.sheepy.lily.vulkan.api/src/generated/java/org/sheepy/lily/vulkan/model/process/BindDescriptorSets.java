/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Descriptor Sets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getDescriptorSets <em>Descriptor Sets</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets()
 * @model
 * @generated
 */
public interface BindDescriptorSets extends IPipelineTask
{

	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets_DescriptorSets()
	 * @model
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();
} // BindDescriptorSets
