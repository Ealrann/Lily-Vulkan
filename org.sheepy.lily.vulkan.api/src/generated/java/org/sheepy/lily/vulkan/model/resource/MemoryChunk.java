/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.resource.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Chunk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.MemoryChunk#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getMemoryChunk()
 * @model
 * @generated
 */
public interface MemoryChunk extends IResource
{
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getMemoryChunk_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<IMemoryChunkPart> getParts();

} // MemoryChunk
