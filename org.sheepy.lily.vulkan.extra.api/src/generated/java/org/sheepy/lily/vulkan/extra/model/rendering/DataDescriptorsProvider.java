/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Descriptors Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider#getDataDescriptors <em>Data Descriptors</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptorsProvider()
 * @model
 * @generated
 */
public interface DataDescriptorsProvider extends ResourceDescriptorProvider
{
	/**
	 * Returns the value of the '<em><b>Data Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Descriptors</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptorsProvider_DataDescriptors()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DataDescriptor> getDataDescriptors();

} // DataDescriptorsProvider
