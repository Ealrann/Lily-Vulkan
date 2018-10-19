/**
 */
package org.sheepy.vulkan.demo.model;

import org.sheepy.vulkan.model.resource.IndexedBuffer;
import org.sheepy.vulkan.model.resource.Texture;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mesh Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.demo.model.MeshBuffer#getTexture <em>Texture</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.demo.model.VulkanDemoPackage#getMeshBuffer()
 * @model
 * @generated
 */
public interface MeshBuffer extends IndexedBuffer
{
	/**
	 * Returns the value of the '<em><b>Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture</em>' reference.
	 * @see #setTexture(Texture)
	 * @see org.sheepy.vulkan.demo.model.VulkanDemoPackage#getMeshBuffer_Texture()
	 * @model
	 * @generated
	 */
	Texture getTexture();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.demo.model.MeshBuffer#getTexture <em>Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture</em>' reference.
	 * @see #getTexture()
	 * @generated
	 */
	void setTexture(Texture value);

} // MeshBuffer
