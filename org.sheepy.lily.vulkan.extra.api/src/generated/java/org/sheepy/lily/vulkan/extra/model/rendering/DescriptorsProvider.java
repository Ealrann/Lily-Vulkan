/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.IDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptors Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider#getDescriptors <em>Descriptors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDescriptorsProvider()
 * @model
 * @generated
 */
public interface DescriptorsProvider extends ResourceDescriptorProvider
{
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDescriptorsProvider_Descriptors()
	 * @model required="true"
	 * @generated
	 */
	EList<IDescriptor> getDescriptors();

} // DescriptorsProvider
