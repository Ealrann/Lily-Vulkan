/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FixedBufferReference#getBuffers <em>Buffers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFixedBufferReference()
 * @model
 * @generated
 */
public interface FixedBufferReference extends IBufferReference
{
	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.IBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFixedBufferReference_Buffers()
	 * @model
	 * @generated
	 */
	EList<IBuffer> getBuffers();

} // FixedBufferReference
