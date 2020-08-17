/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import java.nio.ByteBuffer;

import org.sheepy.lily.vulkan.model.IVulkanResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getConstantBuffer()
 * @model
 * @generated
 */
public interface ConstantBuffer extends IVulkanResource
{
	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getConstantBuffer_Data()
	 * @model unique="false" dataType="org.sheepy.lily.vulkan.model.vulkanresource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getData();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(ByteBuffer value);

} // ConstantBuffer
